package com.example.m3lesson2_hw.Game;

import android.widget.Toast;

import com.example.m3lesson2_hw.StartGameFragment;

public class Logic {
    public static int roundNumber = 0;
    private static StringBuilder gameStats = new StringBuilder();

    public static void resetGame() {
        roundNumber = 0;
    }

    public static void startGame() {

        Boss boss = new Boss(750, 50, "Skeleton");
        Warrior warrior = new Warrior(280, 15, "Knight");
        Mage mage = new Mage(240, 20, "Merlin");
        Archer archer = new Archer(270, 10, "Robin");

        Hero[] heroes = {warrior, mage, archer};

        gameStats.setLength(0);
        showStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }



    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0) {
                hero.attack(boss);
            }
        }
        showStatistics(boss, heroes);
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            gameStats.append("Heroes won!!!\n");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            gameStats.append("Boss won!!!\n");
            return true;
        }
        return false;
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        gameStats.append("ROUND ").append(roundNumber).append(" -------------\n");
        gameStats.append(boss.toString()).append("\n");
        for (Hero hero : heroes) {
            gameStats.append(hero.toString()).append("\n");
        }
    }

    public static String getStatistics() {
        return gameStats.toString();
    }
}
