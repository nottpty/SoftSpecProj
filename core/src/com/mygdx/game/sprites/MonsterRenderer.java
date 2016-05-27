package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Created by mind on 27/05/2016.
 */
public class MonsterRenderer {
    private MonsterFactory mons;
    private int numMon;
    public MonsterRenderer(){
        mons = new MonsterFactory();

    }
    public void setNumMon(int num){
        this.numMon = num;
    }
    public int getNumMon(){
        return this.numMon;
    }
    public void render(Batch batch){
        batch.begin();
        mons.createMonster(numMon);

        batch.end();
    }
}
