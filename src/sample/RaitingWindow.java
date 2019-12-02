package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Сергей on 30.11.2019.
 */
public class RaitingWindow {
    public void display(Stage primaryStage, Scene sceneMW) {

        primaryStage.setTitle("Raiting");
        primaryStage.setResizable(true);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1280, 720);
        primaryStage.setScene(scene);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(10));
        gridpane.setHgap(44);
        gridpane.setVgap(5);

        for(int i = 0; i < 5; i++)
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(200);
            gridpane.getColumnConstraints().add(column);
        }

        for(int i = 0; i < 100; i++)
        {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(2);
            gridpane.getRowConstraints().add(row);
        }

        Label nameLabel = new Label("Никнейм");
        gridpane.add(nameLabel,0,0);
        nameLabel.setPrefSize(200,100);

        Label totalLabel = new Label("Количество очков");
        gridpane.add(totalLabel,1,0);
        totalLabel.setPrefSize(200,100);

        Button backButton = new Button("Назад");
        backButton.setPrefSize(200, 200);
        gridpane.add(backButton,2,5);

        try {
            List<Player> players = DbHandlerP.getInstance().getAllProducts();
            ListIterator<Player> listIterator = players.listIterator();
            Player player;
            int x = 0;
            int y = 1;
            while (listIterator.hasNext())
            {
                player = listIterator.next();
                Label playerNameLabel = new Label(player.getName());
                gridpane.add(playerNameLabel,x,y);
                playerNameLabel.setPrefSize(200,100);

                Label playerTotalLabel = new Label(Double.toString(player.getTotal()));
                gridpane.add(playerTotalLabel,x+1,y);
                playerTotalLabel.setPrefSize(200,100);

                y++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.setScene(sceneMW);
            }
        });
        root.setCenter(gridpane);
    }
}
