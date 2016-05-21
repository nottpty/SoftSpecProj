package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.TabTitan;

/**
 * Created by mind on 13/05/2016.
 */
public class Monsters {

    private Texture mons;
    private int persent;
    private Rectangle bounds;
    public static int num;
    public Monsters(){
        num++;
        mons = new Texture("monster"+num+".png");
        persent = ((TabTitan.WIDTH/2)*100)/mons.getWidth();
    }

    public int getWidth(){
        return (int)(mons.getWidth()*(persent/100));
    }
    public int getHeight(){
        return (int)(mons.getHeight()*(persent/100));
    }
    public Texture getTexture(){return this.mons;}
}

