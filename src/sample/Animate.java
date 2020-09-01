package sample;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.DecimalFormat;

public class Animate {
    private Ball ball1, ball2;
    private final double g = 9.81;
    Label arr1[] = new Label[15];
    Label arr2[] = new Label[15];


    Animate(Ball ball1, Ball ball2) {
        this.ball1 = ball1;
        this.ball2 = ball2;
    }

    public Ball getBall1() {
        return ball1;
    }

    public Ball getBall2() {
        return ball2;
    }

    public void animation(Stage stage, Scene scene, Group group, Circle circle1, Circle circle2) {
        double e1 = ball1.getCoefficient();
        double e2 = ball2.getCoefficient();
        double h1 = ball1.getYcord();
        double h2 = ball2.getYcord();

        double y1 = h1;
        double y2 = h2;

        double t1, t2, time1 = 0, time2 = 0;
        t1 = Math.sqrt(2*y1/g);
        t2 = Math.sqrt(2*y2/g);

        Timeline timeline = new Timeline();
        for(int i=0; i<15; i++) {

            KeyValue yValue1 = new KeyValue(circle1.centerYProperty(), scaleY(y1), Interpolator.EASE_OUT);
            KeyValue yValue2 = new KeyValue(circle2.centerYProperty(), scaleY(y2), Interpolator.EASE_OUT);
            KeyFrame kf1 = new KeyFrame(Duration.millis(time1), yValue1);
            KeyFrame kf2 = new KeyFrame(Duration.millis(time2), yValue2);
            circle1.setCenterY(scaleY(y1));
            circle2.setCenterY(scaleY(y2));

            DecimalFormat df = new DecimalFormat("#.###");

            arr1[i] = new Label(df.format(y1));
            arr1[i].setLayoutX(100);
            arr1[i].setLayoutY(700 - scaleY((i+1)*3));
            arr1[i].setFont(new Font("Arial", 15));
            arr1[i].setTextFill(Color.GHOSTWHITE);
            arr2[i] = new Label(df.format(y2));
            arr2[i].setLayoutX(1050);
            arr2[i].setLayoutY(scaleY((i+1)*3));
            arr2[i].setFont(new Font("Arial", 15));
            arr2[i].setTextFill(Color.GHOSTWHITE);

            y1 *= e1;
            y2 *= e2;

            t1 = Math.sqrt(2*y1/g);
            t2 = Math.sqrt(2*y2/g);

            time1 += t1*500;
            time2 += t2*500;

            KeyValue ayValue1 = new KeyValue(circle1.centerYProperty(), scaleY(0), Interpolator.EASE_IN);
            KeyValue ayValue2 = new KeyValue(circle2.centerYProperty(), scaleY(0), Interpolator.EASE_IN);
            circle1.setCenterY(scaleY(0));
            circle2.setCenterY(scaleY(0));

            KeyFrame kf3 = new KeyFrame(Duration.millis(time1), ayValue1);
            KeyFrame kf4 = new KeyFrame(Duration.millis(time2), ayValue2);
            time1 += t1*500;
            time2 += t2*500;
            timeline.getKeyFrames().addAll(kf1, kf2, kf3, kf4);

            group.getChildren().addAll(arr1[i], arr2[i]);
        }
        timeline.play();
        stage.setScene(scene);

    }

    public double scaleY(double y) { return 700 - 15 * y; }

    public void simulateExperiment() {
        Stage simulationStage = new Stage();
        simulationStage.setTitle("Simulating Experiment");

        Group group = new Group();

        Circle circle1 = ball1.getCircle();
        Circle circle2 = ball2.getCircle();

        circle1.setCenterX(ball1.getXcord());
        circle2.setCenterX(ball2.getXcord());
        circle1.setCenterY(scaleY(ball1.getYcord()));
        circle2.setCenterY(scaleY(ball1.getYcord()));

        group.getChildren().addAll(circle1, circle2);

        Scene simulationScene = new Scene(group, 1500, 900);
        simulationScene.setFill(Color.BLACK);

        animation(simulationStage, simulationScene, group, circle1, circle2);

        simulationStage.setScene(simulationScene);
        simulationStage.show();
    }
}
