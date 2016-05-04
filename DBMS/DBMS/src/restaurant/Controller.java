package restaurant;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class Controller implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {		
		
	}


	@FXML
	private TextField username,password,name,numberup,newpass,repass,em;
   
	@FXML
	private Label warnpass,warn,upwarn;
	
	@FXML
	private Button signin; 
	JDBCMySQLConnection conn = new JDBCMySQLConnection();
	int signinresult,signupresult;
	public void signinfunction (ActionEvent event) {
		warn.setText("");
		String n = username.getText();
		String p = password.getText();
		System.out.printf("%s %s",n,p);
		signinresult=2;
//		while(signinresult==2)
//		{
			signinresult=conn.loginfuction(n,p);
			if(n.equals("admin"))
			{
				if(p.equals("123456"))
				{    Main main=new Main();
					main.start3();
				}
			}
			if(signinresult==-1)
			{
				warn.setText("No such User");
			}
			else if(signinresult==1)
			{
				signinresult=-2;
			    Main main=new Main();
			    main.start2();
			}
			else if (signinresult==0)
			{
				warn.setText("Username and password set didn't match");
			}
		//}
		
	}//login function
    public void signupfunction(ActionEvent event)
    {
    	
     	String na=name.getText();
    	String nup= numberup.getText();
     	String npass= newpass.getText();
     	String rpass= repass.getText();
    	String email=em.getText();
    	
    	System.out.println(na+nup+npass+rpass+email);
    	
    	if (na.equals("") || nup.equals("") || email.equals("") || rpass.equals("") || npass.equals(""))
    	{
    		upwarn.setText("All fields are required");
    	}
    	if (nup.length()<10)
    	{
    		warnpass.setText("Please enter a valid phone number.");
    	}
    	else if(npass.equals(rpass) && !npass.equals(null))
    	{
    		String id= na.substring(0,4)+nup.substring(6,10);
    		signupresult=conn.registerfunction(na,0,email,npass,nup,id);
    		if(signupresult==0)
    		{
    			upwarn.setText("Such user already exist");
    		}
    		else if(signupresult==1)
    		{
    			upwarn.setText("Registration Successful");
    		}
    		else
    		{
    			upwarn.setText("Some error occurred. Please try again Later");
    		}
    	}
    	
    	else if (!npass.equals(rpass))
    	{ 
    	   	warnpass.setText("Password do not match. Please Re-enter.");
    	}    	
    	
    }//sigupfunction
   
    
   
}