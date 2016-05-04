package restaurant;
//handles MySql to Java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
 
public class JDBCMySQLConnection
{
  static
  {
    try
    {
      
      Class.forName("com.mysql.jdbc.Driver");
    } 
    catch (ClassNotFoundException cnf) 
    {
      System.out.println("Driver could not be loaded: " + cnf);
    }
  }
//  private static String connectionUrl = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
//  private static String dbUser = "root";
//  private static String dbPwd = "1234";
//  private static Connection conn;


public int loginfuction(String n, String p) {
	// TODO Auto-generated method stub
	  String connectionUrl = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
	  String dbUser = "root";
	  String dbPwd = "1234";
	  Connection conn;
	ResultSet rs;
	String queryString = "SELECT number,password FROM customer;";
	 try
	    {
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	 
	     
	     // stmt.executeUpdate("INSERT INTO customer VALUES ('1238','sahil','12','26','hello@gmail.com','1234','9711442853');");
	 
	      int flag=0;
	      rs = stmt.executeQuery(queryString);
	      while(rs.next())
	      {
	    	 
	    	  if(n.equals(rs.getString("number")))
	    	  {   flag=1;
	    		  if(p.equals(rs.getString("password")))
	    				  {
	    			      System.out.println("Pass");
	    			      return 1;
	    				  }
	    	  }
	    	 
	            
	      }
	      if(flag==0)
    	  {
    		  System.out.println("Username not found");
    		  return -1;
    	  }
    	  else if(flag==1)
    	  {
    		  System.out.println("Wrong credtianls");
    		  return 0;
    	  }
	      
	      if (conn != null)
	      {
	        conn.close();
	        conn = null;
	      }
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }
	 return 0;
}//login function


public int registerfunction(String na, int i, String email, String npass, String nup, String id) {
	// TODO Auto-generated method stub
	 String connectionUrl = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
	  String dbUser = "root";
	  String dbPwd = "1234";
	  Connection conn;
	  System.out.println("Register Function called");
	  try
	    {
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	 
	       String queryString = "SELECT number FROM customer;";
		     
	         ResultSet rs;
		     rs = stmt.executeQuery(queryString);
		      while(rs.next())
		      {
		    	  if(rs.getString("number").equals(nup))
		    	  {
		    		  return 0;
		    	  }
		    	  else
		    	  {   
		    		  String query= "insert into customer values('"+id+"','"+na+"','"+0+"','"+email+"','"+npass+"','"+nup+"');";
		   	          System.out.println(query);
		    		  stmt.executeUpdate(query);
		    		  return 1;
		    	  }
		      
		      }
		    	 
	      if (conn != null)
	      {
	        conn.close();
	        conn = null;
	      }
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }
	
	return -1;
}//signupfunction

private ObservableList<Table> menudata = FXCollections.observableArrayList();
public ObservableList<Table> getdata()
{
	String connectionUrl = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
	  String dbUser = "root";
	  String dbPwd = "1234";
	  Connection conn;
	  try
	    {
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	 
	       String queryString = "SELECT * FROM item;";
		   String id,nam,pri,ty,av;
	         ResultSet rs;
		     rs = stmt.executeQuery(queryString);
		      while(rs.next())
		      {
		    	 id=rs.getString("iditem");
		    	 nam=rs.getString("name");
		    	 pri=rs.getString("price");
		    	 ty=rs.getString("type");
		    	 av=rs.getString("avail");
		        menudata.add(new Table(id,nam,pri,ty,av));
		      }
		    	 
	      if (conn != null)
	      {
	        conn.close();
	        conn = null;
	      }
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }
	
	return menudata;
}//customer
ArrayList<String> val= new ArrayList<String>();
public ArrayList<String> search(int a,String valu)
{   String connectionUrl = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
    String dbUser = "root";
    String dbPwd = "1234";
    Connection conn;
    
	if(a==1)
	{
		try
	    {
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	 
	       String queryString = "SELECT * FROM employee where idemp='"+valu+"';";
		   String id,nam,age,sal,num;
	         ResultSet rs;
		     rs = stmt.executeQuery(queryString);
		    
		     
		    	 while(rs.next())
			      {
			    	 id=rs.getString("idemp");
			    	 nam=rs.getString("name");
			    	 age=rs.getString("age");
			    	 sal=rs.getString("salary");
			    	 num=rs.getString("number");
			    	 val.add(id);
			    	  val.add(nam);
			    	  val.add(age);
			    	  val.add(sal);
			    	   val.add(num);
			      }
			    	  
		     
		     
		    	 
	      if (conn != null)
	      {
	        conn.close();
	        conn = null;
	      }
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }

	}
	else if (a==2)
	{
		try
	    {
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	 
	       String queryString = "SELECT * FROM employee where number="+valu+";";
		   String id,nam,age,sal,num;
		   
	         ResultSet rs;
		     rs = stmt.executeQuery(queryString);
		  
		    	 while(rs.next())
			      {
			    	 id=rs.getString("idemp");
			    	 nam=rs.getString("name");
			    	 age=rs.getString("age");
			    	 sal=rs.getString("salary");
			    	 num=rs.getString("number");
			    	 val.add(id);
			    	 val.add(nam);
			    	 val.add(age);
			    	 val.add(sal);
			    	 val.add(num);
			      }
			    	  
		    
		     
		     
	      if (conn != null)
	      {
	        conn.close();
	        conn = null;
	      }
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }

	}
	return val;
	
}

public ArrayList<String> searchcustomer(String number)
{
	String connectionUrl = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
    String dbUser = "root";
    String dbPwd = "1234";
    Connection conn;
    
	
		try
	    {
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	 
	       String queryString = "SELECT * FROM customer where number="+number+";";
		   String id,nam,email,num;
	       ResultSet rs;
		     rs = stmt.executeQuery(queryString);
		    
		     
		    	 while(rs.next())
			      {
			    	 id=rs.getString("idcus");
			    	 nam=rs.getString("name");
			    	 email=rs.getString("email");
			    	 num=rs.getString("number");
			    	 val.add(id);
			    	  val.add(nam);
			    	  val.add(email);
			    	   val.add(num);
			      }
			    	  
		     
		     
		    	 
	      if (conn != null)
	      {
	        conn.close();
	        conn = null;
	      }
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }

	
	return val;
	
}


public int billupdate(String idemp, String amnt, String tip, String branchid) {
	// TODO Auto-generated method stub
	String connectionUrl = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
    String dbUser = "root";
    String dbPwd = "1234";
    Connection conn;
    
	
		try
	    {
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	     
		   String queryString ="Select * from bill;";
	       ResultSet rs;
		     rs = stmt.executeQuery(queryString);
		    
		     rs.last();
		     String id=rs.getString("idbill");
		     int i=Integer.parseInt(id);
		     i=i+1;
		     id=String.valueOf(i);
		   	 //String queryString = "alter table bill value("+id+","+idemp+","+amnt+","+tip+","+branchid+");";	 
			    	  
		     stmt.executeUpdate("INSERT INTO  bill value('"+id+"',"+amnt+","+tip+",'"+branchid+"','"+idemp+"');");
		     
		    	 
	      if (conn != null)
	      {
	        conn.close();
	        conn = null;
	      }
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }
	return 1;
}


public int employeeupdate(String id, String name, String age,String sal, String number,String branch) {
	// TODO Auto-generated method stub
	String connectionUrl = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
    String dbUser = "root";
    String dbPwd = "1234";
    Connection conn;
    
	
		try
	    {
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	     
		  
			    	  
	      
	          
		     stmt.executeUpdate("INSERT INTO employee values('"+name+"','"+age+"','"+branch+"','"+sal+"','"+number+"','"+id+"');");
		     
		    	 
	      if (conn != null)
	      {
	        conn.close();
	        conn = null;
	      }
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }
	return 1;
	
}


public int fire(String id) {
	// TODO Auto-generated method stub
	String connectionUrl = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
    String dbUser = "root";
    String dbPwd = "1234";
    Connection conn;
    
	
		try
	    {
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	     
		   String queryString ="Select * from employee;";
	       ResultSet rs;
		     rs = stmt.executeQuery(queryString);
		    int flag=0;
		   while(rs.next())
		   {
			   if(id.equals(rs.getString("idemp")))
			   {
				   System.out.println("ID Found");
				   flag=1;
			   }
			   
		   }
		     if(flag==1)
		     {
		    	 System.out.println("delete from employee where idemp='"+ id +"';");
		    	 stmt.executeUpdate("delete from employee where idemp='"+ id +"';");
			     
		    	 return 1;
		     }
		     else 
		    	 return 0;
		
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }

	return 0;
	}


public int restaurantbranch(String id, String number,String lo) {
	// TODO Auto-generated method stub
	String connectionUrl = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
    String dbUser = "root";
    String dbPwd = "1234";
    Connection conn;
    
	
		try
	    {
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	     
	      stmt.executeUpdate("INSERT INTO branch values('"+lo+"','"+id+"','"+number+"');");
		  
		
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }

	return 1;
	
}
ArrayList <Integer> financevalues= new ArrayList<Integer>();
public ArrayList<Integer> totalbill(){ 
	
	String connectionUrl = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
    String dbUser = "root";
    String dbPwd = "1234";
    Connection conn;
    ResultSet rs;
	String queryString = "SELECT amount ,tip FROM bill;";
	int sumamnt=0,t=0;
		try
	    {
			
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	      rs=stmt.executeQuery(queryString);
	      while(rs.next())
	      {
	    	  sumamnt=rs.getInt("amount")+sumamnt;
	    	  t=rs.getInt("tip")+t;
	      }
	     
		
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }
        financevalues.add(sumamnt);
        financevalues.add(t);
		queryString="Select salary from employee;";
		sumamnt=0;
		
		try
	    {
			
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	      rs=stmt.executeQuery(queryString);
	      while(rs.next())
	      {
	    	  sumamnt=rs.getInt("salary")+sumamnt;
	      }
	     
		
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }
		financevalues.add(sumamnt);
 
		queryString="Select count(*) from bill;";
		int count=0;
		try
	    {
			
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	      rs=stmt.executeQuery(queryString);
	      
	      while(rs.next())
	      {
	    	  count=rs.getInt(1);
	      }
	     
		
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }
		financevalues.add(count);
		return financevalues;
		}


public int menuset( String name, String price, String type) {
	// TODO Auto-generated method stub
	String connectionUrl = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
    String dbUser = "root";
    String dbPwd = "1234";
    Connection conn;
    
	
		try
	    {
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      String queryString ="Select * from item;";
	       ResultSet rs;
	      Statement stmt = conn.createStatement();
	      rs = stmt.executeQuery(queryString);
		    
		     rs.last();
		     String id=rs.getString("iditem");
		     int i=Integer.parseInt(id);
		     i=i+1;
		     id=String.valueOf(i);
	      stmt.executeUpdate("INSERT INTO item values('"+id+"','"+name+"','"+price+"','"+type+"','"+"Yes"+"');");
		  
		
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }

	return 1;

}


public int menu(String rm) {
	// TODO Auto-generated method stub
	String connectionUrl = "jdbc:mysql://localhost:3306/restaurant?useSSL=false";
    String dbUser = "root";
    String dbPwd = "1234";
    Connection conn;
    
	
		try
	    {
	      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	      Statement stmt = conn.createStatement();
	     
		   String queryString ="Select * from item;";
	       ResultSet rs;
		     rs = stmt.executeQuery(queryString);
		    int flag=0;
		   while(rs.next())
		   {
			   if(rm.equals(rs.getString("iditem")))
			   {
				   
				   flag=1;
			   }
			   
		   }
		     if(flag==1)
		     {
		    	
		    	 stmt.executeUpdate("update item set avail='No' where iditem='"+ rm +"';");
			     
		    	 return 1;
		     }
		     else 
		    	 return 0;
		
	    }
	    catch (SQLException sqle) 
	    {
	      System.out.println("SQL Exception thrown: " + sqle);
	    }
return 1;
}
} 
 