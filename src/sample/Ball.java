package sample;

import javafx.scene.shape.Circle;

import javafx.scene.paint.*;

abstract public class Ball {
    protected Circle circle;
    protected double xcord, ycord;

    Ball(Paint color, double xcord, double ycord) {
        this.xcord = xcord;
        this.ycord = ycord;
        createBall(color);
    }

    private void createBall(Paint color) {
        circle= new Circle(15, color);
        circle.setStroke(javafx.scene.paint.Color.BLACK);
        circle.setStroke(Color.GHOSTWHITE);
        circle.setStrokeWidth(2);
        circle.relocate(xcord, ycord);
    }

    //Getter methods
    public Circle getCircle() {
        return this.circle;
    }

    public double getXcord() {
        return this.xcord;
    }

    public double getYcord() {
        return ycord;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public void setXcord(double xcord) {
        this.xcord = xcord;
    }

    public void setYcord(double ycord) {
        this.ycord = ycord;
    }

    //To be overridden by subclasses
    abstract public double getCoefficient();


}
