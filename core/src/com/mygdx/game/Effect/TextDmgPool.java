package com.mygdx.game.Effect;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.sprites.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tannatanon on 5/28/2016 AD.
 */
public class TextDmgPool extends AbstractText{

    List<TextDmg> textDmgList = new ArrayList<TextDmg>();
    Player player;

    public TextDmgPool(Player player){
        this.player = player;
    }

    public void addTextDmg(TextDmg textDmg){
        textDmgList.add(textDmg);
    }

    public TextDmg showTextDmg(){
        for(TextDmg textDmg : textDmgList){
            if(!textDmg.isActive()) {
                textDmg.Activate();
                return textDmg;
            }
        }
        TextDmg newText = new TextDmg(player.getDmg()+"");
        newText.Activate();
        addTextDmg(newText);
        return newText;
    }

    public void update(float dt){
        for(TextDmg textDmg : textDmgList){
            textDmg.setText(player.getDmg()+"");
            textDmg.update(dt);
        }
    }

    public void draw(BitmapFont font, SpriteBatch batch){
        for(TextDmg textDmg : textDmgList){
            textDmg.draw(font, batch);
        }
    }
}
