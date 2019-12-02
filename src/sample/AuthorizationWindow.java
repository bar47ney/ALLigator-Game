package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

/**
 * Created by Сергей on 30.11.2019.
 */
public class AuthorizationWindow {
    public void display(Stage primaryStage, Scene sceneMW) {


        primaryStage.setTitle("Authorization");
        primaryStage.setResizable(true);
        BorderPane root = new BorderPane();
        Scene sceneAW = new Scene(root, 1280, 720);
        primaryStage.setScene(sceneAW);

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

        Label userNameLabel = new Label("Никнейм");
        gridpane.add(userNameLabel, 0, 0);
        userNameLabel.setPrefSize(300, 25);

        TextField userNameField = new TextField();
        gridpane.add(userNameField, 1, 0);

        Label passwordLabel = new Label("Пароль");
        gridpane.add(passwordLabel, 0, 1);
        passwordLabel.setPrefSize(300, 25);

        TextField passwordField = new TextField();
        gridpane.add(passwordField, 1, 1);

        Label password2Label = new Label("Повторите пароль (при регистрации)");
        gridpane.add(password2Label, 0, 2);
        password2Label.setPrefSize(300, 25);

        TextField password2Field = new TextField();
        gridpane.add(password2Field, 1, 2);

        Button checkInButton = new Button("Зарегестрироваться");
        checkInButton.setPrefSize(400, 50);
        gridpane.add(checkInButton, 1, 4);

        Button signInButton = new Button("Вход");
        signInButton.setPrefSize(400, 50);
        gridpane.add(signInButton, 1, 5);

        Button playButton = new Button("Играть!");
        playButton.setPrefSize(400, 100);
        gridpane.add(playButton, 1, 6);

        Button backButton = new Button("Назад");
        backButton.setPrefSize(400, 50);
        gridpane.add(backButton, 1, 7);

        checkInButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (password2Field.getText().equals(passwordField.getText())) {
                    Player playerCheckIn = new Player();
                    playerCheckIn.setName(userNameField.getText());
                    playerCheckIn.setPassw(passwordField.getText());
                    playerCheckIn.setTotal(0);
                    try {
                        DbHandlerP.getInstance().addProduct(playerCheckIn);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Регистрация");
                        alert.setContentText("Вы успешно зарегестрировались!");
                        alert.showAndWait();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Ошибка регистрации");
                    alert.setContentText("Ошибка, попробуйте снова!");
                    alert.showAndWait();
                }

            }
        });

        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    List<Player> players = DbHandlerP.getInstance().getAllProducts();
                    ListIterator<Player> playerListIterator = players.listIterator();
                    Player playerGame;
                    while (playerListIterator.hasNext()) {
                        playerGame = playerListIterator.next();
                        if (userNameField.getText().equals(playerGame.getName())) {
                            if (passwordField.getText().equals(playerGame.getPassw())) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText("Вход в систему");
                                alert.setContentText("Вы успешно вошли в систему!");
                                alert.showAndWait();
                                playButton.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent event) {
                                        PlayGameWindow playGameWindow = new PlayGameWindow();
                                        Player playerPlay;
                                        playerPlay = playerListIterator.previous();
                                        playGameWindow.display(primaryStage,sceneAW, playerPlay);
                                    }
                                });
                                break;
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setHeaderText("Вход в систему");
                                alert.setContentText("Пароль введён неверно!");
                                alert.showAndWait();
                                break;
                            }
                        } else {
                            if (!playerListIterator.hasNext()) {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setHeaderText("Вход в систему");
                                alert.setContentText("Вас нет в системе! Зарегестрируйтесь!");
                                alert.showAndWait();
                                break;

                            } else {
                                continue;
                            }

                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(sceneMW);
            }
        });
        root.setCenter(gridpane);
    }
}
