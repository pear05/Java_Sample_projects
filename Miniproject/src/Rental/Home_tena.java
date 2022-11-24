
package Rental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

public class Home_tena extends Application{
    
    
    @Override
     public void start(Stage stage) {
      //step 1; create label name
      Text text1 = new Text("Input the rent:");
      Text text2 = new Text("Input the water bill :");
      Text text3= new Text("Input the power bill :");
      Text text4= new Text("Input the repairs :");
      Text txt1= new Text();
      Text total=new Text("Total");
      Text result = new Text();
      int res=45;
      
      // instantiation
      Sign_up su=new Sign_up();
      
      //step 5; create textfield
      TextField rent =new TextField();
      TextField water =new TextField();
      TextField power =new TextField();
      TextField repairs=new TextField();
      
      //buttons
      Button Save=new Button("Save");
      Button sum_btn=new Button("Get total");
      
      // Force the fields to be Integers
     rent.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
            if (!newValue.matches("\\d*")) {
                rent.setText(newValue.replaceAll("[^\\d]", ""));
            }
        }
     });
     // Force the fields to be Integers
     water.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
            if (!newValue.matches("\\d*")) {
                water.setText(newValue.replaceAll("[^\\d]", ""));
            }
        }
     });
     // Force the fields to be Integers
     power.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
            if (!newValue.matches("\\d*")) {
                power.setText(newValue.replaceAll("[^\\d]", ""));
            }
        }
     });
     // Force the fields to be Integers
     repairs.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
            String newValue) {
            if (!newValue.matches("\\d*")) {
                repairs.setText(newValue.replaceAll("[^\\d]", ""));
            }
        }
     });
      
     sum_btn.setOnMouseClicked((new EventHandler<MouseEvent>(){
        public void handle(MouseEvent event){
            int fin_res=(Integer.parseInt(rent.getText()))+(Integer.parseInt(water.getText())+Integer.parseInt(power.getText()))+(Integer.parseInt(repairs.getText()));
            result.setText(Integer.toString(fin_res));
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
    gridPane.add(rent, 1, 0);
    gridPane.add(text2, 0, 3);
    gridPane.add(water, 1, 3);
    gridPane.add(text3, 0, 5);
    gridPane.add(power, 1,5);
    gridPane.add(text4, 0, 7);
    gridPane.add(repairs, 1, 7);
    gridPane.add(total, 0, 8);
    gridPane.add(result, 1, 8);
    gridPane.add(sum_btn, 0, 10);
    
      //Creating a scene object
      Scene scene = new Scene(gridPane);
      //setting title to the stage 
      stage.setTitle("Payment system System");
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
