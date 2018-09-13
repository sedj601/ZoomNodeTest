/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication258;

import javafx.application.Application;
import javafx.scene.Group;
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

        Group currentGroup = new Group();
        Pane masterPane = new Pane(currentGroup);

        PersonView personView = new PersonView(new Image(getClass().getResourceAsStream("person-female.png")), "Michelle", "Lisa", "Jefferson", "Loves Sedrick!", currentGroup, masterPane);
        PersonView personView2 = new PersonView(new Image(getClass().getResourceAsStream("person-male.png")), "Sedrick", "LaShun", "Jefferson", "Loves Michelle!", currentGroup, masterPane);

        currentGroup.getChildren().addAll(personView, personView2);

        masterPane.setStyle("-fx-background-color: red");
        currentGroup.setOnScroll((event) -> {
            GUITools.zoom(masterPane, event);
        });

        Scene scene = new Scene(masterPane, 1080, 720);

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
