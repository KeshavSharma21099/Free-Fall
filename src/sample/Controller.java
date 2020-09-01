package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Controller extends Application {
    private Ball ball1, ball2;
    private Animate animation;

    public void onCustomBtnClick(Stage stage) {
        Label heading = new Label("Custom Ball");
        heading.setFont(new Font("Georgia", 40));

        //Sliders
        Label height_label = new Label("Height");
        height_label.setFont(new Font("Georgia", 24));
        Label display_height = new Label("0.000");
        Slider height_slider = new Slider(0.0, 50.0, 0.0);
        height_slider.setMaxWidth(300);
        Label coefficient_label = new Label("Coefficient of Restitution");
        coefficient_label.setFont(new Font("Georgia", 24));
        Label display_coefficient = new Label("0.000");
        Slider coefficient_slider = new Slider(0.0, 1.0, 0.0);
        coefficient_slider.setMaxWidth(300);

        //Slider EventHandlers
        height_slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                display_height.textProperty().setValue(
                        String.format("%.3f", (double)height_slider.getValue())
                );
            }

        });

        coefficient_slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                display_coefficient.textProperty().setValue(
                        String.format("%.3f", (double)coefficient_slider.getValue())
                );
            }

        });

        //Submit Button
        Button submit = new Button("Submit");
        submit.setFont(new Font("Georgia", 20));

        //Submit Button onclick
        submit.setOnAction(e -> {
            double height = height_slider.getValue();
            double coefficient = coefficient_slider.getValue();

            if(ball1 == null) {
                ball1 = new CustomBall(Color.DARKRED, 250, height, coefficient);
                VBox layout = createChoosingScene(stage, "Choose the Second Ball");
                System.out.println("Ball 1: X- " + ball1.getXcord() + " Y- " + ball1.getYcord() + " Coefficient: " + coefficient);
                Scene secondBallScene = new Scene(layout, 600, 600);
                stage.setScene(secondBallScene);
            } else {
                ball2 = new CustomBall(Color.DARKGREEN, 450, height, coefficient);
                System.out.println("Ball 2: X- " + ball2.getXcord() + " Y- " + ball2.getYcord() + " Coefficient: " + coefficient);
                animation = new Animate(ball1, ball2);
                animation.simulateExperiment();
            }
        });

        VBox layout = new VBox(heading, height_label, display_height, height_slider, coefficient_label, display_coefficient, coefficient_slider, submit);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setSpacing(40);

        Scene newScene = new Scene(layout, 600, 600);
        stage.setScene(newScene);

    }

    public void onElasticBtnClick(Stage stage) {
        Label heading = new Label("Elastic Ball");
        heading.setFont(new Font("Georgia", 40));

        //Sliders
        Label height_label = new Label("Height");
        height_label.setFont(new Font("Georgia", 24));
        Label display_height = new Label("0.000");
        Slider height_slider = new Slider(0.0, 50.0, 0.0);
        height_slider.setMaxWidth(300);

        //Slider EventHandlers
        height_slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                display_height.textProperty().setValue(
                        String.format("%.3f", (double)height_slider.getValue())
                );
            }

        });

        //Submit Button
        Button submit = new Button("Submit");
        submit.setFont(new Font("Georgia", 20));

        //Submit Button onclick
        submit.setOnAction(e -> {
            double height = height_slider.getValue();

            if(ball1 == null) {
                ball1 = new ElasticBall(Color.DARKRED, 250, height);
                VBox layout = createChoosingScene(stage, "Choose the Second Ball");
                System.out.println("Ball 1: X- " + ball1.getXcord() + " Y- " + ball1.getYcord());
                Scene secondBallScene = new Scene(layout, 600, 600);
                stage.setScene(secondBallScene);
            } else {
                ball2 = new ElasticBall(Color.DARKGREEN, 450, height);
                System.out.println("Ball 2: X- " + ball2.getXcord() + " Y- " + ball2.getYcord());
                animation = new Animate(ball1, ball2);
                animation.simulateExperiment();
            }
        });

        VBox layout = new VBox(heading, height_label, display_height, height_slider, submit);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setSpacing(40);

        Scene newScene = new Scene(layout, 600, 600);
        stage.setScene(newScene);

    }

    public void onInelasticBtnClick(Stage stage) {
        Label heading = new Label("Inelastic Ball");
        heading.setFont(new Font("Georgia", 40));

        //Sliders
        Label height_label = new Label("Height");
        height_label.setFont(new Font("Georgia", 24));
        Label display_height = new Label("0.000");
        Slider height_slider = new Slider(0.0, 50.0, 0.0);
        height_slider.setMaxWidth(300);

        //Slider EventHandlers
        height_slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                display_height.textProperty().setValue(
                        String.format("%.3f", (double)height_slider.getValue())
                );
            }

        });

        //Submit Button
        Button submit = new Button("Submit");
        submit.setFont(new Font("Georgia", 20));

        //Submit Button onclick
        submit.setOnAction(e -> {
            double height = height_slider.getValue();

            if(ball1 == null) {
                ball1 = new InelasticBall(Color.DARKRED, 250, height);
                VBox layout = createChoosingScene(stage, "Choose the Second Ball");
                System.out.println("Ball 1: X- " + ball1.getXcord() + " Y- " + ball1.getYcord());
                Scene secondBallScene = new Scene(layout, 600, 600);
                stage.setScene(secondBallScene);
            } else {
                ball2 = new InelasticBall(Color.DARKGREEN, 450, height);
                System.out.println("Ball 2: X- " + ball2.getXcord() + " Y- " + ball2.getYcord());
                animation = new Animate(ball1, ball2);
                animation.simulateExperiment();
            }
        });

        VBox layout = new VBox(heading, height_label, display_height, height_slider, submit);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setSpacing(40);

        Scene newScene = new Scene(layout, 600, 600);
        stage.setScene(newScene);

    }

    public VBox createChoosingScene(Stage stage, String title) {

        //Heading
        Label heading = new Label(title);
        heading.setFont(new Font("Georgia", 40));

        //Buttons
        Button customBtn = new Button("Custom Ball");
        customBtn.setFont(new Font("Georgia", 20));
        Button elasticBtn = new Button("Elastic Ball");
        elasticBtn.setFont(new Font("Georgia", 20));
        Button inelasticBtn = new Button("Inelastic Ball");
        inelasticBtn.setFont(new Font("Georgia", 20));

        customBtn.setOnAction(e -> {
            onCustomBtnClick(stage);
        });

        elasticBtn.setOnAction(e -> {
            onElasticBtnClick(stage);
        });

        inelasticBtn.setOnAction(e -> {
            onInelasticBtnClick(stage);
        });

        //Layout
        VBox layout = new VBox(heading, customBtn, elasticBtn, inelasticBtn);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setSpacing(50);

        return layout;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Restitution");
        VBox layout = null;

        // To Show the Scene that chooses experiment Balls
        layout = createChoosingScene(primaryStage,"Choose the First Ball");

        Scene primaryScene = new Scene(layout, 600, 600);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
