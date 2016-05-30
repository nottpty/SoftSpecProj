package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.TabTitan;
import com.mygdx.game.sprites.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mind on 28/05/2016.
 */
public class SkillMenuState extends MenuState {
    private Texture tbg,buyBut;
    private Sprite bg;
    private List<Rectangle>buyBounds;
    private List<Sprite> skillList;
    int skillSize, bgWid, bgHeight, bgY, scale, space,persentMenu;
    private BitmapFont bitmapFont;
    private Player player;
    public SkillMenuState(MenuStateManager msm,Player player) {
        super(msm);
        skillList = new ArrayList<Sprite>();
        this.player = player;
        buyBounds = new ArrayList<Rectangle>();
        buyBut = new Texture("buyBut.png");

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

        for(int i = 0;i<6;i++){
            skillList.add(new Sprite(new Texture("skill"+(i+1)+".png")));
            skillList.get(i).setSize(skillSize,skillSize);
        }

        for(int i = 0;i<6;i++){
            if(i<=2){
                skillList.get(i).setX(space);
                skillList.get(i).setY((int) (bgY + ((2-i) * scale) +(scale/2) - (skillSize / 2)));
                buyBounds.add(new Rectangle((TabTitan.WIDTH/2)-skillSize,skillList.get(i).getY(),skillSize,skillSize));
            }else{
                skillList.get(i).setX(TabTitan.WIDTH / 2 + space);
                skillList.get(i).setY((int) (bgY + ((2-(i-3)) * scale) +(scale/2) - (skillSize / 2)));
                buyBounds.add(new Rectangle(TabTitan.WIDTH-skillSize-space,skillList.get(i).getY(),skillSize,skillSize));
            }
        }
    }

    @Override
    public void handleInput() {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        if(buyBounds.get(0).contains(touchPos.x,TabTitan.HEIGHT-touchPos.y)){

        }else if(buyBounds.get(1).contains(touchPos.x,TabTitan.HEIGHT-touchPos.y)){

        }else if(buyBounds.get(2).contains(touchPos.x,TabTitan.HEIGHT-touchPos.y)){

        }else if(buyBounds.get(3).contains(touchPos.x,TabTitan.HEIGHT-touchPos.y)){

        }else if(buyBounds.get(4).contains(touchPos.x,TabTitan.HEIGHT-touchPos.y)){

        }else if(buyBounds.get(5).contains(touchPos.x,TabTitan.HEIGHT-touchPos.y)){

        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        bg.draw(sb);
        for(int i = 0;i<6;i++){
            skillList.get(i).draw(sb);
            if(i<=2){
                sb.draw(buyBut,(TabTitan.WIDTH/2)-skillSize,skillList.get(i).getY(),skillSize,skillSize);
                bitmapFont.draw(sb,player.getSkillList().get(i).getText(),
                        space+skillSize+space,
                        skillList.get(i).getY()+skillSize);
            }else{
                sb.draw(buyBut,TabTitan.WIDTH-skillSize-space,skillList.get(i).getY(),skillSize,skillSize);
                bitmapFont.draw(sb,player.getSkillList().get(i).getText(),
                        (TabTitan.WIDTH/2)+space+skillSize+space,
                        skillList.get(i).getY()+skillSize);
            }
        }
    }

    @Override
    public void dispose() {

    }
}