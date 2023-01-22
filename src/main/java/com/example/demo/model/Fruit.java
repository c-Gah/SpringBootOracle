package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.ParameterMode;

import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Configuration
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedStoredProcedureQuery(
        name = "add_fruit",
        procedureName = "ADD_FRUIT",
        parameters = {
            @StoredProcedureParameter(name = "p_name", type = String.class, mode = ParameterMode.IN),
            @StoredProcedureParameter(name = "p_color", type = String.class, mode = ParameterMode.IN),
            @StoredProcedureParameter(name = "p_price", type = Double.class, mode = ParameterMode.IN),
        },
        resultClasses = { Fruit.class }
)
public class Fruit {
    
    @Id
    private Integer id;
    private String name;
    private String color;
    private Float price;
}
