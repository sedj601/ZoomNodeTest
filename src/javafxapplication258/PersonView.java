/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication258;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
final public class PersonView extends VBox
{

    private Image image;
    private final Label firstName = new Label();
    private final Label middleName = new Label();
    private final Label lastName = new Label();
    private final TextArea bio = new TextArea();

    private final ImageView imageView;

    private double orgSceneX, orgSceneY;
    private double orgTranslateX, orgTranslateY;

    public PersonView(Image image, String firstName, String middleName, String lastName, String bio)
    {
        this.image = image;
        this.firstName.setText(firstName);
        this.middleName.setText(middleName);
        this.lastName.setText(lastName);
        this.bio.setText(bio);

        imageView = new ImageView(image);
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
        VBox namesContainer = new VBox(this.firstName, this.middleName, this.lastName);
        namesContainer.setAlignment(Pos.CENTER);
        HBox topRoot = new HBox(imageView, namesContainer);

        this.setPadding(new Insets(10, 10, 10, 10));
        this.setPrefSize(600, 400);
        this.getChildren().addAll(topRoot, this.bio);
        this.setOnMouseExited(onMouseExistedEventHandler);
        this.setOnMouseEntered(onMouseEnteredEventHandler);
        this.setOnMousePressed(onMousePressedEventHandler);
        this.setOnMouseDragged(onMouseDraggedEventHandler);
        this.setStyle("-fx-background-color: yellow");
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
        imageView.setImage(image);
    }

    public String getFirstName()
    {
        return firstName.getText();
    }

    public void setFirstName(String firstName)
    {
        this.firstName.setText(firstName);
    }

    public String getMiddleName()
    {
        return middleName.getText();
    }

    public void setMiddleName(String middleName)
    {
        this.middleName.setText(middleName);
    }

    public String getLastName()
    {
        return lastName.getText();
    }

    public void setLastName(String lastName)
    {
        this.lastName.setText(lastName);
    }

    public String getBio()
    {
        return bio.getText();
    }

    public void setBio(String bio)
    {
        this.bio.setText(bio);
    }

    EventHandler<MouseEvent> onMouseEnteredEventHandler = (MouseEvent event) -> {
        Stage stage = (Stage) ((VBox) event.getSource()).getScene().getWindow();
        stage.getScene().setCursor(Cursor.HAND);
    };

    EventHandler<MouseEvent> onMouseExistedEventHandler = (MouseEvent event) -> {
        Stage stage = (Stage) ((VBox) event.getSource()).getScene().getWindow();
        stage.getScene().setCursor(Cursor.DEFAULT);
    };

    EventHandler<MouseEvent> onMousePressedEventHandler
            = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent event)
        {
            Stage stage = (Stage) ((VBox) event.getSource()).getScene().getWindow();
            stage.getScene().setCursor(Cursor.CLOSED_HAND);
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
            orgTranslateX = ((VBox) (event.getSource())).getLayoutX();
            orgTranslateY = ((VBox) (event.getSource())).getLayoutY();
        }
    };

    EventHandler<MouseEvent> onMouseDraggedEventHandler
            = new EventHandler<MouseEvent>()
    {

        @Override
        public void handle(MouseEvent t)
        {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;

            ((VBox) (t.getSource())).setLayoutX(newTranslateX);
            ((VBox) (t.getSource())).setLayoutY(newTranslateY);
        }
    };

}
