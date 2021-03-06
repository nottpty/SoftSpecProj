package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.TabTitan;

/**
 * Created by mind on 13/05/2016.
 */
public class Monsters{

    private Sprite mon;
    private int persent;
    Texture pix;
    private Rectangle bounds;
    private int hp;
    private int bounty;
    public Monsters(int num,int hp,int bounty){
        this.hp = hp;
        this.bounty = bounty;
        pix = new Texture("monster"+num+".png");
        mon = new Sprite(pix);
        persent = ((int)(TabTitan.WIDTH*0.8)*100)/pix.getWidth();
        mon.setSize(getWidth(),getHeight());
        mon.setX((int)((TabTitan.WIDTH/2)-(getWidth()/2)));
        mon.setY((int)(TabTitan.HEIGHT-(TabTitan.HEIGHT*0.6)));
    }
    public void setHP(int hp){
        this.hp = hp;
    }
    public void setBounty(int bounty) { this.bounty = bounty; }
    public int getWidth(){
        return (int)(pix.getWidth()*(persent/100));
    }
    public int getHP(){return this.hp;}
    public int getBounty() { return this.bounty; }
    public int getHeight(){
        return (int)(pix.getHeight()*(persent/100));
    }
    public Texture getTexture(){return this.pix;}
    public void render(SpriteBatch batch){
        mon.draw(batch);
    }

}

