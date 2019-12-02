package sample;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;

/**
 * Created by Сергей on 27.11.2019.
 */
public class DbHandlerH {

    private static final String CON_STR = "jdbc:sqlite:c:\\SQLite\\heroes.db";

    private static DbHandlerH instance = null;

    public static synchronized DbHandlerH getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandlerH();
        return instance;
    }

    private Connection connection;

    private DbHandlerH() throws SQLException {

        DriverManager.registerDriver(new JDBC());

        this.connection = DriverManager.getConnection(CON_STR);
    }

    public List<Hero> getAllProducts() {


        try (Statement statement = this.connection.createStatement()) {

            List<Hero> heroes = new ArrayList<Hero>();

            ResultSet resultSet = statement.executeQuery("SELECT id, name, k_hero, setting, k_setting FROM heroes");

            while (resultSet.next()) {
                heroes.add(new Hero(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("k_hero"),
                        resultSet.getString("setting"),
                        resultSet.getDouble("k_setting")));
            }

            return heroes;

        } catch (SQLException e) {
            e.printStackTrace();

            return Collections.emptyList();
        }
    }


    public void addProduct(Hero hero) {

        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Heroes(`name`, `k_hero`, `setting`,`k_setting`) " +
                        "VALUES(?, ?, ?, ?)")) {
            statement.setObject(1, hero.getName());
            statement.setObject(2, hero.getK_hero());
            statement.setObject(3, hero.getSetting());
            statement.setObject(4, hero.getK_setting());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteProduct(int id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM Heroes WHERE id = ?")) {
            statement.setObject(1, id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
