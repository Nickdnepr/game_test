package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Main extends Application {
    public final int CANVAS_X=1400;
    public final int CANVAS_Y=840;
    List<Shape> arr = new ArrayList<Shape>();
    final Canvas canvas = new Canvas(CANVAS_X, CANVAS_Y);
    BorderPane group = new BorderPane(canvas);
    Scene scene = new Scene(group);
    private GraphicsContext gc=canvas.getGraphicsContext2D();;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
        inIt();
        timer();
        draw();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case LEFT:
                        arr.get(0).moveLeft();
                        draw();
                        break;
                    case RIGHT:
                        arr.get(0).moveRight();
                        draw();
                        break;
                    case UP:
                        arr.get(0).moveTop();
                        draw();
                        break;
                    case DOWN:
                        arr.get(0).moveDown();
                        draw();
                        break;
                }
            }
        });
    }

    public void timer(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        moveEnemies();
                        draw();

                    }
                });
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 200, 1000);
    }

    private void draw() {
        gc.clearRect(0, 0, CANVAS_X, CANVAS_Y);
        for(int i=0; i<arr.size(); i++){
            arr.get(i).draw();
        }
    }

    public void moveEnemies(){
        for(int i=1; i<arr.size(); i++){
            arr.get(i).move();
        }
        draw();
    }


    public void inIt(){
        Shape gg = new Hero(0, 0, gc);
        arr.add(gg);
        Shape tmp = new Enemy(700, 700, gc);
        arr.add(tmp);
        tmp=new Wall(140, 210, gc);
        arr.add(tmp);
        arr.add(new Exit(700, 700, gc));
        draw();
        gc.clearRect(0, 0, CANVAS_X, CANVAS_Y);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
