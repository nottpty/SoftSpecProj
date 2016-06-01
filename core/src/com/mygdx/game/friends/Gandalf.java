package com.mygdx.game.friends;

/**
 * Created by mind on 31/05/2016.
 */
public class Gandalf implements MyFriend {

    private int level,dmg,price;
    private boolean check;
    private String name;

    public Gandalf(){
        this.level = 0;
        this.dmg = 0;
        this.check = false;
        this.name = "Gandalf";
        this.price = 500;
    }
    @Override
    public int getDamage() {
        return this.dmg;
    }

    @Override
    public void levelUp() {
        this.level++;
        price += (int)(level*10+price*0.55);
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
            this.setDamage(this.dmg + ((int) (dmg * 0.5)) + (level * 7));
        }
    }
    @Override
    public int getPrice(){
        return this.price;
    }
    @Override
    public void bought() {
        if(check)
            upgrade();
        if(!check) {
            setDamage(150);
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
        return this.name+"\nLevel : "+this.level+"\nPrice : "+this.price;
    }
}
