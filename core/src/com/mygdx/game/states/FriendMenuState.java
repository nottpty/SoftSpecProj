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
public class FriendMenuState extends MenuState{
    private Sprite bg;
    private Texture tbg;
    private Rectangle rFriend1,rFriend2,rFriend3,rFriend4,rFriend5,rFriend6;
    private Texture friend1,friend2,friend3,friend4,friend5,friend6;

    int skillSize, bgWid, bgHeight, bgY, scale, space;
    private int persentMenu;
    public FriendMenuState(MenuStateManager msm,Player player){
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
        friend1 = new Texture("friend1icon.png");
        friend2 = new Texture("friend2icon.png");
        friend3 = new Texture("friend3icon.png");
        friend4 = new Texture("friend4icon.png");
        friend5 = new Texture("friend5icon.png");
        friend6 = new Texture("friend6icon.png");


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
        sb.draw(friend1, space, (int) (bgY + (2 * scale) + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);
        sb.draw(friend2, space, (int) (bgY + scale + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);
        sb.draw(friend3, space, (int) (bgY + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);

        sb.draw(friend4, TabTitan.WIDTH / 2 + space, (int) (bgY + (2 * scale) + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);
        sb.draw(friend5, TabTitan.WIDTH / 2 + space, (int) (bgY + scale + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);
        sb.draw(friend6, TabTitan.WIDTH / 2 + space, (int) (bgY + 68 * (persentMenu / 100.0) - (skillSize / 2)), skillSize, skillSize);

    }

    @Override
    public void dispose() {

    }
}
