# Customize public images
FROM maven:3.8.4-openjdk-17 as builder
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
FROM tomcat as todo-app
RUN rm -rf /usr/local/tomcat/webapps/
COPY --from=builded /app/target/*.war /usr/local/tomcat/webapps/todo.war
CMD ["catalina.sh", "run"]