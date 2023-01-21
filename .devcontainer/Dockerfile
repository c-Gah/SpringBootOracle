FROM debian:10

# Install necessary packages
RUN apt-get update && apt upgrade -y && apt-get install -y wget
RUN apt-get install -y gnupg2
RUN apt-get install -y nano
RUN apt-get install -y default-jdk
RUN apt-get install -y git

# Update package list and install required packages
RUN apt-get update && apt-get install -y alien libaio1 unzip

# Download Oracle Database XE installer and convert it to a .deb package
RUN wget https://download.oracle.com/otn/linux/oracle19c/xe/oracle-xe-19c-1.0-1.x86_64.rpm && \
    alien -i oracle-xe-19c-1.0-1.x86_64.rpm

# Configure and start Oracle XE
RUN /etc/init.d/oracle-xe-19c configure && \
    echo "export ORACLE_HOME=/u01/app/oracle/product/19c/dbhomeXE" >> ~/.bashrc && \
    echo "export PATH=$ORACLE_HOME/bin:$PATH" >> ~/.bashrc && \
    echo "export ORACLE_SID=XE" >> ~/.bashrc

# Create new user "pantry" and grant permissions
RUN echo "create user pantry identified by pantry;" | sqlplus -S / as sysdba && \
    echo "grant all privileges to pantry;" | sqlplus -S / as sysdba

CMD ["/etc/init.d/oracle-xe-19c", "start"]