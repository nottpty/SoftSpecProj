package com.mygdx.game.friends;

/**
 * Created by mind on 31/05/2016.
 */
public class Aragorn implements MyFriend {
    private int level,dmg,price;
    private boolean check;
    private String name;

    public Aragorn(){
        this.level = 0;
        this.dmg = 0;
        this.check = false;
        this.name = "Aragorn";
        this.price = 400;
    }
    @Override
    public int getPrice(){
        return this.price;
    }
    @Override
    public int getDamage() {
        return this.dmg;
    }

    @Override
    public void levelUp() {
        this.level++;
        price += (int)(price*1.7);
    }

    @Override
    public boolean check() {
        return this.check;
    }

    @Override
    public void bought() {
        if(check)
            upgrade();
        if(!check) {
            setDamage(100);
            levelUp();
        }
        this.check = true;
    }

    public void upgrade() {
        if(check) {
            levelUp();
            this.setDamage(this.dmg + ((int) (dmg * 0.5)));
        }
    }
    @Override
    public void setDamage(int damage) {
        this.dmg = damage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getText() {
        return this.name+"\nLevel : "+this.level+"\nPrice : "+this.price;
    }
}
