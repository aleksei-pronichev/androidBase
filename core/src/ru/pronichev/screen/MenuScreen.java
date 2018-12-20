package ru.pronichev.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;


import ru.pronichev.base.Base2DScreen;
import ru.pronichev.math.Rect;
import ru.pronichev.sprite.Background;
import ru.pronichev.sprite.ButtonExit;
import ru.pronichev.sprite.ButtonNewGame;
import ru.pronichev.sprite.Star;

public class MenuScreen extends Base2DScreen{

    private static final int STAR_COUNT = 256;
    private static Music musicMenu = Gdx.audio.newMusic(Gdx.files.internal("sounds/menu.mp3"));

    private Texture bg;
    private TextureAtlas textureAtlas;

    private Background background;


    private Star[] star;

    private ButtonExit buttonExit;
    private ButtonNewGame buttonNewGame;

    public MenuScreen(Game game) {
        super(game);
    }


    @Override
    public void show() {
        super.show();
        musicMenu.setLooping(true);
        musicMenu.play();
        textureAtlas = new TextureAtlas("textures/menuAtlas.tpack");
        bg = new Texture("textures/cat.jpg");
        background = new Background(new TextureRegion(bg));
        star = new Star[STAR_COUNT];
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(textureAtlas);
        }
        buttonExit = new ButtonExit(textureAtlas);
        buttonNewGame = new ButtonNewGame(textureAtlas, game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    public void update(float delta) {
        for (int i = 0; i < star.length; i++) {
            star[i].update(delta);
        }
    }

    public void draw() {
        Gdx.gl.glClearColor(1, 0.3f, 0.6f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        background.draw(batch);
        for (int i = 0; i < star.length; i++) {
            star[i].draw(batch);
        }
        buttonExit.draw(batch);
        buttonNewGame.draw(batch);
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (int i = 0; i < star.length; i++) {
            star[i].resize(worldBounds);
        }
        buttonExit.resize(worldBounds);
        buttonNewGame.resize(worldBounds);
    }

    @Override
    public void dispose() {
        textureAtlas.dispose();
        bg.dispose();
        super.dispose();
    }

    public static Music getMusicMenu() {
        return musicMenu;
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        musicMenu.stop();
        buttonExit.touchDown(touch, pointer);
        buttonNewGame.touchDown(touch, pointer);
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        buttonExit.touchUp(touch, pointer);
        buttonNewGame.touchUp(touch, pointer);
        return super.touchUp(touch, pointer);
    }

}
