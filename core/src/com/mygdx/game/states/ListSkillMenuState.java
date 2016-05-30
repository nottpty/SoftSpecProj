package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.TabTitan;
import com.mygdx.game.sprites.Player;

/**
 * Created by mind on 28/05/2016.
 */
public class ListSkillMenuState extends MenuState {
    private int space,butSize;
    private Sprite doubleD,critical,stone,poison,frost,kill;
    private Rectangle boundDoubleD,boundCritical,boundStone,boundPoison,boundFrost,boundKill;
    public ListSkillMenuState(MenuStateManager msm,Player player){
        super(msm);

        Texture but = new Texture("buttonFriend.png");
        int persent = (int) (((TabTitan.WIDTH * 0.5) * 100) / but.getWidth());
        int y = (int) (but.getHeight() * (persent / 100.0));

        space = (int)(TabTitan.WIDTH*0.05);
        butSize = (int)(int)(TabTitan.WIDTH*0.11);

        doubleD = new Sprite(new Texture("skill1N.png"));
        critical = new Sprite(new Texture("skill2N.png"));
        stone = new Sprite(new Texture("skill3N.png"));
        poison = new Sprite(new Texture("skill4N.png"));
        frost = new Sprite(new Texture("skill5N.png"));
        kill = new Sprite(new Texture("skill6N.png"));

        doubleD.setSize(butSize,butSize);
        critical.setSize(butSize,butSize);
        stone.setSize(butSize,butSize);
        poison.setSize(butSize,butSize);
        frost.setSize(butSize,butSize);
        kill.setSize(butSize,butSize);

        doubleD.setY(y+space);
        critical.setY(y+space);
        stone.setY(y+space);
        poison.setY(y+space);
        frost.setY(y+space);
        kill.setY(y+space);

        doubleD.setX((int)(space+(space+butSize)*0));
        critical.setX((int)(space+(space+butSize)*1));
        stone.setX((int)(space+(space+butSize)*2));
        poison.setX((int)(space+(space+butSize)*3));
        frost.setX((int)(space+(space+butSize)*4));
        kill.setX((int)(space+(space+butSize)*5));

        boundDoubleD = new Rectangle(doubleD.getX(),doubleD.getY(),butSize,butSize);
        boundCritical = new Rectangle(critical.getX(),critical.getY(),butSize,butSize);
        boundStone = new Rectangle(stone.getX(),stone.getY(),butSize,butSize);
        boundPoison = new Rectangle(poison.getX(),poison.getY(),butSize,butSize);
        boundFrost = new Rectangle(frost.getX(),frost.getY(),butSize,butSize);
        boundKill = new Rectangle(kill.getX(),kill.getY(),butSize,butSize);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

        doubleD.draw(sb);
        critical.draw(sb);
        stone.draw(sb);
        poison.draw(sb);
        frost.draw(sb);
        kill.draw(sb);

    }

    @Override
    public void dispose() {

    }
}
