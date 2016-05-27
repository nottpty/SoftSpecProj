package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.TabTitan;

/**
 * Created by mind on 27/05/2016.
 */
public class HealthBar {

    private Sprite healthBarBG,healthBarFG;
    private int health;
    int barWidth = (int)(TabTitan.WIDTH*0.7);
    int barHeight = (int)(TabTitan.WIDTH*0.04);

    public HealthBar(Texture bg,Texture fg){
        health = 100;

        healthBarBG = new Sprite(bg);
        healthBarFG = new Sprite(fg);

        healthBarBG.setSize(barWidth,barHeight);
        healthBarFG.setSize(barWidth,barHeight);

        healthBarBG.setX((TabTitan.WIDTH/2)-(barWidth/2));
        healthBarBG.setY(TabTitan.HEIGHT-(int)(TabTitan.HEIGHT*0.1));
        healthBarFG.setX((TabTitan.WIDTH/2)-(barWidth/2));
        healthBarFG.setY(TabTitan.HEIGHT-(int)(TabTitan.HEIGHT*0.1));

        healthBarFG.setOrigin(0,0);

    }
    public Sprite getHealthBarBG(){
        return this.getHealthBarBG();
    }
    public Sprite getHealthBarFG(){
        return this.getHealthBarFG();
    }
    public void minusHP(int n){
        if(this.health<=0){
            this.health=0;
        }else{
            this.health-=n;
        }
        healthBarFG.setScale(health/(float)100,1f);
    }

    public void update(){

    }

    public void render(Batch batch){
        batch.begin();
        healthBarBG.draw(batch);
        healthBarFG.draw(batch);

        batch.end();
    }
}
