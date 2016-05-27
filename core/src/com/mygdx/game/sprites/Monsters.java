package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
    public Monsters(int num){
        pix = new Texture("monster"+num+".png");
        mon = new Sprite(pix);
        persent = ((int)(TabTitan.WIDTH*0.8)*100)/pix.getWidth();
        mon.setSize(getWidth(),getHeight());
    }
    public int getWidth(){
        return (int)(mon.getWidth()*(persent/100));
    }
    public int getHeight(){
        return (int)(pix.getHeight()*(persent/100));
    }
    public Texture getTexture(){return this.pix;}


}

