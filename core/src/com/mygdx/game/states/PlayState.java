package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.TabTitan;
import com.mygdx.game.sprites.Button;
import com.mygdx.game.sprites.FriendBut;
import com.mygdx.game.sprites.HealthBar;
import com.mygdx.game.sprites.MonsterFactory;
import com.mygdx.game.sprites.MonsterRenderer;
import com.mygdx.game.sprites.SwordBut;

/**
 * Created by mind on 21/05/2016.
 */
public class PlayState extends State{
    private Texture bg;
//    private HealthBar hp;
    private Button swordBut,friendBut;
    private int stage;
    private MonsterFactory mons;
    private MonsterRenderer monsRenderer;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        bg = new Texture("bg.png");
        swordBut = new SwordBut();
        friendBut = new FriendBut();
        stage = 1;

        mons = new MonsterFactory();
//        Texture a = new Texture("hpBG.png");
//        Texture b = new Texture("hpFG.png");
//        hp = new HealthBar(a,b);
        monsRenderer = new MonsterRenderer(stage);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            HealthBar.getInstance().minusHP(10);
            //ถ้ามอนตาย ++ state เรนเดอร์มอนใหม่
        }
    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(Batch sb) {
        int barWidth = (int)(TabTitan.WIDTH*0.9);
        int barHeight = (int)(TabTitan.WIDTH*0.1);
        int numMon = (stage%10) - 1;
        sb.begin();

        sb.draw(bg,0,0, TabTitan.WIDTH,TabTitan.HEIGHT);
//        sb.draw(mons.createMonster(numMon).getTexture(),
//                (int)((TabTitan.WIDTH/2)-(mons.createMonster(0).getWidth()/2)),
//                (int)(TabTitan.HEIGHT-(TabTitan.HEIGHT*0.6)),
//                mons.createMonster(numMon).getWidth(),mons.createMonster(0).getHeight());
        sb.draw(swordBut.getTexture(),0,0,
                swordBut.getWidth(),swordBut.getHeight());
        sb.draw(friendBut.getTexture(),(int)(TabTitan.WIDTH*0.5),0,
                friendBut.getWidth(),friendBut.getHeight());

        sb.end();
        monsRenderer.render(sb);
    }

    @Override
    public void dispose() {

    }
}

