package com.andersonescott.gameworld;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class GameRenderer {

    protected GameWorld world;

    protected OrthographicCamera cam;

    protected SpriteBatch batch;

    protected Texture background;
    protected Texture apple;

    public GameRenderer(GameWorld tempWorld){
        world = tempWorld;
        batch = new SpriteBatch();
        background = new Texture("applecatcher_bg.jpg");
        apple = new Texture("applecatcher_apple.png");
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 800, 600);
    }

    public void render(){
        //draw a black background
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //start drawing textures
        batch.begin();
        //draw background
        batch.draw(background, 0, 0);
        //draw apple
        batch.draw(apple, 50, 50);
        batch.end();
    }
}
