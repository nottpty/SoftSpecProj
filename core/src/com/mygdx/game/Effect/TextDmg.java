package com.mygdx.game.Effect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by tannatanon on 5/28/2016 AD.
 */
public class TextDmg extends AbstractText{

    private String text;
    private Vector2 pos;
    private float airTime;
    private boolean active;

    public TextDmg(String text){
        this.text = text;
        pos = new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        airTime = 0;
        active = false;
    }

    public void setText(String text){
        this.text = text;
    }

    public void Activate(){
        active = true;
    }

    public void update(float dt){
        airTime += dt;
        if(airTime >= 1){
            pos.y = Gdx.graphics.getHeight()/2;
            airTime = 0;
            active = false;
        }
        pos.y += 400*dt;
    }

    public boolean isActive(){
        return active;
    }

    public void draw(BitmapFont font, SpriteBatch batch){
        if(active)
            font.draw(batch,text,pos.x,pos.y);
    }
}
