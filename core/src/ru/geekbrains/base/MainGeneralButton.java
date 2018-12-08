package ru.geekbrains.base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class MainGeneralButton extends Sprite{

    private static final float PUSH_BUTTON = 0.5f;

    private boolean pressed;

    public MainGeneralButton(TextureRegion region) {
        super(region);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        if (!isMe(touch) ) return false;
        pressed = true;
        scale = PUSH_BUTTON;
        return false;
    }

    public boolean touchUp(Vector2 touch, int pointer) {
        if (!pressed) return false;
        pressed = false;
        scale = 1f;
        actionButton();
        return false;
    }

    public abstract void actionButton();
}
