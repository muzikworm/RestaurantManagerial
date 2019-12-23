package restaurant;

import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class Customer {
	
	@FXML
	TableView <Table> menu;
	@FXML
	TableColumn <Table,String> itemid;
	@FXML
	TableColumn <Table,String> itemname;
	@FXML
	TableColumn <Table,String> price;
	@FXML
	TableColumn <Table,String> type;
	@FXML
	TableColumn <Table,String> avail;
	
	ObservableList<Table> data=FXCollections.observableArrayList();
	public Customer(){}
	@FXML
	public void initialize() {		
		JDBCMySQLConnection conn= new JDBCMySQLConnection();
		menu.setEditable(true);
		itemid.setCellValueFactory(new Callback<CellDataFeatures<Table, String>, ObservableValue<String>>() {
		     public ObservableValue<String> call(CellDataFeatures<Table, String> p) {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().idproperty();
		     }
		  });
		itemname.setCellValueFactory(new Callback<CellDataFeatures<Table, String>, ObservableValue<String>>() {
		     public ObservableValue<String> call(CellDataFeatures<Table, String> p) {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().nameproperty();
		     }
		  }); 
		price.setCellValueFactory(new Callback<CellDataFeatures<Table, String>, ObservableValue<String>>() {
		     public ObservableValue<String> call(CellDataFeatures<Table, String> p) {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().priceproperty();
		     }
		  });
		type.setCellValueFactory(new Callback<CellDataFeatures<Table, String>, ObservableValue<String>>() {
		     public ObservableValue<String> call(CellDataFeatures<Table, String> p) {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().typeproperty();
		     }
		  });
		avail.setCellValueFactory(new Callback<CellDataFeatures<Table, String>, ObservableValue<String>>() {
		     public ObservableValue<String> call(CellDataFeatures<Table, String> p) {
		         // p.getValue() returns the Person instance for a particular TableView row
		         return p.getValue().availproperty();
		     }
		  });
		menu.setItems(conn.getdata());
	}



   
}
