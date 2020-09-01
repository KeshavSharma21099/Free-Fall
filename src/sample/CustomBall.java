package sample;

import javafx.scene.paint.Paint;

public class CustomBall extends Ball{
    private double coefficient;

    CustomBall(Paint color, double xcord, double ycord, double coefficient) {
        super(color, xcord, ycord);
        this.coefficient = coefficient;
    }

    @Override
    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

}
