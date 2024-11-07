package com.example.m3lesson2_hw.Game;

public abstract class Hero extends GameEntity{

    public Hero(int health, int damage, String name) {
        super(health, damage, name);
    }

    public void attack(Boss boss) {
        boss.setHealth(boss.getHealth() - this.getDamage());
    }
}
