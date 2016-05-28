package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by mind on 27/05/2016.
 */
public class MonsterRenderer {
    private MonsterFactory mons;
    private int numMon;
    public MonsterRenderer(int num){
        mons = new MonsterFactory();
        this.numMon = num;
    }
    public void setNumMon(int num){
        this.numMon = num;
    }
    public int getNumMon(){
        return this.numMon;
    }
    public void render(SpriteBatch batch){
        mons.createMonster(numMon).render(batch);
    }
}
