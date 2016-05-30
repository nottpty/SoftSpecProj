package com.mygdx.game.friends;

/**
 * Created by mind on 31/05/2016.
 */
public class Aragorn implements MyFriend {
    private int level,dmg;
    private boolean check;
    private String name;

    public Aragorn(){
        this.level = 0;
        this.check = false;
        this.name = "Aragorn";
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

    @Override
    public void buySkill() {
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
