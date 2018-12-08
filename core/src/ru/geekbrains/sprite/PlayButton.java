package ru.geekbrains.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.MainGeneralButton;
import ru.geekbrains.math.Rect;

public class PlayButton extends MainGeneralButton {


    public PlayButton(TextureAtlas atlas) {
        super(atlas.findRegion("btPlay"));
        setHeightProportion(0.20f);
    }

    @Override
    public void actionButton() {
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setBottom(worldBounds.getBottom());
        setRight(worldBounds.getRight());
    }
}
