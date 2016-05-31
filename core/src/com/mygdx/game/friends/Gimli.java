package com.mygdx.game.friends;

/**
 * Created by mind on 31/05/2016.
 */
public class Gimli implements MyFriend {
    private int level,dmg;
    private boolean check;
    private String name;

    public Gimli(){
        this.level = 0;
        this.dmg = 0;
        this.check = false;
        this.name = "Gimli";
    }
    @Override
    public int getDamage() {
        return this.dmg;
    }

    @Override
    public void levelUp() {
        this.level++;
    }

    @Override
    public boolean check() {
        return this.check;
    }

    public void setDamage(int damage) {
        this.dmg = damage;
    }

    public void upgrade() {
        if(check) {
            levelUp();
            this.setDamage(this.dmg + ((int) (dmg * 0.5)));
        }
    }

    @Override
    public void bought() {
        if(check)
            upgrade();
        if(!check) {
            setDamage(500);
            levelUp();
        }
        this.check = true;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getText() {
        return this.name+"\nLevel : "+this.level;
    }
}
