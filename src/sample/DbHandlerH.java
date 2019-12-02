package sample;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;

/**
 * Created by Сергей on 27.11.2019.
 */
public class DbHandlerH {
    // Константа, в которой хранится адрес подключения
    private static final String CON_STR = "jdbc:sqlite:c:\\SQLite\\heroes.db";

    // Используем шаблон одиночка, чтобы не плодить множество
    // экземпляров класса DbHandler
    private static DbHandlerH instance = null;

    public static synchronized DbHandlerH getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandlerH();
        return instance;
    }

    // Объект, в котором будет храниться соединение с БД
    private Connection connection;

    private DbHandlerH() throws SQLException {
        // Регистрируем драйвер, с которым будем работать
        // в нашем случае Sqlite
        DriverManager.registerDriver(new JDBC());
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public List<Hero> getAllProducts() {

        // Statement используется для того, чтобы выполнить sql-запрос
        try (Statement statement = this.connection.createStatement()) {
            // В данный список будем загружать наши продукты, полученные из БД
            List<Hero> heroes = new ArrayList<Hero>();
            // В resultSet будет храниться результат нашего запроса,
            // который выполняется командой statement.executeQuery()
            ResultSet resultSet = statement.executeQuery("SELECT id, name, k_hero, setting, k_setting FROM heroes");
            // Проходимся по нашему resultSet и заносим данные в products
            while (resultSet.next()) {
                heroes.add(new Hero(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("k_hero"),
                        resultSet.getString("setting"),
                        resultSet.getDouble("k_setting")));
            }
            // Возвращаем наш список
            return heroes;

        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
    }

    // Добавление продукта в БД
    public void addProduct(Hero hero) {
        // Создадим подготовленное выражение, чтобы избежать SQL-инъекций
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Heroes(`name`, `k_hero`, `setting`,`k_setting`) " +
                        "VALUES(?, ?, ?, ?)")) {
            statement.setObject(1, hero.getName());
            statement.setObject(2, hero.getK_hero());
            statement.setObject(3, hero.getSetting());
            statement.setObject(4, hero.getK_setting());
            // Выполняем запрос
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Удаление продукта по id
    public void deleteProduct(int id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM Heroes WHERE id = ?")) {
            statement.setObject(1, id);
            // Выполняем запрос
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
