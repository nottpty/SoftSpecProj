package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.TabTitan;
import com.mygdx.game.TimerTask.DpsTimer;
import com.mygdx.game.sprites.Button;
import com.mygdx.game.sprites.FriendBut;
import com.mygdx.game.sprites.HealthBar;
import com.mygdx.game.sprites.MonsterFactory;
import com.mygdx.game.sprites.MonsterRenderer;
import com.mygdx.game.sprites.SwordBut;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mind on 21/05/2016.
 */
public class PlayState extends State{
    private Texture bg;
    private HealthBar hp;
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
        Texture a = new Texture("hpBG.png");
        Texture b = new Texture("hpFG.png");

        hp = new HealthBar(a,b,mons.createMonster(stage%10).getHP());
        monsRenderer = new MonsterRenderer(stage%10);
        handleTask(3);
        handleTask(5);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            hp.minusHP(10);
        }
        if(hp.getHP()<=0){
            stage++;
            if(stage % 10 == 1)
                mons.rescaleHp(stage / 10 + 1);
            hp.setHP(mons.createMonster(stage%10).getHP());
            monsRenderer.setNumMon(stage%10);
        }
    }

    public void handleTask(int dps){
        DpsTimer dpsTimer = new DpsTimer(dps,hp);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(dpsTimer,0,1000);
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(Batch sb) {
        int barWidth = (int)(TabTitan.WIDTH*0.9);
        int barHeight = (int)(TabTitan.WIDTH*0.1);
        sb.begin();

        sb.draw(bg,0,0, TabTitan.WIDTH,TabTitan.HEIGHT);
        sb.draw(swordBut.getTexture(),0,0,
                swordBut.getWidth(),swordBut.getHeight());
        sb.draw(friendBut.getTexture(),(int)(TabTitan.WIDTH*0.5),0,
                friendBut.getWidth(),friendBut.getHeight());

        sb.end();
        monsRenderer.render(sb);

        hp.render(sb);
    }

    @Override
    public void dispose() {

    }
}

