package restaurant;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage mystage=new Stage();
    public static Stage mystage1=new Stage();
    public static Stage customerstage=new Stage();
    public static Stage managerstage=new Stage();
	@Override
	public void start(Stage primaryStage) {
		try {
			mystage=primaryStage;
			FXMLLoader loader= new FXMLLoader(getClass().getResource("/restaurant/Login.fxml"));
			

			Parent root = loader.load();
			Scene scene1 = new Scene(root);
			mystage.setScene(scene1);
			mystage.show();
			mystage.show();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
	public void start2() {
		try {
			
			mystage.hide();
			FXMLLoader loader= new FXMLLoader(getClass().getResource("/restaurant/CustomerInterface.fxml"));
			loader.getController();
			Parent root =loader.load() ;
			Scene scene1 = new Scene(root);
			customerstage.setScene(scene1);
			customerstage.show();
			
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void start3() {
		try {
			mystage.hide();
			Parent root = FXMLLoader.load(getClass().getResource("/restaurant/ManagerInterface.fxml"));
			Scene scene1 = new Scene(root);
			managerstage.setScene(scene1);
			managerstage.show();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
