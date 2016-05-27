package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.TabTitan;

/**
 * Created by mind on 13/05/2016.
 */
public class Monsters{

    private Sprite mon;
    private int persent;
    private int hp;
    Texture pix;
    private Rectangle bounds;
    private HealthBar hpBar;
    public Monsters(int num,int hp){
        pix = new Texture("monster"+num+".png");
        mon = new Sprite(pix);
        this.hp = hp;
        persent = ((int)(TabTitan.WIDTH*0.8)*100)/pix.getWidth();
        mon.setSize(getWidth(),getHeight());
        mon.setX((int)((TabTitan.WIDTH/2)-(getWidth()/2)));

        mon.setY((int)(TabTitan.HEIGHT-(TabTitan.HEIGHT*0.6)));
    }
    public int getWidth(){
        return (int)(pix.getWidth()*(persent/100));
    }
    public int getHeight(){
        return (int)(pix.getHeight()*(persent/100));
    }
    public void setHealth(int hp){

    }
    public Texture getTexture(){return this.pix;}
    public void render(Batch batch){
        batch.begin();
        mon.draw(batch);
        HealthBar.getInstance().getHealthBarBG().draw(batch);
        HealthBar.getInstance().getHealthBarFG().draw(batch);
        batch.end();
    }
}


