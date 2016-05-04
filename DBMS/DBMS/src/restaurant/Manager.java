package restaurant;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Manager {
  @FXML
  ComboBox <String> cb;
  @FXML
  TextField employee;
  @FXML
  Button go;
  @FXML
  Label warning;
  @FXML
  Label id;
  @FXML
  Label name;
  @FXML
  Label age;
  @FXML
  Label salary;
  @FXML
  Label number;
  @FXML
  Label idval;
  @FXML
  Label nameval;
  @FXML
  Label ageval;
  @FXML
  Label salaryval;
  @FXML
  Label numberval;
  public void employeesearch(ActionEvent e)
  {
	  String option=cb.getValue();
	  String value= employee.getText();
	  
	  if (option.compareTo("")==0)
	  {
		  warning.setText("Please choose valid option");
	  }
	  else if(option.equals("EmployeeID"))
	  {
		  System.out.println("Option called");
		  JDBCMySQLConnection con=new JDBCMySQLConnection();
		  ArrayList<String> values=con.search(1,value);
		  id.setText("EmployeeID");
		  name.setText("Name");
		  age.setText("Age");
          salary.setText("Salary");
          number.setText("Number");

        	  Iterator<String> itr = values.iterator(); 
              idval.setText(itr.next());
    		  nameval.setText(itr.next());
    		  ageval.setText(itr.next());
              salaryval.setText(itr.next());
              numberval.setText(itr.next());          
	  }
	  else if (option.equals("Number"))
	  {
		  
		  JDBCMySQLConnection con=new JDBCMySQLConnection();
		  ArrayList<String> values=con.search(2,value);
		  id.setText("EmployeeID");
		  name.setText("Name");
		  age.setText("Age");
          salary.setText("Salary");
          number.setText("Number");

        	  Iterator<String> itr = values.iterator(); 
              idval.setText(itr.next());
    		  nameval.setText(itr.next());
    		  ageval.setText(itr.next());
              salaryval.setText(itr.next());
              numberval.setText(itr.next()); 

          
		  
	  }
	 
  }
  @FXML
  TextField customernumber;
  @FXML
  Button customersubmit;
  @FXML
  Label id1;
  @FXML
  Label name1;
  @FXML
  Label email1;
  @FXML
  Label number1;
  @FXML
  Label idval1;
  @FXML
  Label nameval1;
  @FXML
  Label emailval1;
  @FXML
  Label numberval1;
  public void customersearch(ActionEvent e)
  {
	  JDBCMySQLConnection conn= new JDBCMySQLConnection();
	 ArrayList<String> values= conn.searchcustomer(customernumber.getText());
	 id1.setText("CustomerID");
	  name1.setText("Name");
	  email1.setText("Email");
     number1.setText("Number");
   
	 Iterator<String> itr = values.iterator(); 
     idval1.setText(itr.next());
	  nameval1.setText(itr.next());
	  emailval1.setText(itr.next());
     numberval1.setText(itr.next());
    
  }
  
  //After what i had expected/???///////////////////////////////////////////////////////
  @FXML
  TextField billempid;
  @FXML
  TextField billamnt;
  @FXML
  TextField billtip;
  @FXML
  TextField billbranch;
  @FXML
  Button billsubmit;
  @FXML
  Label billwarn;
  public void bill(ActionEvent e)
  {
	  String idemp=billempid.getText();
	  String amnt=billamnt.getText();
	  String tip=billtip.getText();
	  if(tip==null || tip.compareTo("")==0 || tip.equals("0"))
	  {
		  tip="0";
	  }
	  String branchid=billbranch.getText();
	  JDBCMySQLConnection conn= new JDBCMySQLConnection();
	  System.out.println(idemp+amnt+tip+branchid);
	  int result=conn.billupdate(idemp,amnt,tip,branchid);
	  if(result==1)
	  {
		  billwarn.setText("Done");
	  }
	  else if (result==2)
	  {
		  billwarn.setText("Fail");
	  }
  }
  
  @FXML
  TextField empname;
  @FXML
  TextField empage;
  @FXML
  TextField empsal;
  @FXML
  TextField empnumber;
  @FXML
  TextField empbranch;
  @FXML
  Button addemp;
  @FXML
  Label empwarn;
  public void newemployee(ActionEvent e)
{
	  String name= empname.getText();
	  String age=empage.getText();
	  String sal=empsal.getText();
	  String number=empnumber.getText();
	  String branchid=empbranch.getText();
      JDBCMySQLConnection conn= new JDBCMySQLConnection();
      String id= name.substring(0,2)+number.substring(6,10);
      System.out.println(id+name+age+sal+number);
	  int result=conn.employeeupdate(id,name,age,sal,number,branchid);
	  if(result==1)
	  {
		  empwarn.setText("Done");
	  }
	  else
	  {
		  empwarn.setText("Fail");
	  }
}
	@FXML
	TextField fireid;
	@FXML
	Button fire;
	@FXML
	Label firewarn;
	public void fireemployee(ActionEvent e)
	{
		String id= fireid.getText();
		JDBCMySQLConnection conn= new JDBCMySQLConnection();
		int result=conn.fire(id);
		if(result==1)
		  {
			  firewarn.setText("Fired");
		  }
		  else
		  {
			  firewarn.setText("Failure");
		  }
	}
	@FXML
	Label branchwarn;
	@FXML
	TextField venue;
	@FXML
	TextField branchnumber;
	public void branch(ActionEvent e)
	{
		String lo=venue.getText();
		String number= branchnumber.getText();
		String id= lo.substring(0,2)+number.substring(6,10);
		JDBCMySQLConnection conn= new JDBCMySQLConnection();
		int result=conn.restaurantbranch(id,number,lo);
		if(result==1)
		  {
			  branchwarn.setText("Done");
		  }
		  else
		  {
			  branchwarn.setText("Failure");
		  }
	}
	@FXML
	Label totalbillamnt;
	@FXML
	Label totallysalary;
	@FXML
	Label totalnumberofbills;
	@FXML
	Label tipvalue;
	@FXML
	Label totalprofit;
	@FXML
	Label averagesale;
	public void finance(ActionEvent e)
	{
		JDBCMySQLConnection con=new JDBCMySQLConnection();
		ArrayList<Integer> values=con.totalbill();
		 Iterator<Integer> itr = values.iterator(); 
	     int bill=itr.next();
	     int tip=itr.next();
	     int salary=itr.next();
		 int numberofbills=itr.next();
	    totalbillamnt.setText(String.valueOf(bill));
	    totallysalary.setText(String.valueOf(salary));
	    tipvalue.setText(String.valueOf(tip));
	    int average=(bill+tip)/numberofbills;
	    averagesale.setText(String.valueOf(average));
	    int profit= bill-salary;
		totalprofit.setText(String.valueOf(profit));
	}
	@FXML
	TextField itemname;
	@FXML
	TextField itemprice;
	@FXML
	TextField itemtype;
	@FXML
	Label itemwarn;
	public void additem(ActionEvent e)
	{
		String name=itemname.getText();
		String price=itemprice.getText();
		String type= itemtype.getText();
		
		JDBCMySQLConnection con=new JDBCMySQLConnection();
		int result=con.menuset(name,price,type);
		if(result==1)
		  {
			  itemwarn.setText("Done");
		  }
		  else
		  {
			  itemwarn.setText("Failure");
		  }
	}
	@FXML
	TextField itemidcheck;
	@FXML
	Label itemwarncheck;
	public void availableitem(ActionEvent e)
	{
		String rm= itemidcheck.getText();
		JDBCMySQLConnection con=new JDBCMySQLConnection();
		int result=con.menu(rm);
		if(result==1)
		  {
			  itemwarncheck.setText("Done");
		  }
		  else
		  {
			 itemwarncheck.setText("Failure");
		  }
	}
}
