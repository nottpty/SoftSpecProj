package com.mygdx.game.sprites;

/**
 * Created by tannatanon on 5/30/2016 AD.
 */
public class Friend {

    int dmg;
    boolean isBought;

    public Friend(int dmg){
        this.dmg = dmg;
        isBought = false;
    }

    public void setDmg(int dmg){
        this.dmg = dmg;
    }

    public int getDmg(){
        return dmg;
    }

    public void bought(){
        if(isBought = false)
            isBought = true;
    }

}
