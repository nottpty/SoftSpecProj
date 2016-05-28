package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by mind on 28/05/2016.
 */
public abstract class MenuState  {
    protected MenuStateManager msm;

    public MenuState(MenuStateManager msm){
        this.msm = msm;

    }
    public  abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}