package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class mysql {
public static void main(String[] args) throws Exception {
	// connecting java and mysql
	
	
	
	Class.forName("com.mysql.jdbc.Driver");
//	Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root"); // if database is not there 

	Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pra","root","root");// if database is already present 
Statement statement= connection.createStatement();

// creating a database

// firstly crate the database by using following syntax then menstion the database name in the getconnection as shown above 
statement.execute("create database practice");
System.out.println("crated");


// to crate a table 

statement.execute("   create table users(id  int(3) primary key,name varchar(20) not null,email varchar(20),country varchar(20),password varchar(20))");
System.out.println("table created");

// to insert a record


statement.execute("insert into users values (1,'Neeraj1','neeraj@123','india','12345')");
System.out.println("inserted ");



// to fetch all  record



  ResultSet a =statement.executeQuery("select * from users");
  while (a.next()) {
System.out.println(a.getInt("id"));
System.out.println(a.getString("name"));
System.out.println(a.getString("email"));
System.out.println(a.getString("country"));
	
}
System.out.println("###############record fetched###############");




// update


statement.executeUpdate("update users set country ='barath' where name ='Neeraj'");
System.out.println("updated");



// to delete a record



statement.execute("delete from users where name ='Neeraj1'");
System.out.println("deleted ");








}}