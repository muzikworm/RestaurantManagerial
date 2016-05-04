package restaurant;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Table {

	private SimpleStringProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty price;
	private SimpleStringProperty type;
	private SimpleStringProperty avail;
	Table (String i,String n,String p,String t,String a){
		this.id=new SimpleStringProperty(i);
		this.name=new SimpleStringProperty(n);
		this.price=new SimpleStringProperty(p);
		this.type=new SimpleStringProperty(t);
		this.avail=new SimpleStringProperty(a);
	}
	public String getid(){
		
		return id.get();
	} 
	public void setid(String ie){
		
		 id.set(ie);
	} 
   public StringProperty idproperty(){
		
		return id ;
	} 
	
   
   public String getname(){
		return name.get();
	} 
	public void setname(String ie){
		 name.set(ie);
	} 
	 public StringProperty nameproperty(){
			
			return name ;
		} 
	
	 
	 
	 
	public String getprice(){
		return price.get();
	} 
	public void setprice(String ie){
		 price.set(ie);
	} 
	
	public StringProperty priceproperty(){
			
			return price ;
		} 
	
	
	
	
	public String gettype(){
		return type.get();
	} 
	public void settype(String ie){
		 type.set(ie);
	} 
	 public StringProperty typeproperty(){
			
			return type ;
		} 
	
	
	
	public String getavail(){
		return avail.get();
	} 
	public void setavail(String ie){
		 avail.set(ie);
	} 
	 public StringProperty availproperty(){
			
			return avail ;
		} 
}

