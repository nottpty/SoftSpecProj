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
public class ListSkillMenuState extends MenuState {
    private int space,butSize;
    private List<Sprite> skillList,skillNList;
    private List<Rectangle>bounds;
    private static Player player;
    private Sprite profile;
    private BitmapFont bitmapFont;
    public ListSkillMenuState(MenuStateManager msm,Player player){
        super(msm);
        skillList = new ArrayList<Sprite>();
        skillNList = new ArrayList<Sprite>();
        bounds = new ArrayList<Rectangle>();
        profile = new Sprite(new Texture("player.png"));
        Texture but = new Texture("buttonFriend.png");
        int persent = (int) (((TabTitan.WIDTH * 0.5) * 100) / but.getWidth());
        int y = (int) (but.getHeight() * (persent / 100.0));

        bitmapFont = new BitmapFont();
        bitmapFont.getData().setScale(3.5f,3.5f);

        space = (int)(TabTitan.WIDTH*0.05);
        butSize = (int)(int)(TabTitan.WIDTH*0.11);
        this.player = player;

        skillList.add(new Sprite(new Texture("skill1.png")));
        skillList.add(new Sprite(new Texture("skill2.png")));
        skillNList.add(new Sprite(new Texture("skill1N.png")));
        skillNList.add(new Sprite(new Texture("skill2N.png")));


        for(int i = 0;i<2;i++){
            skillList.get(i).setSize(butSize,butSize);
            skillList.get(i).setY(y+space);
            skillList.get(i).setX((int)(space+(space+butSize)*i));
            skillNList.get(i).setSize(butSize,butSize);
            skillNList.get(i).setY(y+space);
            skillNList.get(i).setX((int)(space+(space+butSize)*i));
            bounds.add(new Rectangle(skillList.get(i).getX(),skillList.get(i).getY(),butSize,butSize));
        }
        profile.setSize((int)(TabTitan.WIDTH*0.25),(int)(TabTitan.WIDTH*0.25));
        profile.setX(TabTitan.WIDTH-profile.getWidth()-space);
        profile.setY(y+space);

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            if (bounds.get(0).contains(touchPos.x, TabTitan.HEIGHT - touchPos.y) && checkStatus(player,0)) {
                player.getSkillList().get(0).doAction(player);
            } else if (bounds.get(1).contains(touchPos.x, TabTitan.HEIGHT - touchPos.y) && checkStatus(player,1)) {
                player.getSkillList().get(1).doAction(player);
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        updateSkillSet(dt);
    }


    public void updateSkillSet(float dt){
        if(!player.getSkillList().get(0).canUse())
            player.updateSkill(0,dt);
        if(!player.getSkillList().get(1).canUse())
            player.updateSkill(1,dt);
    }

    @Override
    public void render(SpriteBatch sb) {

        for(int i = 0;i<2;i++){
            if(player.getSkillList().get(i).check()){
                skillList.get(i).draw(sb);
            }else{
                skillNList.get(i).draw(sb);
            }
        }
        bitmapFont.draw(sb, "Level : "+player.getLevel()+"\nDamage : "+player.getDmg(),
                profile.getX(),
                profile.getY()+profile.getHeight()+space*2);
        profile.draw(sb);

    }

    @Override
    public void dispose() {

    }

    public boolean checkStatus(Player player,int index){
        return player.getSkillList().get(index).check();
    }
}
