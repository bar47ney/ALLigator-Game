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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Сергей on 30.11.2019.
 */
public class MainWindow {
    public void display(Stage primaryStage) {
        try {
            primaryStage.setTitle("Menu");
            primaryStage.setResizable(true);
            VBox root = new VBox();
            Scene sceneMW = new Scene(root, 1280, 720);
            GridPane gridpane = new GridPane();
            gridpane.setPadding(new Insets(10));

            Button playGameButton = new Button("Играть");
            playGameButton.setPrefSize(200,150);


            Button raitingViewButton = new Button("Рейтинг");
            raitingViewButton.setPrefSize(180,150);

            Button aboutViewButton = new Button("Правила игры");
            aboutViewButton.setPrefSize(160,150);

            Button exitButton = new Button("Выйти");
            exitButton.setPrefSize(140,150);

            root.setAlignment(Pos.CENTER);
            root.getChildren().add(playGameButton);
            root.getChildren().add(raitingViewButton);
            root.getChildren().add(aboutViewButton);
            root.getChildren().add(exitButton);

           playGameButton.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    AuthorizationWindow authorizationWindow = new AuthorizationWindow();
                    authorizationWindow.display(primaryStage,sceneMW);
                }
            });

            raitingViewButton.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    RaitingWindow raitingWindow = new RaitingWindow();
                    raitingWindow.display(primaryStage,sceneMW);
                }
            });

            aboutViewButton.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    AboutWindow aboutWindow = new AboutWindow();
                    aboutWindow.display(primaryStage,sceneMW);
                }
            });

            exitButton.setOnAction(new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent event)
                {
                    primaryStage.close();
                }
            });


            primaryStage.setScene(sceneMW);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
