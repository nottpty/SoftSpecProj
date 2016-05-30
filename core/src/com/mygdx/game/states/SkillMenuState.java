package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.TabTitan;
import com.mygdx.game.sprites.Player;

/**
 * Created by mind on 28/05/2016.
 */
public class SkillMenuState extends MenuState {
    private Texture tbg;
    private Sprite bg;
    private Rectangle rSkill1, rSkill2, rSkill3, rSkill4, rSkill5, rSkill6,exit;
    private Sprite skill1, skill2, skill3, skill4, skill5, skill6;

    int skillSize, bgWid, bgHeight, bgY, scale, space;
    private int persentMenu;
    private BitmapFont bitmapFont;

    public SkillMenuState(MenuStateManager msm,Player player) {
        super(msm);

        Texture but = new Texture("buttonFriend.png");
        int persent = (int) (((TabTitan.WIDTH * 0.5) * 100) / but.getWidth());

        bitmapFont = new BitmapFont();
        bitmapFont.getData().setScale(4.05f,4.0f);

        tbg = new Texture("menuBG.png");
        bg = new Sprite(tbg);
        persentMenu = (int) ((TabTitan.WIDTH * 100.0) / tbg.getWidth());
        bgY = (int) (but.getHeight() * (persent / 100.0));

        bg.setSize((int) (bg.getWidth() * (persentMenu / 100.0)), (int) (bg.getHeight() * (persentMenu / 100.0)));
        bg.setX(0);
        bg.setY(bgY);



        skillSize = (int) (but.getHeight() * (persent / 100.0));

        scale = (int) (136 * (persentMenu / 100.0));
        space = ((int) (136 * (persentMenu / 100.0)) - skillSize) / 2;

        skill1 = new Sprite(new Texture("skill1.png"));
        skill2 = new Sprite(new Texture("skill2.png"));
        skill3 = new Sprite(new Texture("skill3.png"));
        skill4 = new Sprite(new Texture("skill4.png"));
        skill5 = new Sprite(new Texture("skill5.png"));
        skill6 = new Sprite(new Texture("skill6.png"));

        skill1.setSize(skillSize,skillSize);
        skill2.setSize(skillSize,skillSize);
        skill3.setSize(skillSize,skillSize);
        skill4.setSize(skillSize,skillSize);
        skill5.setSize(skillSize,skillSize);
        skill6.setSize(skillSize,skillSize);

        skill1.setX(space);
        skill2.setX(space);
        skill3.setX(space);
        skill4.setX(TabTitan.WIDTH / 2 + space);
        skill5.setX(TabTitan.WIDTH / 2 + space);
        skill6.setX(TabTitan.WIDTH / 2 + space);

        skill1.setY((int) (bgY + (2 * scale) + 68 * (persentMenu / 100.0) - (skillSize / 2)));
        skill2.setY((int) (bgY + scale + 68 * (persentMenu / 100.0) - (skillSize / 2)));
        skill3.setY((int) (bgY + 68 * (persentMenu / 100.0) - (skillSize / 2)));
        skill4.setY((int) (bgY + (2 * scale) + 68 * (persentMenu / 100.0) - (skillSize / 2)));
        skill5.setY((int) (bgY + scale + 68 * (persentMenu / 100.0) - (skillSize / 2)));
        skill6.setY((int) (bgY + 68 * (persentMenu / 100.0) - (skillSize / 2)));

        int wid = (int)(TabTitan.WIDTH*(15.5/100));
        int hig = (int)(bg.getHeight()*(13.7/100));
        exit = new Rectangle(TabTitan.WIDTH-wid,bgY+(int)(bg.getHeight()*(86.3/100)),wid,hig);



//        rSkill1 = new Rectangle(space, (int) (bgY + (2 * scale) + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);
//        rSkill2 = new Rectangle(space, (int) (bgY + scale + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);
//        rSkill3 = new Rectangle(space, (int) (bgY + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);
//        rSkill4 = new Rectangle(TabTitan.WIDTH / 2 + space, (int) (bgY + (2 * scale) + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);
//        rSkill5 = new Rectangle(TabTitan.WIDTH / 2 + space, (int) (bgY + scale + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);
//        rSkill6 = new Rectangle(TabTitan.WIDTH / 2 + space, (int) (bgY + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);

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

        skill1.draw(sb);
        bitmapFont.draw(sb,"Double Damage",
                space+skillSize+space,
                skill1.getY()+skillSize);

        skill2.draw(sb);
        bitmapFont.draw(sb,"Critical",
                space+skillSize+space,
                skill2.getY()+skillSize);

        skill3.draw(sb);
        bitmapFont.draw(sb,"Stone",
                space+skillSize+space,
                skill3.getY()+skillSize);

        skill4.draw(sb);
        bitmapFont.draw(sb,"Poison",
                (TabTitan.WIDTH/2)+space+skillSize+space,
                skill4.getY()+skillSize);

        skill5.draw(sb);
        bitmapFont.draw(sb,"Frost",
                (TabTitan.WIDTH/2)+space+skillSize+space,
                skill5.getY()+skillSize);

        skill6.draw(sb);
        bitmapFont.draw(sb,"Kill",
                (TabTitan.WIDTH/2)+space+skillSize+space,
                skill6.getY()+skillSize);



    }

    @Override
    public void dispose() {

    }
}