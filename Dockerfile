# Customize public images
FROM 3.8.4-openjdk-17
WORKDIR /app

# Build app without runnung unit test
FROM builder as builded
COPY . /app
RUN mvn clean
RUN mvn -Dmaven.test.skip=true install

# Run unit tests
FROM builded as tested
COPY . /app
RUN mvn test

# Create application container
FROM tomcat
RUN rm -rf /usr/local/tomcat/webapps/
COPY *.war /usr/local/tomcat/webapps/todo.war
CMD ["catalina.sh", "run"]