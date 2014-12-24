package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by student on 17.12.2014.
 */
public class Wall extends BasicObject{

    public Wall(int x, int y, GraphicsContext gc) {
        super(x, y, gc);
    }

    @Override
    public void draw() {
        gc.setFill(Color.BROWN);
        gc.setLineWidth(5);
        gc.setStroke(Color.BLACK);
        gc.fillRect(x, y, 70, 70);
        gc.strokeRect(x, y, 70, 70);
    }

    @Override
    public void moveTop() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveDown() {

    }

    @Override
    public void moveRight() {

    }

    @Override
    public void move() {

    }



}
