package ru.pronichev.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.pronichev.base.ScaledButton;
import ru.pronichev.math.Rect;
import ru.pronichev.screen.GameScreen;

import static ru.pronichev.screen.MenuScreen.getMusicMenu;


public class ButtonNewGame extends ScaledButton {

    private Game game;


    public ButtonNewGame(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("btPlay"));
        setHeightProportion(0.15f);
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setBottom(worldBounds.getBottom() + 0.01f);
        setLeft(worldBounds.getLeft() + 0.01f);
    }

    @Override
    protected void actionPerformed() {
        getMusicMenu().stop();
        game.setScreen(new GameScreen(game));
    }
}
