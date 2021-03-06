package com.andersonescott.gameworld;


import com.andersonescott.InputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;


public class GameScreen implements Screen {

    protected GameWorld world;
    protected GameRenderer renderer;

    public GameScreen(){
        world = new GameWorld();
        renderer = new GameRenderer(world);
        Gdx.input.setInputProcessor(new InputHandler(world));
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        // Leave blank
    }

}
