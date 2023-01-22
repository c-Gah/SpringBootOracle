package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Fruit;
import com.example.demo.repository.FruitRepository;

import oracle.jdbc.OracleTypes;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.sql.DataSource;

@Service
public class FoodService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private FruitRepository fruitRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Fruit> callOraclePackage() {
        String sql = "SELECT * FROM fruit";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Fruit.class));
    }

    public List<Double> callOraclePackage2() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("GET_APPLE_PRICE")
                .declareParameters(new SqlOutParameter("p_cursor", OracleTypes.CURSOR, new RowMapper<Double>() {
                    @Override
                    public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getDouble("PRICE");
                    }
                }));
        Map<String, Object> out = simpleJdbcCall.execute();
        List<Double> result = (List<Double>) out.get("p_cursor");

        return result;
    }

    public List<Double> callOraclePackage25() {
        System.out.println("callOraclePackage3 = ");

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("food_management")
                .withProcedureName("get_apple_prices")
                .declareParameters(new SqlOutParameter("p_cursor", OracleTypes.CURSOR, new RowMapper<Double>() {
                    @Override
                    public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getDouble("PRICE");
                    }
                }));
        Map<String, Object> out = simpleJdbcCall.execute();
        List<Double> ttt = (List<Double>) out.get("p_cursor");

        System.out.println(ttt.size());

        return ttt;
    }

    public List<Double> callOraclePackage3() {
        System.out.println("callOraclePackage3 = ");

        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("food_management")
                .withProcedureName("get_apple_prices2")
                .declareParameters(new SqlOutParameter("p_cursor", OracleTypes.CURSOR, new RowMapper<Double>() {
                    @Override
                    public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getDouble("PRICE");
                    }
                }));
        Map<String, Object> out = simpleJdbcCall.execute();
        List<Double> ttt = (List<Double>) out.get("p_cursor");

        System.out.println(ttt.size());

        return ttt;
    }
    /*
     * public String callOraclePackage3() {
     * final String sql = "BEGIN food_management.get_apple_prices(); END;";
     * 
     * return "" + jdbcTemplate.queryForObject(sql, new Object[] { , Double.class);
     * 
     * }
     */

    public String callOraclePackage4() {
        final String sql = "SELECT id, name, color, price FROM fruit";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new Fruit(rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("COLOR"),
                        rs.getFloat("PRICE")))
                .get(0).getName();

    }

    @Transactional(readOnly = true)
    public String callOraclePackage5() throws Exception {
        String returnValue = "";

        System.out.println("DATASOURCE = " + dataSource);
        System.out.println("FruitRepository COUNTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT= " + fruitRepository);
        System.out.println(
                "FruitRepository COUNTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT= " + fruitRepository.count());
        System.out.println(
                "FruitRepository COUNTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT 222= " + fruitRepository.count());

        System.out.println("DATASOURCE 0000 = " + fruitRepository.findByName("Apple"));
        System.out.println("DATASOURCE qqqq = " + fruitRepository.findAll());

        System.out.println("\n1.Apply()...");
        // for (Fruit fruit : fruitRepository.findAll()) {
        // returnValue = returnValue + fruit.getName();
        // System.out.println(fruit);
        // }
        System.out.println("DATASOURCE 222 = " + dataSource);

        return returnValue;
    }

    public String callOraclePackage6() {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("add_fruit");
        query.setParameter("p_name", "test");
        query.setParameter("p_color", "blue");
        query.setParameter("p_price", -2.00);

        List<Fruit> fruits = query.getResultList();

        return "test";
    }

    public String getTestData() {
        return "This is test data 22";
    }

}