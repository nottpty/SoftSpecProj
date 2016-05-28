package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.TabTitan;

/**
 * Created by mind on 28/05/2016.
 */
public class FriendMenuState extends MenuState{
    private Texture bg;
    private Rectangle rSkill1,rSkill2,rSkill3,rSkill4,rSkill5,rSkill6;
    private Texture skill1,skill2,skill3,skill4,skill5,skill6;
    private int persentMenu;
    public FriendMenuState(MenuStateManager msm){
        super(msm);
        bg = new Texture("menuBG.png");
        skill1 = new Texture("skill1.png");
        skill2 = new Texture("skill2.png");
        skill3 = new Texture("skill3.png");
        skill4 = new Texture("skill4.png");
        skill5 = new Texture("skill5.png");
        skill6 = new Texture("skill6.png");

        persentMenu = (int)((TabTitan.WIDTH*100.0)/bg.getWidth());
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        Texture but = new Texture("buttonFriend.png");
        int persent = (int)(((TabTitan.WIDTH*0.5)*100)/but.getWidth());
        sb.draw(bg,0,(int)(but.getHeight()*(persent/100.0)),(int)(bg.getWidth()*(persentMenu/100.0)),(int)(bg.getHeight()*(persentMenu/100.0)));
        sb.draw(skill2,300,300,(int)(but.getHeight()*(persent/100.0)),(int)(but.getHeight()*(persent/100.0)));
    }

    @Override
    public void dispose() {

    }
}
