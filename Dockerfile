FROM tomcat
RUN rm -rf /usr/local/tomcat/webapps/
COPY todo-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/todo.war
CMD ["catalina.sh", "run"]
