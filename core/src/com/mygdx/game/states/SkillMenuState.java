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
    private Texture tbg,buyBut,buyButN,upBut,upButN;
    private Sprite bg;
    private List<Rectangle>buyBounds;
    private List<Sprite> skillList;
    private Sprite profile,upPlayerBut,upPlayerButN;
    int skillSize, bgWid, bgHeight, bgY, scale, space,persentMenu;
    private BitmapFont bitmapFont;
    private static Player player;
    private Rectangle upPlayerBound;
    public SkillMenuState(MenuStateManager msm,Player player) {
        super(msm);
        skillList = new ArrayList<Sprite>();
        this.player = player;
        buyBounds = new ArrayList<Rectangle>();
        buyBut = new Texture("buyBut.png");
        buyButN = new Texture("buyButN.png");
        upBut = new Texture("levelUpBut.png");
        upButN = new Texture("levelUpButN.png");

        Texture but = new Texture("buttonFriend.png");
        int persent = (int) (((TabTitan.WIDTH * 0.5) * 100) / but.getWidth());

        bitmapFont = new BitmapFont();
        bitmapFont.getData().setScale(3.5f,3.5f);

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
        profile = new Sprite(new Texture("player.png"));
        profile.setSize((TabTitan.WIDTH/2)-(2*space),(TabTitan.WIDTH/2)-(2*space));
        profile.setY(bgY+space);
        profile.setX((TabTitan.WIDTH/2)+space);

        upPlayerBut = new Sprite(new Texture("upPlayerBut.png"));
        upPlayerBut.setSize((TabTitan.WIDTH/2)-(space),skillSize+space);
        upPlayerBut.setY((int) (bgY-space + (2* scale) +(scale/2) - (skillSize / 2)));
        upPlayerBut.setX(space);

        upPlayerButN = new Sprite(new Texture("upPlayerButN.png"));
        upPlayerButN.setSize((TabTitan.WIDTH/2)-(space),skillSize+space);
        upPlayerButN.setY((int) (bgY-space + (2* scale) +(scale/2) - (skillSize / 2)));
        upPlayerButN.setX(space);

        upPlayerBound = new Rectangle(upPlayerBut.getX(),upPlayerBut.getY(),upPlayerBut.getWidth(),upPlayerBut.getHeight());

        for(int i = 0;i<2;i++){
            skillList.add(new Sprite(new Texture("skill"+(i+1)+".png")));
            skillList.get(i).setSize(skillSize,skillSize);
        }

        for(int i = 0;i<2;i++){
            skillList.get(i).setX(space);
            skillList.get(i).setY((int) (bgY + ((2-(i+1)) * scale) +(scale/2) - (skillSize / 2)));
            buyBounds.add(new Rectangle((TabTitan.WIDTH/2)-skillSize,skillList.get(i).getY(),skillSize,skillSize));
        }
    }
    public void buySkill(int index){
        int playerMoney = player.getMoney();
        int price = player.getSkillList().get(index).getPrice();
        if(playerMoney>=price){
            player.minusMoney(price);
            player.getSkillList().get(index).buySkill();
        }

    }
    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            if(upPlayerBound.contains(touchPos.x, TabTitan.HEIGHT - touchPos.y)){
                player.upDmg();
            }else if (buyBounds.get(0).contains(touchPos.x, TabTitan.HEIGHT - touchPos.y)) {
                buySkill(0);
            } else if (buyBounds.get(1).contains(touchPos.x, TabTitan.HEIGHT - touchPos.y)) {
                buySkill(1);
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        bg.draw(sb);
        profile.draw(sb);
        if(player.getMoney()>=player.getPrice()){
            upPlayerBut.draw(sb);
        }else{
            upPlayerButN.draw(sb);
        }

        bitmapFont.draw(sb, "Level : "+player.getLevel()+"\nPrice : "+player.getPrice(),
                space + skillSize + space,
                upPlayerBut.getY()+skillSize);
        for(int i = 0;i<2;i++) {
            skillList.get(i).draw(sb);
            if (player.getSkillList().get(i).check()) {
                if (player.getMoney() >= player.getSkillList().get(i).getPrice()) {
                    sb.draw(upBut, (TabTitan.WIDTH / 2) - skillSize, skillList.get(i).getY(), skillSize, skillSize);
                } else {
                    sb.draw(upButN, (TabTitan.WIDTH / 2) - skillSize, skillList.get(i).getY(), skillSize, skillSize);
                }

            } else {
                if (player.getMoney() >= player.getSkillList().get(i).getPrice()) {
                    sb.draw(buyBut, (TabTitan.WIDTH / 2) - skillSize, skillList.get(i).getY(), skillSize, skillSize);
                } else {
                    sb.draw(buyButN, (TabTitan.WIDTH / 2) - skillSize, skillList.get(i).getY(), skillSize, skillSize);
                }

            }
            bitmapFont.draw(sb, player.getSkillList().get(i).getText(),
                    space + skillSize + space,
                    skillList.get(i).getY() + skillSize);
        }

    }

    @Override
    public void dispose() {

    }
}