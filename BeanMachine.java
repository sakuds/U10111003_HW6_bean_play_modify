
//U10111003 朱永捷

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.animation.*;
import javafx.util.Duration;
import java.security.SecureRandom;
import javafx.event.*;

public class BeanMachine extends Application {
  // Create a pane
  private Pane pane = new Pane();

  public void start(Stage primaryStage) {
    // Create polyline and line in pane
    Polyline mainline = new Polyline();
    mainline.getPoints().addAll(140.0,40.0,140.0,60.0,50.0,240.0,50.0,280.0,250.0,280.0,250.0,240.0,160.0,60.0,160.0,40.0);
    mainline.setFill(Color.WHITE);    
    pane.getChildren().add(mainline);	
    Line line[] = new Line[7];
    for (int i = 0; i<7; i++){
      line[i] = new Line(75+(i*25),240,75+(i*25),280);
      pane.getChildren().add(line[i]);
    }
    // Create circles in pane
    Circle circle[] = new Circle[28];
    for (int i = 0,index = 0 ; i<7 ; i++){
      for (int j = 6-i ; j>=0 ; j--){
        circle[index] = new Circle(75+(i*12.5)+(j*25),240-(i*25),5,Color.BLUE);
        pane.getChildren().add(circle[index]);
        index++;
      }
    }
    // Creat a scene and place it in the stage
    Scene scene = new Scene(pane,300,300);
    // Set title
    primaryStage.setTitle("Bean Machine");
    // Place scene in the stage
    primaryStage.setScene(scene);
    // Display the stage
    primaryStage.show();
  }
  public static void main(String[] args) { 
    launch(args);
  }
}
