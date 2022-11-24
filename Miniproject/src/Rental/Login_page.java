package Rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Login_page extends Application{
    static Stage homeClass= new Stage();
    @Override
     public void start(Stage primaryStage) {
        //LABLES
        Text fname1=new Text("Email"); 
        Text lname1=new Text("Password");
        Text help= new Text("Welcome to your Rental Login System");
        Text txt1= new Text();
        
        //BUTTONS
        Button admin_btn = new Button("Admin"); 
        Button user_btn = new Button("Tenant"); 
     
        //TEXTFIELD
        TextField uname_tf=new TextField();
        
        //PASSWORD FIELD
        PasswordField pass_field = new PasswordField();
                       
        //EVENT HANDLING
         admin_btn.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) {
             String username = uname_tf.getText();
        String password = pass_field.getText();
              try{ 
                
                  //Step One
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Step Two
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/mini?autoReconnect=true&useSSL=false","root","");
            
            //Step Three
            Statement st=con.createStatement();
            
            //instantiation
            Home_admin ha= new Home_admin();
            
            //Step Four
            String query = "SELECT * FROM mini.admin Where email = '"+username+"' AND password = '"+password+"' ";
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next())
            {
                //You can replace this code with ANY code to be executed after a successfull login
                /*Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                al.setContentText("Successful Login");
                al.show();*/
                
                ha.start(Home_admin.homeClass);
                primaryStage.close();
            }
            
            else
            {
                //You can replace this code with ANY code to be executed after unsuccessfull login
                Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setContentText("Invalid User Name or Password");
                 a.show(); 
            }
            
            
            //Step five
            con.close();
             }  
         catch(Exception ee){System.out.println(ee);txt1.setText("Connection Error");;}
         } 
      })); 
         // event for user
         user_btn.setOnMouseClicked((new EventHandler<MouseEvent>() { 
         public void handle(MouseEvent event) {
             String username = uname_tf.getText();
        String password = pass_field.getText();
              try{ 
                
                  //Step One
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Step Two
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost/mini?autoReconnect=true&useSSL=false","root","");
            
            //Step Three
            Statement st=con.createStatement();
            
            //Step Four
            String query = "SELECT * FROM mini.details Where email = '"+username+"' AND password = '"+password+"' ";
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next())
            {
                //You can replace this code with ANY code to be executed after a successfull login
                Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                al.setContentText("Successful Login");
                al.show();
                
                
            }
            
            else
            {
                //You can replace this code with ANY code to be executed after unsuccessfull login
                Alert a = new Alert(Alert.AlertType.WARNING);
                 a.setContentText("Invalid User Name or Password");
                 a.show(); 
            }
            
            
            //Step five
            con.close();
             }  
         catch(Exception ee){System.out.println(ee);txt1.setText("Connection Error");;}
         } 
      })); 
        
        //GRIDPANE
        GridPane gridPane = new GridPane();
        
        gridPane.add(help,2,0);
        gridPane.add(fname1,1,1);
        gridPane.add(lname1,1,2);
        gridPane.add(uname_tf,2,1);
        gridPane.add(pass_field,2,2);
        gridPane.add(admin_btn,3,1);
        gridPane.add(user_btn,3,2);
        gridPane.setMinSize(600,300);        
        gridPane.setVgap(10);        
        gridPane.setHgap(20);        
        gridPane.setAlignment(Pos.CENTER);    
        
        admin_btn.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
    user_btn.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white; -fx-font-size:13pt;");
    gridPane.setStyle("-fx_background-color: BEIGE;");
        
        //SCENE
        Scene my_scene = new Scene(gridPane);
        
        //STAGE
        primaryStage.setScene(my_scene);
        primaryStage.setTitle("Essy and Azree System Login");
        primaryStage.show();
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}


