package com.mygdx.game.sprites;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mind on 27/05/2016.
 */
public class MonsterFactory {

    List<Monsters> monstersList;

    public MonsterFactory(){
        monstersList = new ArrayList<Monsters>();
        createMonsterList();
    }

    public void createMonsterList(){
        for(int i = 0;i < 10;i++){
            int hpScale = i;
            int moneyScale = i;
            if(i == 0) {
                hpScale = 10;
                moneyScale = 10;
            }
            Monsters monster = new Monsters(i,25*hpScale,moneyScale*4);
            monstersList.add(monster);
        }
    }

    public void rescale(int scale){
        for(Monsters monster : monstersList){
            monster.setHP((int)(monster.getHP()+(300*scale*1.65)));
            monster.setBounty((int)(monster.getBounty()+(40*scale*1.25)));
        }
    }

    public Monsters getMonster(int index){
        return monstersList.get(index);
    }
}
