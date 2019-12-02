package sample;

/**
 * Created by Сергей on 15.11.2019.
 */

public class Player {
    private int id;
    private String name;
    private String passw;
    private double total;

    public Player() {

    }

    public Player(int id, String name, String passw, double total) {
        this.id = id;
        this.name = name;
        this.passw = passw;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
