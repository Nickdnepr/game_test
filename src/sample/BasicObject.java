package sample;


import javafx.scene.canvas.GraphicsContext;

public abstract class BasicObject implements Shape{
    protected int x;
    protected int y;
    protected GraphicsContext gc;

    public BasicObject(int x, int y, GraphicsContext gc) {
        this.x = x;
        this.y = y;
        this.gc = gc;
    }

    @Override
    public abstract void draw();



    @Override
    public abstract void moveTop() ;



    @Override
    public abstract void moveLeft() ;


    @Override
    public abstract void moveDown() ;



    @Override
    public abstract void moveRight();

    public abstract void move();


    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

}
