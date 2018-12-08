package ru.geekbrains.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.geekbrains.base.MainGeneralButton;
import ru.geekbrains.math.Rect;

public class ExitButton extends MainGeneralButton {


    public ExitButton(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"));
        setHeightProportion(0.20f);
    }

    @Override
    public void actionButton() {
        Gdx.app.exit();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setBottom(worldBounds.getBottom());
        setLeft(worldBounds.getLeft());
    }
}
