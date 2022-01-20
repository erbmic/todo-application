FROM tomcat
RUN rm -rf /usr/local/tomcat/webapps/
COPY target/*.war /usr/local/tomcat/webapps/todo.war
CMD ["catalina.sh", "run"]
