
package Rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Sign_up extends Application{
     static Stage classStage = new Stage();
    @Override
     public void start(Stage stage) {
    //text fields
     Text fname=new Text("First Name"); 
     Text lname=new Text("Lastname");
     Text email= new Text("Email");
     Text telephone=new Text("Telephone"); 
     Text psd=new Text("Password");
     Text house= new Text("House.No");
     Text txt1=new Text();
     
     //textfields
     TextField fname1=new TextField();
     TextField lname1=new TextField();
     TextField email1=new TextField();
     TextField telephone1=new TextField();
      ChoiceBox hos = new ChoiceBox();
        hos.getItems().addAll("A1", "A2","A3","A4","A5","B1","B2","B3","B4","B5");
     PasswordField psd1=new PasswordField();
     
     
     //step 5; create buttons
      Button Save =new Button("Save as Tenants");
      Button SaveAdmin = new Button("Save as Administrator");
      Button Back =new Button("Back to homepage");
      //instantiation
      Home_admin hp=new Home_admin();
      
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
    gridPane.add(fname, 0, 0);
    gridPane.add(fname1, 1, 0);
    gridPane.add(lname, 0, 1);
    gridPane.add(lname1, 1, 1);
    gridPane.add(email, 0, 2);
    gridPane.add(email1, 1, 2);
    gridPane.add(telephone, 0, 3);
    gridPane.add(telephone1, 1, 3);
    gridPane.add(psd, 0, 4);
    gridPane.add(psd1, 1, 4);
    gridPane.add(house, 0, 5);
    gridPane.add(hos, 1, 5);
    gridPane.add(Save, 0, 7);
    gridPane.add(SaveAdmin, 1, 7);
    gridPane.add(Back, 2,7);
     gridPane.add(txt1, 2,9);
     Save.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
    SaveAdmin.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
    Back.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
    gridPane.setStyle("-fx_background-color: BEIGE;");
    
     Save.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) {
               try{ 
                 
             String Firstname = fname1.getText();
             String Lastname = lname1.getText();
             String Email = email1.getText();
             String Telephone = telephone1.getText();
             String Password= psd1.getText();
             String House = (String)hos.getValue();
                           
                Class.forName("com.mysql.cj.jdbc.Driver"); //step one
                
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mini?autoReconnect=false&useSSL=false","root","");  //step two
                
                Statement st = con.createStatement();   //step three
                 
                //String sts = "INSERT INTO `employee`(`title`,`name`) VALUES ("+"'Mr'"+","+"'Wangdu'"+")";
                String sts = "INSERT INTO `details`(`firstname`,`lastname`,`email`,`telephone`,`password`,`house.no`) VALUES ("+"'"+Firstname+"'"+","+"'"
                        +Lastname+"'"+","+"'"+Email+"'"+","+"'"+Telephone+"'"+","+"'"+Password+"'"+","+"'"+House+"'"+")";
                
                st.executeUpdate(sts); //step four
                
                //System.out.println("Saving successful");
                txt1.setText("Saving successful as tenant");
                
                con.close();//step five
             }  
         catch(Exception ee){System.out.println(ee);txt1.setText("Saving NOT successful");;}
         } 
      })); 
     SaveAdmin.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) {
               try{ 
                 
             String Firstname = fname1.getText();
             String Lastname = lname1.getText();
             String Email = email1.getText();
             String Telephone = telephone1.getText();
             String Password= psd1.getText();
             String House = (String)hos.getValue();
                           
                Class.forName("com.mysql.cj.jdbc.Driver"); //step one
                
                Connection con = DriverManager.getConnection("jdbc:mysql://essylocalhost/mini?autoReconnect=false&useSSL=false","root","");  //step two
                
                Statement st = con.createStatement();   //step three
                 
                //String sts = "INSERT INTO `employee`(`title`,`name`) VALUES ("+"'Mr'"+","+"'Wangdu'"+")";
                String sts = "INSERT INTO `admin`(`firstname`,`lastname`,`email`,`telephone`,`password`,`house.no`) VALUES ("+"'"+Firstname+"'"+","+"'"
                        +Lastname+"'"+","+"'"+Email+"'"+","+"'"+Telephone+"'"+","+"'"+Password+"'"+","+"'"+House+"'"+")";
                
                st.executeUpdate(sts); //step four
                
                //System.out.println("Saving successful");
                txt1.setText("Saving successful as Admin");
                
                con.close();//step five
             }  
         catch(Exception ee){System.out.println(ee);txt1.setText("Saving NOT successful");;}
         } 
      }));
     Back.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) {
               hp.start(Home_admin.classStage);
               stage.close();
         } 
      }));
    
      //Creating a scene object
      Scene scene = new Scene(gridPane);
      //setting title to the stage 
      stage.setTitle("Rental Signup System");
      //Adding scene to the stage
      stage.setScene(scene);
      //displaying the contents of the stage 
      stage.show();
      
    }
     
     
      public static void main(String[] args) {
        launch(args);
    }
    
}
