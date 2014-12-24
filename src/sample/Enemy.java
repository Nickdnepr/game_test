package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Enemy extends BasicObject {
    public Enemy(int x, int y, GraphicsContext gc) {
        super(x, y, gc);
    }

    private int DELTA_MOVE = 70;

    enum direction {up, down, left, right}

    private direction d = direction.left;


    @Override
    public void draw() {
        Image image = new Image(getClass().getResourceAsStream("еврей.jpg"));
        gc.drawImage(image, x, y);
    }

    @Override
    public void moveTop() {
        y -= DELTA_MOVE;
        draw();
        System.out.println("called moveTop");

    }

    @Override
    public void moveLeft() {
        x -= DELTA_MOVE;
        draw();
        System.out.println("called moveLeft");

    }

    @Override
    public void moveDown() {
        y += DELTA_MOVE;
        draw();
        System.out.println("called moveDown");

    }

    @Override
    public void moveRight() {
        x += DELTA_MOVE;
        draw();
        System.out.println("called moveRight");
    }

    @Override
    public void move() {
        if (y - 70 < 0 && d != direction.right) {
            d = direction.right;
            System.out.println("switched to right");
        } else {
            if (x - 70 < 0 && d != direction.up) {
                d = direction.up;
                System.out.println("switched to up");
            } else {
                if (y + 70 >= gc.getCanvas().getHeight() && d != direction.left) {
                    d = direction.left;
                    System.out.println("switched to left");
                } else {
                    if (x + 70 >= gc.getCanvas().getWidth() && d != direction.down) {
                        d = direction.down;
                        System.out.println("switched to down");
                    }
                }
            }
        }


        switch (d) {
            case up:
                moveTop();
                break;
            case left:
                moveLeft();
                break;
            case right:
                moveRight();
                break;
            case down:
                moveDown();
                break;
        }
        System.out.println(d);
    }


}
