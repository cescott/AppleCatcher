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

    public GameRenderer(GameWorld tempWorld){
        world = tempWorld;
        batch = new SpriteBatch();
        background = new Texture("applecatcher_bg.jpg");
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
        //draw apples
        for (int i=0; i<world.getApples().size();i++){
            batch.draw(world.getApples().get(i).getImage(), (int)world.getApples().get(i).x(), (int)world.getApples().get(i).y());
        }
        //draw player
        batch.draw(world.getPlayer().getImage(), (int)world.getPlayer().x(), (int)world.getPlayer().y());
        //draw scoreboard
        world.getScoreboard().draw(batch);
        batch.end();
    }
}
