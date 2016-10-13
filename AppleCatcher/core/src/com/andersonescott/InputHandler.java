package com.andersonescott;

import com.andersonescott.gameworld.GameWorld;
import com.andersonescott.objects.Player;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor{

    protected GameWorld world;
    protected Player player;

    public InputHandler(GameWorld tempWorld){
        world = tempWorld;
        player = world.getPlayer();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        player.input("pressed", keycode);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        player.input("released", keycode);
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
