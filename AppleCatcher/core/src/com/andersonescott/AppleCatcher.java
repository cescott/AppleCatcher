package com.andersonescott;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class AppleCatcher extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Player player;
	ArrayList<Apple> apples;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("applecatcher_bg.jpg");
		player = new Player(new double[] {0,0}, new double[2],0);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
