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
            if(i == 0) hpScale = 10;
            Monsters monster = new Monsters(i,50*hpScale);
            monstersList.add(monster);
        }
    }

    public void rescaleHp(int scale){
        for(Monsters monster : monstersList){
            monster.setHP(monster.getHP()+(20*scale));
        }
    }

    public Monsters createMonster(int index){
        return monstersList.get(index);
    }
}
