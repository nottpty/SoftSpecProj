package com.mygdx.game.TimerTask;

import com.mygdx.game.sprites.HealthBar;

import java.util.TimerTask;

/**
 * Created by tannatanon on 5/27/2016 AD.
 */
public class DpsTimer extends TimerTask {

    int dps;
    HealthBar hp;

    public DpsTimer(int dps,HealthBar hp){
        this.dps = dps;
        this.hp = hp;
    }

    public void run(){
        hp.minusHP(dps);
    }

    public void setDps(int dps){
        this.dps = dps;
    }
}
