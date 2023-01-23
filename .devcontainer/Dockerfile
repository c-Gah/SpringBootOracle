FROM oraclelinux:8

RUN dnf update -y && \
    dnf upgrade -y

# Set the working directory
WORKDIR /opt

RUN dnf install -y wget

# Download the Oracle Database XE 21c rpm package
RUN wget https://download.oracle.com/otn-pub/otn_software/db-express/oracle-database-xe-21c-1.0-1.ol7.x86_64.rpm

# Install the Oracle Database XE 21c package
RUN dnf install -y oracle-database-xe-21c-1.0-1.ol7.x86_64.rpm

# Environment variables
#ENV ORACLE_HOME=/opt/oracle/product/21c/dbhomeXE \
#    ORACLE_SID=XE \
#    PATH=$ORACLE_HOME/bin:$PATH

# Expose the Oracle listener port
#EXPOSE 1521

# Start the Oracle listener
#CMD ["/opt/oracle/product/21c/dbhomeXE/bin/lsnrctl", "start"]
