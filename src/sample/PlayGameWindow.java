package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * Created by Сергей on 30.11.2019.
 */
public class PlayGameWindow {

    public void display(Stage primaryStage, Scene sceneAW, Player playerPlay) {

        primaryStage.setTitle("Game");
        primaryStage.setResizable(true);
        BorderPane root = new BorderPane();
        Scene scenePGW = new Scene(root, 1280, 720);
        primaryStage.setScene(scenePGW);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10));
        gridpane.setHgap(44);
        gridpane.setVgap(5);

        for (int i = 0; i < 3; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(300);
            gridpane.getColumnConstraints().add(column);
        }

        for (int i = 0; i < 9; i++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(25);
            gridpane.getRowConstraints().add(row);
        }

        Label userNameLabel = new Label("Игрок: " + playerPlay.getName());
        gridpane.add(userNameLabel, 0, 8);
        userNameLabel.setPrefSize(300, 25);

        Label totalLabel = new Label("Кол-во очков: " + Double.toString(playerPlay.getTotal()));
        gridpane.add(totalLabel, 2, 8);
        totalLabel.setPrefSize(300, 25);

        Button heroButton = new Button("Загадать персонажа!");
        heroButton.setPrefSize(400, 250);
        gridpane.add(heroButton, 1, 3);

        Button menuButton = new Button("Меню");
        menuButton.setPrefSize(400, 50);
        gridpane.add(menuButton, 1, 7);

        heroButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    List<Hero> heroes = DbHandlerH.getInstance().getAllProducts();
                    Random random = new Random();
                    int n = random.nextInt(2);

                    PlayGameWindowTwo playGameWindowTwo = new PlayGameWindowTwo();
                    playGameWindowTwo.display(primaryStage, scenePGW, playerPlay, heroes, n);


                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        menuButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(sceneAW);
            }
        });

        root.setCenter(gridpane);
    }

}
