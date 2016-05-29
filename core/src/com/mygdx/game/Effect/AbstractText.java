package com.mygdx.game.Effect;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by tannatanon on 5/29/2016 AD.
 */
public abstract class AbstractText {
    public abstract void update(float dt);
    public abstract void draw(BitmapFont font,SpriteBatch batch);
}
