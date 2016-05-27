package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.TabTitan;

/**
 * Created by mind on 27/05/2016.
 */
public class FriendBut implements Button {
    private Texture but;
    private int persent;
    private Rectangle bounds;

    public FriendBut(){

        but = new Texture("buttonFriend.png");
        persent = (int)(((TabTitan.WIDTH*0.5)*100)/but.getWidth());
    }

    public int getWidth(){
        return (int)(but.getWidth()*(persent/100.0));
    }
    public int getHeight(){
        return (int)(but.getHeight()*(persent/100.0));
    }
    public Texture getTexture(){return this.but;}

}
