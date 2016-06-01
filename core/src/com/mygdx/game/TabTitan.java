package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.PlayState;

public class TabTitan extends ApplicationAdapter {

    public static int WIDTH,HEIGHT;
	private GameStateManager gsm;
	private SpriteBatch batch;
	Music music;
	Texture img;

	
	@Override
	public void create () {
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal("bgSound.mp3"));
		music.setLooping(true);
		music.setVolume(1f);
		music.play();
		Gdx.gl.glClearColor(255/255.0f,206/255.0f,206/255.0f,1);
		gsm.push(new PlayState(gsm));

        System.out.println("Test : "+WIDTH+" "+HEIGHT);
    }

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
}
