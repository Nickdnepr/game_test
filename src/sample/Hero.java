package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;






public class Hero extends BasicObject {

    public Hero(int x, int y, GraphicsContext gc) {
        super(x, y, gc);
    }
    private int DELTA_MOVE=70;

    @Override
    public void draw() {
        Image image = new Image(getClass().getResourceAsStream("адик.jpg"));
        gc.drawImage(image, x, y);
    }

    @Override
    public void moveTop() {
        y-=DELTA_MOVE;
        draw();
    }

    @Override
    public void moveLeft() {
        x-=DELTA_MOVE;
        draw();
    }

    @Override
    public void moveDown() {
        y+=DELTA_MOVE;
        draw();
    }

    @Override
    public void moveRight() {
        x+=DELTA_MOVE;
        draw();
    }

    @Override
    public void move() {

    }

}
