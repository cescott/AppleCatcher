package com.andersonescott;

import com.andersonescott.gameworld.GameScreen;

import com.badlogic.gdx.Game;


public class AppleCatcher extends Game{

	@Override
	public void create () {
		setScreen(new GameScreen());
	}
}
