package sample;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Сергей on 28.11.2019.
 */
public class DbHandlerP {

    private static final String CON_STR = "jdbc:sqlite:c:\\SQLite\\players.db";

    private static DbHandlerP instance = null;

    public static synchronized DbHandlerP getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandlerP();
        return instance;
    }

    private Connection connection;

    private DbHandlerP() throws SQLException {

        DriverManager.registerDriver(new JDBC());

        this.connection = DriverManager.getConnection(CON_STR);
    }

    public List<Player> getAllProducts() {

        try (Statement statement = this.connection.createStatement()) {
            List<Player> players = new ArrayList<Player>();
            ResultSet resultSet = statement.executeQuery("SELECT id, name, password, total FROM players");
            while (resultSet.next()) {
                players.add(new Player(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("password"),
                        resultSet.getDouble("total")));
            }
            return players;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    public void addProduct(Player player) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Players(`name`, `password`, `total`) " +
                        "VALUES(?, ?, ?)")) {
            statement.setObject(1, player.getName());
            statement.setObject(2, player.getPassw());
            statement.setObject(3, player.getTotal());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteProduct(int id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM Players WHERE id = ?")) {
            statement.setObject(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
