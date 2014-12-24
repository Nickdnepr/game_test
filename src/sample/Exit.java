package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Exit extends BasicObject {

    public Exit(int x, int y, GraphicsContext gc) {
        super(x, y, gc);
    }

    @Override
    public void draw() {
        gc.setFill(Color.YELLOW);
        gc.setLineWidth(5);
        gc.setStroke(Color.BLACK);
        gc.fillRect(x, y, 70, 70);
        gc.strokeRect(x, y, 70, 70);
        gc.strokeLine(x+35, y, x+35, y+70);
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
