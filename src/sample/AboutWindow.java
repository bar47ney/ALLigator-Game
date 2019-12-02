package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by Сергей on 30.11.2019.
 */
public class AboutWindow {
    public void display(Stage primaryStage, Scene sceneMW) {

        try {
            File file = new File("C:/Users/Сергей/Desktop/Снимок.png");
            String localUrl = file.toURI().toURL().toString();
            Image image = new Image(localUrl);
            ImageView imageView = new ImageView(image);


            primaryStage.setTitle("About");
            primaryStage.setResizable(true);
            VBox root = new VBox();
            Scene sceneAbW = new Scene(root, 1280, 720);
            primaryStage.setScene(sceneAbW);

            Label aboutLabel = new Label();

            Button backButton = new Button("Назад");
            backButton.setPrefSize(200, 200);

            root.setAlignment(Pos.CENTER);
            root.getChildren().addAll(aboutLabel, backButton, imageView);


            backButton.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    primaryStage.setScene(sceneMW);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
