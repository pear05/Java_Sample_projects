
package Rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Home_admin extends Application {
    static Stage homeClass= new Stage();
    static Stage classStage = new Stage();
    static Stage classExpe = new Stage();
    static Stage classPay = new Stage();
    
    public void start(Stage stage) {
      //step 1; create label name
      Text text1 = new Text("Sign new user :");
      Text text2 = new Text("Expenses :");
      Text text3= new Text("Name of tenants :");
      Text text4= new Text("Registered :");
      Text txt1= new Text();
      
      // instantiation
      Sign_up su=new Sign_up();
      Expenses ex=new Expenses();
      Payment pay=new Payment();
      
      //step 5; create buttons
      Button btn_user =new Button("Sign User");
      Button btn_expe = new Button("Expenses");
      Button btn_tena =new Button("Payment by tenants");
      Button btn_admin = new Button("Administrators");
      
       btn_user.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) {
        su.start(Sign_up.classStage);
        stage.close();
         }
      })); 
        btn_expe.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) {
        ex.start(Expenses.classExpe);
        stage.close();
         }
      })); 
        btn_tena.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) {
        pay.start(Payment.classPay);
        stage.close();
         }
      })); 
      //step 6; creating  a Grid Pane and import relevant Classes
      GridPane gridPane = new GridPane();
      //step 7;set up size for the pane
      gridPane.setMinSize(600,400);
      //step 8; set padding
      gridPane.setPadding(new Insets(10, 10, 10, 10));
      //step 9; set the vertical and horizontal gaps between the column
      gridPane.setVgap(10);
      gridPane.setHgap(10);
       //step 10:Set the grid alignment
    gridPane.setAlignment(Pos.CENTER);
    
    //step 11:Arrange all the nodes in the grid
    gridPane.add(text1, 0, 0);
    gridPane.add(btn_user, 1, 0);
    gridPane.add(text2, 0, 3);
    gridPane.add(btn_expe, 1, 3);
    gridPane.add(text3, 0, 5);
    gridPane.add(btn_tena, 1,5);
    gridPane.add(text4, 0, 7);
    gridPane.add(btn_admin, 1, 7);
     btn_user.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
    btn_expe.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
    btn_tena.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
    btn_admin.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
    gridPane.setStyle("-fx_background-color: BEIGE;");
      //Creating a scene object
      Scene scene = new Scene(gridPane);
      //setting title to the stage 
      stage.setTitle("Homepage System");
      //Adding scene to the stage
      stage.setScene(scene);
      //displaying the contents of the stage 
      stage.show();
      
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
