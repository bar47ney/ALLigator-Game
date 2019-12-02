package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by Сергей on 27.11.2019.
 */
public class Program {
    public static void main(String... args) {
        try {
            List<Hero> heroes;
            Hero hero;
            List<Player> players;
            Player player;
            heroes = DbHandlerH.getInstance().getAllProducts();
            players = DbHandlerP.getInstance().getAllProducts();
            ListIterator<Hero> listIterator = heroes.listIterator();
            ListIterator<Player> listIteratorrr = players.listIterator();
            while (listIterator.hasNext()) {
                hero = listIterator.next();
                System.out.println(hero.getName());
                System.out.println(hero.getK_hero() * 2);
                System.out.println(hero.getSetting());
                System.out.println(hero.getK_setting());
            }
            while (listIteratorrr.hasNext()) {
                player = listIteratorrr.next();
                System.out.println(player.getName());
                System.out.println(player.getTotal());
                System.out.println(player.getPassw());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}

