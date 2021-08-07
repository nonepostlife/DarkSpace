package ru.postlife.gdx;

import com.badlogic.gdx.Game;

import ru.postlife.gdx.screen.MenuScreen;

public class DarkSpace extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
