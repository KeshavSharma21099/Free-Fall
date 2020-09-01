package sample;

import javafx.scene.paint.Paint;

public class ElasticBall extends Ball {

    private final double coefficient = 1;

    ElasticBall(Paint color, double xcord, double ycord) {
        super(color, xcord, ycord);
    }

    @Override
    public double getCoefficient() {
        return coefficient;
    }



}
