package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.TabTitan;

/**
 * Created by mind on 27/05/2016.
 */
public class HealthBar {
    private Sprite healthBarBG,healthBarFG;
    private int health;
    private int maxHealth;
    int barWidth = (int)(TabTitan.WIDTH*0.7);
    int barHeight = (int)(TabTitan.WIDTH*0.04);

    public HealthBar(Texture bg,Texture fg,int hp){
        health = hp;
        maxHealth = hp;

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

    public void setHP(int hp){
        this.health = hp;
        this.maxHealth = hp;
        healthBarFG.setScale(health/(float)maxHealth,1f);
        System.out.println("scale : "+health/(float)maxHealth);
    }
    public int getHP(){
        return this.health;
    }
    public void minusHP(int n){
        if(this.health<=0){
            this.health=0;
        }else{
            this.health-=n;
        }
        healthBarFG.setScale(health/(float)maxHealth,1f);
    }

    public void update(){

    }

    public void render(SpriteBatch batch){
        healthBarBG.draw(batch);
        healthBarFG.draw(batch);
    }
}
