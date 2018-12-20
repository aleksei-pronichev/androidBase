package ru.pronichev;

import com.badlogic.gdx.Game;

import ru.pronichev.screen.MenuScreen;


public class Star2DGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
