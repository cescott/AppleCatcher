package com.andersonescott.gameworld;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class GameRenderer {

    protected GameWorld world;
    protected SpriteBatch batch;
    protected Texture background;

    public GameRenderer(GameWorld tempWorld){
        world = tempWorld;
        batch = new SpriteBatch();
        background = new Texture("applecatcher_bg.jpg");
    }

    public void render(){
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();
    }
}
