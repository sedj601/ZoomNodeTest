/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication258;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication258 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        PersonView personView = new PersonView(new Image(getClass().getResourceAsStream("person-female.png")), "Michelle", "Lisa", "Jefferson", "Loves Sedrick!");
        PersonView personView2 = new PersonView(new Image(getClass().getResourceAsStream("person-male.png")), "Sedrick", "LaShun", "Jefferson", "Loves Michelle!");
//        ScrollPane root = new ScrollPane();

        Pane group = new Pane(personView, personView2);
//        group.setLayoutX(0);
//        group.setLayoutY(0);
        group.setStyle("-fx-background-color: red");
        group.setOnScroll((event) -> {
            GUITools.zoom(group, event);
        });
//        root.setContent(group);
//        group.setOnScroll((event) -> {
//            GUITools.zoom(group, event);
//        });
//        root.setStyle("-fx-background-color: yellow");

        Scene scene = new Scene(group, 1080, 720);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
