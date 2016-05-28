package com.mygdx.game.Effect;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by tannatanon on 5/28/2016 AD.
 */
public class TextDmg {

    private String text;
    private Vector2 pos;
    private float airTime;

    public TextDmg(String text,float x,float y){
        this.text = text;
        pos = new Vector2(x,y);
        airTime = 0;
    }

    public void setText(String text){
        this.text = text;
    }

    public void update(float dt){
        airTime += dt;
        if(airTime >= 1){
            pos.y = 0;
        }
        pos.y += 100*dt;
    }

    public void draw(BitmapFont font, SpriteBatch batch){
        font.draw(batch,text,pos.x,pos.y);
    }
}
