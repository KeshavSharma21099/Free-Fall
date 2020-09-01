package sample;

import javafx.scene.paint.Paint;

public class InelasticBall extends Ball {

    private final double coefficient = 0;

    InelasticBall(Paint color, double xcord, double ycord) {
        super(color, xcord, ycord);
    }

    @Override
    public double getCoefficient() {
        return coefficient;
    }
}
