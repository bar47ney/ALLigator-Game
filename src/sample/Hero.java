package sample;

/**
 * Created by Сергей on 15.11.2019.
 */

import java.sql.Array;
import java.util.ArrayList;

public class Hero {
    private int id;
    private String name;
    private double k_hero;
    private String setting;
    private double k_setting;

    public Hero() {

    }

    public Hero(int id, String name, double k_hero, String setting, double k_setting) {

        this.id = id;
        this.name = name;
        this.k_hero = k_hero;
        this.setting = setting;
        this.k_setting = k_setting;
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

    public double getK_hero() {
        return k_hero;
    }

    public void setK_hero(double k_hero) {
        this.k_hero = k_hero;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public double getK_setting() {
        return k_setting;
    }

    public void setK_setting(double k_setting) {
        this.k_setting = k_setting;
    }

}
