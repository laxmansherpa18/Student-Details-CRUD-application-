Technology used in development ( Java Servlet JDBC MySQL html css JS-fetch apache-tomcat)
java/student package(folder) contains all the Java Servlet file
in the css folder thier is .css file for styling the html page.
have two html page with name(index.html and view.html) in the view.html the table is create in the run time through the View.java servlet


for use... have to changed
in the DBConnectoin class. "username" section set your username  usually its.. "root"
PASSWORD = Enter your password inside the " " double-cote
add the servlet api,MySQL connector,tomcat-jdbc-jar file in the library->classpath.

create the table 
query->  CREATE TABLE STUDENT (
    id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    roll_no VARCHAR(20),
    gender VARCHAR(10),
    Father_name VARCHAR(100),
    image BLOB
);
