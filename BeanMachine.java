
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
    
    // Pause and play beans
    pane.setOnMouseClicked(e -> {
      if (cont < 10){
        playBean();
      }
    });


    // Creat a scene and place it in the stage
    Scene scene = new Scene(pane,300,300);
    // Set title
    primaryStage.setTitle("Bean Machine");
    // Place scene in the stage
    primaryStage.setScene(scene);
    // Display the stage
    primaryStage.show();
  }
  public void playBean(){
    // Creat and set main bean in Machine
    Circle bean = new Circle(150,40,5);
    bean.setFill(Color.RED);
    pane.getChildren().add(bean);
    // Create value to compute possibility
    int place = 0;
    int x[] = new int[7];
    // Creat a SecureRandom
    SecureRandom random = new SecureRandom();
    // For loop to run
    for (int i =0; i <7; i++){
      int rd = random.nextInt(50);
      if (rd < 25){
        place += 12.5;
      } else {
        place -= 12.5;
      }
      x[i] = place;
    }
        
    // Create an animation and KeyFrame
    Timeline animation = new Timeline(
      new KeyFrame(Duration.ZERO, new KeyValue(bean.translateXProperty(), 0)),
      new KeyFrame(Duration.millis(100), new KeyValue(bean.translateXProperty(),0), new KeyValue(bean.translateYProperty(), 40)),
      new KeyFrame(Duration.millis(200), new KeyValue(bean.translateXProperty(),x[0]), new KeyValue(bean.translateYProperty(), 45)),
      new KeyFrame(Duration.millis(300), new KeyValue(bean.translateXProperty(),x[0]),new KeyValue(bean.translateYProperty(), 65)),
      new KeyFrame(Duration.millis(400), new KeyValue(bean.translateXProperty(),x[1]),new KeyValue(bean.translateYProperty(), 70)),
      new KeyFrame(Duration.millis(500), new KeyValue(bean.translateXProperty(),x[1]),new KeyValue(bean.translateYProperty(), 90)),
      new KeyFrame(Duration.millis(600), new KeyValue(bean.translateXProperty(),x[2]),new KeyValue(bean.translateYProperty(), 95)),
      new KeyFrame(Duration.millis(700), new KeyValue(bean.translateXProperty(),x[2]),new KeyValue(bean.translateYProperty(), 115)),
      new KeyFrame(Duration.millis(800), new KeyValue(bean.translateXProperty(),x[3]),new KeyValue(bean.translateYProperty(), 120)),
      new KeyFrame(Duration.millis(900), new KeyValue(bean.translateXProperty(),x[3]),new KeyValue(bean.translateYProperty(), 140)),
      new KeyFrame(Duration.millis(1000), new KeyValue(bean.translateXProperty(),x[4]),new KeyValue(bean.translateYProperty(), 145)),
      new KeyFrame(Duration.millis(1100), new KeyValue(bean.translateXProperty(),x[4]),new KeyValue(bean.translateYProperty(), 165)),
      new KeyFrame(Duration.millis(1200), new KeyValue(bean.translateXProperty(),x[5]),new KeyValue(bean.translateYProperty(), 170)),
      new KeyFrame(Duration.millis(1300), new KeyValue(bean.translateXProperty(),x[5]),new KeyValue(bean.translateYProperty(), 190)),
      new KeyFrame(Duration.millis(1400), new KeyValue(bean.translateXProperty(),x[6]),new KeyValue(bean.translateYProperty(), 195)),
      new KeyFrame(Duration.millis(1500), new KeyValue(bean.translateXProperty(),x[6]),new KeyValue(bean.translateYProperty(), 215)),
      new KeyFrame(Duration.millis(1600), new KeyValue(bean.translateXProperty(),x[6]),new KeyValue(bean.translateYProperty(), 235))
    );
    animation.play();
  }
  public static void main(String[] args) { 
    launch(args);
  }
}
