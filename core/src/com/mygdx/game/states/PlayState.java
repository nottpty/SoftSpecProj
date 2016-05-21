package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.TabTitan;
import com.mygdx.game.sprites.HealthBar;
import com.mygdx.game.sprites.Monsters;

/**
 * Created by mind on 21/05/2016.
 */
public class PlayState extends State{
    private Texture bg;
    private Monsters mon;
    private HealthBar hp;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        bg = new Texture("bg.png");
        mon = new Monsters();
        hp = new HealthBar();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg,0,0, TabTitan.WIDTH,TabTitan.HEIGHT);
        sb.draw(mon.getTexture(),
                (int)((TabTitan.WIDTH/2)-(mon.getWidth()/2)),
                (int)(TabTitan.HEIGHT-(TabTitan.HEIGHT*0.6)),
                mon.getWidth(),mon.getHeight());

        sb.end();
    }

    @Override
    public void dispose() {

    }
}

