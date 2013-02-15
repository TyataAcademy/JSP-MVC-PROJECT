package com.ksquareit.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBUtil {
	public static Connection con = null;

	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");   
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
		if(con!=null){
			System.out.println("Connected!!!");
			//getCoffeeName(con);
			return con;
		}else{
			return con;
		}
	}//end of method
	
	public static ArrayList<String> getCoffeeName(Connection con) throws SQLException{
	//public static void getCoffeeName(Connection con) throws SQLException{
		Statement st = null;
		ResultSet rs = null;
		ArrayList<String> cofList = new ArrayList<String>();
		
		st = con.createStatement();
		rs = st.executeQuery("Select COF_NAME from Coffees;");
		
		while(rs.next()){
			  //String cofname = rs.getString("COF_NAME");		      
		      System.out.println(rs.getString("COF_NAME"));
		      cofList.add(rs.getString("COF_NAME"));
		}
		
		return cofList;
	}//end of getCoffeeName
	
	public static Coffee test(String cn, Connection con) throws SQLException{
		Statement stObj = null;
		ResultSet rsObj = null;
		System.out.println("You are here in test method: \"cn\"");
	    String selectString = "select * from coffees where COF_NAME = \""+cn+"\"";		
	    stObj = con.createStatement();
	    rsObj = stObj.executeQuery(selectString);
	    System.out.println("\n----------------------------------------\n");
	    Coffee cofObj = null;
	    while(rsObj.next()){
	    		
			  String cofname = rsObj.getString("COF_NAME");
		      Integer supid = rsObj.getInt("SUP_ID");
		      Double price = rsObj.getDouble("PRICE");
		      Integer sales = rsObj.getInt("SALES");
		      Integer total = rsObj.getInt("TOTAL");
		      
		      System.out.println("Coffee: " + cofname);
		      System.out.println("SUP ID: " + supid);
		      System.out.println("Price: " + price);
		      System.out.println("Sales: " + sales);
		      System.out.println("Total: " + total);
    		  cofObj  = new Coffee(cofname,supid,price,sales,total);		      
	    }    
	    return cofObj;
	}//end of test method.

	
	public static ArrayList<Coffee> testAll(Connection con) throws SQLException{
		Statement stObj = null;
		ResultSet rsObj = null;
		ArrayList<Coffee> arrList = new ArrayList<Coffee>();

		System.out.println("You are here in testALL method:");
	    String selectString = "select * from coffees";		
	    stObj = con.createStatement();
	    rsObj = stObj.executeQuery(selectString);
	    System.out.println("\n------------------ALL----------------------\n");

	    while(rsObj.next()){
			  String cofname = rsObj.getString("COF_NAME");
		      Integer supid = rsObj.getInt("SUP_ID");
		      Double price = rsObj.getDouble("PRICE");
		      Integer sales = rsObj.getInt("SALES");
		      Integer total = rsObj.getInt("TOTAL");
		      
		      System.out.println("Coffee: " + cofname);
		      System.out.println("SUP ID: " + supid);
		      System.out.println("Price: " + price);
		      System.out.println("Sales: " + sales);
		      System.out.println("Total: " + total);
    		  Coffee cofObj  = new Coffee(cofname,supid,price,sales,total);
    		  arrList.add(cofObj);
	    }    
	    return arrList;
	}//end of test method.

}//end of class
