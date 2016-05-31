package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Effect.TextDmgPool;
import com.mygdx.game.TabTitan;
import com.mygdx.game.TimerTask.DpsTimer;
import com.mygdx.game.sprites.Button;
import com.mygdx.game.sprites.FriendBut;
import com.mygdx.game.sprites.HealthBar;
import com.mygdx.game.sprites.MonsterFactory;
import com.mygdx.game.sprites.MonsterRenderer;
import com.mygdx.game.sprites.Player;
import com.mygdx.game.sprites.SwordBut;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import sun.rmi.runtime.Log;

/**
 * Created by mind on 21/05/2016.
 */
public class PlayState extends State{
    private Texture bg,coin;
    private HealthBar hp;
    private Button swordBut,friendBut;
    private int stage;
    private BitmapFont bitmapFont,coinText;
    private MonsterFactory mons;
    private MonsterRenderer monsRenderer;
    private static Player player;
    private TextDmgPool textDmgPool;
    private List<DpsTimer> dpsTimerList;

    private MenuState skill,friend,list;
    private MenuStateManager msm;
    private Rectangle boundSkill,boundFriend,boundList;
    private boolean menuShow;
    Sprite m;
    public PlayState(GameStateManager gsm) {

        super(gsm);
        menuShow = false;
        player = new Player(10);
        msm = new MenuStateManager();
        skill = new SkillMenuState(msm,player);
        friend = new FriendMenuState(msm,player);
        list = new ListSkillMenuState(msm,player);
        msm.push(list);
        coin = new Texture("coin.png");
        bg = new Texture("bg.png");
        swordBut = new SwordBut();
        friendBut = new FriendBut();
        stage = 1;
        bitmapFont = new BitmapFont();
        bitmapFont.getData().setScale(5.0f,5.0f);

        coinText = new BitmapFont();
        coinText.getData().setScale(4.0f,4.0f);

        textDmgPool = new TextDmgPool(player);
        dpsTimerList = new ArrayList<DpsTimer>();

        mons = new MonsterFactory();
        Texture a = new Texture("hpBG.png");
        Texture b = new Texture("hpFG.png");

        hp = new HealthBar(a,b,mons.getMonster(stage % 10).getHP());
        monsRenderer = new MonsterRenderer(stage%10);

        boundSkill = new Rectangle(0,0,TabTitan.WIDTH/2,swordBut.getHeight());
        boundFriend = new Rectangle(TabTitan.WIDTH/2,0,TabTitan.WIDTH/2,swordBut.getHeight());
        boundList = new Rectangle((int)(TabTitan.WIDTH*0.82),(int)(TabTitan.HEIGHT*0.38),(int)(TabTitan.WIDTH*0.18),(int)(TabTitan.WIDTH*0.07));

        initFriendTask();

    }

    @Override
    public void handleInput() {
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        if(Gdx.input.justTouched()) {
            if(menuShow){
                if(boundList.contains(touchPos.x,TabTitan.HEIGHT-touchPos.y)){
                    msm.set(list);
                    menuShow = false;
                }
            }
            if(boundSkill.contains(touchPos.x,TabTitan.HEIGHT-touchPos.y)){
                msm.set(skill);
                menuShow = true;
            }else if(boundFriend.contains(touchPos.x,TabTitan.HEIGHT-touchPos.y)){
                msm.set(friend);
                menuShow = true;
            }else{
                hp.minusHP(player.getDmg());
                textDmgPool.showTextDmg();
                System.out.println("kill : "+player.getSkillList().get(5).getName());
            }
        }
        if(hp.getHP()<=0){
            player.addMoney(mons.getMonster(stage%10).getBounty());
            stage++;
            int numMon = stage%10;
            if(stage % 10 == 1)
                mons.rescale(stage / 10 + 1);
            System.out.println(player.getMoney());
            hp.setHP(mons.getMonster(numMon).getHP());
            monsRenderer.setNumMon(numMon);
        }
    }

    public int getDmg(int index){
        return player.getFriendFactory().getFriend(index).getDamage();
    }

    public void initFriendTask(){
        for(int i = 0;i < 6;i++){
            dpsTimerList.add(new DpsTimer(getDmg(i),hp));
            handleTask(dpsTimerList.get(i));
        }
    }

    public void handleTask(DpsTimer dpsTimer){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(dpsTimer,0,1000);
    }

    public void updateDps(){
        for(int i = 0;i < 6;i++){
            DpsTimer dpsTimer = dpsTimerList.get(i);
            dpsTimer.setDps(getDmg(i));
        }
    }

    @Override
    public void update(float dt) {
        textDmgPool.update(dt);
        handleInput();
        msm.update(dt);
        updateDps();
    }

    @Override
    public void render(SpriteBatch sb) {
        int barWidth = (int)(TabTitan.WIDTH*0.9);
        int barHeight = (int)(TabTitan.WIDTH*0.1);
        sb.begin();

        sb.draw(bg, 0, 0, TabTitan.WIDTH, TabTitan.HEIGHT);
        sb.draw(swordBut.getTexture(), 0, 0,
                swordBut.getWidth(), swordBut.getHeight());
        sb.draw(friendBut.getTexture(), (int) (TabTitan.WIDTH * 0.5), 0,
                friendBut.getWidth(), friendBut.getHeight());

        monsRenderer.render(sb);
        hp.render(sb);
        textDmgPool.draw(bitmapFont, sb);
        msm.render(sb);
        int size = (int)(TabTitan.WIDTH*0.05);
        sb.draw(coin,hp.getX(),hp.getY()-size-(int)(size*0.2),size,size);
        coinText.draw(sb, this.player.getMoney() + "", hp.getX() + size + (int) (size * 0.2), hp.getY() - (int) (size * (1/4.0)));
        sb.end();

    }

    @Override
    public void dispose() {

    }
}

