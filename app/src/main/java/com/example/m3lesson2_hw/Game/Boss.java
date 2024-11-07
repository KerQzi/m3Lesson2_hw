package com.example.m3lesson2_hw.Game;

public class Boss extends GameEntity {

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }


    public void attack(Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                hero.setHealth(hero.getHealth() - this.getDamage());
            }
        }
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString();
    }
}
