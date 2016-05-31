package com.mygdx.game.friends;

/**
 * Created by mind on 31/05/2016.
 */
public interface MyFriend {
    public int getDamage();
    public void levelUp();
    public boolean check();
    public void bought();
    public void upgrade();
    public void setDamage(int damage);
    public String getName();
    public String getText();
    public int getPrice();
}
