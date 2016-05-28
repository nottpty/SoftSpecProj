package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.TabTitan;

/**
 * Created by mind on 28/05/2016.
 */
public class SkillMenuState extends MenuState {
    private Texture tbg;
    private Sprite bg;
    private Rectangle rSkill1, rSkill2, rSkill3, rSkill4, rSkill5, rSkill6;
    private Texture skill1, skill2, skill3, skill4, skill5, skill6;

    int skillSize, bgWid, bgHeight, bgY, scale, space;
    private int persentMenu;

    public SkillMenuState(MenuStateManager msm) {
        super(msm);
        Texture but = new Texture("buttonFriend.png");
        int persent = (int) (((TabTitan.WIDTH * 0.5) * 100) / but.getWidth());
        tbg = new Texture("menuBG.png");
        bg = new Sprite(tbg);
        persentMenu = (int) ((TabTitan.WIDTH * 100.0) / tbg.getWidth());
        bgY = (int) (but.getHeight() * (persent / 100.0));

        bg.setSize((int) (bg.getWidth() * (persentMenu / 100.0)), (int) (bg.getHeight() * (persentMenu / 100.0)));
        bg.setX(0);
        bg.setY(bgY);


        skillSize = (int) (but.getHeight() * (persent / 100.0));
        skill1 = new Texture("skill1.png");
        skill2 = new Texture("skill2.png");
        skill3 = new Texture("skill3.png");
        skill4 = new Texture("skill4.png");
        skill5 = new Texture("skill5.png");
        skill6 = new Texture("skill6.png");

        scale = (int) (136 * (persentMenu / 100.0));
        space = ((int) (136 * (persentMenu / 100.0)) - skillSize) / 2;

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

        bg.draw(sb);
        sb.draw(skill1, space, (int) (bgY + (2 * scale) + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);
        sb.draw(skill2, space, (int) (bgY + scale + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);
        sb.draw(skill3, space, (int) (bgY + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);

        sb.draw(skill4, TabTitan.WIDTH / 2 + space, (int) (bgY + (2 * scale) + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);
        sb.draw(skill5, TabTitan.WIDTH / 2 + space, (int) (bgY + scale + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);
        sb.draw(skill6, TabTitan.WIDTH / 2 + space, (int) (bgY + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);

    }

    @Override
    public void dispose() {

    }
}