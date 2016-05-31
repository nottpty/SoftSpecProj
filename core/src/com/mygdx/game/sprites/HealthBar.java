package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
    private BitmapFont bitmapFont;

    public HealthBar(Texture bg,Texture fg,int hp){
        health = hp;
        maxHealth = hp;
        bitmapFont = new BitmapFont();
        bitmapFont.getData().setScale(4.05f,4.0f);
        bitmapFont.setColor(Color.BLACK);

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
    public int getX(){
        return (int)this.healthBarBG.getX();
    }
    public int getY(){
        return (int)this.healthBarBG.getY();
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
        bitmapFont.draw(batch,this.health+"",healthBarBG.getX(),healthBarBG.getY()+healthBarBG.getHeight());
    }
}
