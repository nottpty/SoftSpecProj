package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by mind on 28/05/2016.
 */
public class MenuStateManager {
    private Stack<MenuState> states;

    public MenuStateManager(){
        states = new Stack<MenuState>();
    }

    public void push(MenuState state){states.push(state);}

    public void pop(){states.pop().dispose();}

    public void set(MenuState state){
        states.pop();
        states.push(state);
    }

    public void update(float dt){states.peek().update(dt);}

    public void render(SpriteBatch sb){states.peek().render(sb);}
}
