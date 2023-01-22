FROM debian:10

# Install necessary packages
RUN apt-get update && apt upgrade -y && \
    apt-get install -y wget && \
    apt-get install -y gnupg2 && \
    apt-get install -y nano && \
    apt-get install -y default-jdk && \
    apt-get install -y git

# Install Maven
RUN wget https://downloads.apache.org/maven/maven-3/3.8.7/binaries/apache-maven-3.8.7-bin.tar.gz && \
    tar -zxvf apache-maven-3.8.7-bin.tar.gz && \
    cp -r apache-maven-3.8.7 /opt/maven

COPY maven.sh /etc/profile.d/maven.sh
# Maven
#RUN cp .devcontainer/maven.sh /etc/profile.d/maven.sh
#RUN source /etc/profile.d/maven.sh

# ls -a /opt/maven/conf/logging/simplelogger.properties ls


# Update package list and install required packages
#RUN apt-get update && apt-get install -y alien libaio1 unzip

# Download Oracle Database XE installer and convert it to a .deb package
#RUN wget https://download.oracle.com/otn/linux/oracle19c/xe/oracle-xe-19c-1.0-1.x86_64.rpm && \
#    alien -i oracle-xe-19c-1.0-1.x86_64.rpm

# Configure and start Oracle XE
#RUN /etc/init.d/oracle-xe-19c configure && \
#    echo "export ORACLE_HOME=/u01/app/oracle/product/19c/dbhomeXE" >> ~/.bashrc && \
#    echo "export PATH=$ORACLE_HOME/bin:$PATH" >> ~/.bashrc && \
#    echo "export ORACLE_SID=XE" >> ~/.bashrc

# Create new user "pantry" and grant permissions
#RUN echo "create user pantry identified by pantry;" | sqlplus -S / as sysdba && \
#    echo "grant all privileges to pantry;" | sqlplus -S / as sysdba

#CMD ["/etc/init.d/oracle-xe-19c", "start"]


# NEW
#RUN apt-get install -y oracle-database-xe-21c
#ENV ORACLE_HOME /opt/oracle/product/21c/dbhomeXE
#ENV PATH $ORACLE_HOME/bin:$PATH

#RUN groupadd -g 54321 oracle && \
#    useradd -g oracle -u 54321 -d /home/oracle oracle

#CMD /etc/init.d/oracle-xe-21c configure && /etc/init.d/oracle-xe-21c start && tail -f /dev/null

EXPOSE 1521 8080

#USER oracle