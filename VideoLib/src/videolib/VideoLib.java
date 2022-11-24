/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videolib;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdk.internal.dynalink.DefaultBootstrapper;

/**
 *
 * @author waswa
 */
public class VideoLib extends Application {
    @Override
    
     public void start(Stage primaryStage) {
    
        Text uname_label=new Text("User Name"); 
        Text pass_label=new Text("Password");
        Text email_label=new Text("Email"); 
        
        
      
        Button login_btn = new Button("Login");
        Button register_btn = new Button("Sign in");
        Button exit_btn = new Button("exit");
    
        TextField uname_tf=new TextField();
        
       
        PasswordField pass_field = new PasswordField();
        
        
        TextField email_tf = new TextField();
        
        
       
        ImageView logo_img = new ImageView();  
        Image my_image = new Image(VideoLib.class.getResourceAsStream("looggoo.jpg"));
        
        logo_img.setImage(my_image); 
        
        //logo_img.setX(20);
        //logo_img.setY(10);
        logo_img.setFitWidth(50);
        logo_img.setPreserveRatio(true);
        
        
       
        GridPane gridPane = new GridPane();
        
        gridPane.add(uname_label,1,1);
        gridPane.add(pass_label,1,2);
        gridPane.add(uname_tf,2,1);
        gridPane.add(pass_field,2,2);
        gridPane.add(email_tf,2,3);
        gridPane.add(login_btn,2,4);
        gridPane.add(register_btn,2,5);
        gridPane.add(exit_btn,2,6);
        gridPane.add(logo_img, 1, 0);
        
        
        gridPane.setMinSize(600,300);
        
        gridPane.setVgap(10);
        
        gridPane.setHgap(20);
        
        gridPane.setAlignment(Pos.CENTER);
        
        
        
        register_btn.setStyle( "-fx-background-color: darkslateblue; -fx-textfill: white;"); 
        login_btn.setStyle("-fx-background-color: darkslateblue; -fx-textfill: white;"); 
        exit_btn.setStyle("-fx-background-color: darkslateblue; -fx-textfill: white;"); 
        
        
      uname_label.setStyle("-fx-font: normal bold 15px 'serif' "); 
      pass_label.setStyle("-fx-font: normal bold 15px 'serif' "); 
      email_label.setStyle("-fx-font: normal bold 15px 'serif' "); 
      gridPane.setStyle("-fx-background-color: BEIGE;"); 
        
       
        Scene my_scene = new Scene(gridPane);
    
    
       
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
