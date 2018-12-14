package ru.geekbrains.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;
import ru.geekbrains.pool.EnemyPool;
import ru.geekbrains.sprite.Enemy;

public class EnemiesEmitter {

    private static final float ENEMY_SMALL_HEIGHT = 0.1f;
    private static final float ENEMY_SMALL_BULLET_HEIGHT = 0.01f;
    private static final float ENEMY_SMALL_BULLET_VY = -0.3f;
    private static final int ENEMY_SMALL_BULLET_DAMAGE = 1;
    private static final float ENEMY_SMALL_RELOAD_INTERVAL = 3f;
    private static final int ENEMY_SMALL_HP = 1;

    private static final float ENEMY_MIDDLE_HEIGHT = 0.1f;
    private static final float ENEMY_MIDDLE_BULLET_HEIGHT = 0.01f;
    private static final float ENEMY_MIDDLE_BULLET_VY = -0.5f;
    private static final int ENEMY_MIDDLE_BULLET_DAMAGE = 1;
    private static final float ENEMY_MIDDLE_RELOAD_INTERVAL = 3f;
    private static final int ENEMY_MIDDLE_HP = 1;

    private static final float ENEMY_HIGHT_HEIGHT = 0.2f;
    private static final float ENEMY_HIGHT_BULLET_HEIGHT = 0.03f;
    private static final float ENEMY_HIGHT_BULLET_VY = -0.2f;
    private static final int ENEMY_HIGHT_BULLET_DAMAGE = 3;
    private static final float ENEMY_HIGHT_RELOAD_INTERVAL = 3f;
    private static final int ENEMY_HIGHT_HP = 1;

    private Rect worldBounds;

    private float generateInterval = 4f;
    private float generateTimer;
    Random random;
    int i;

    private TextureRegion[] enemySmallRegion;
    private TextureRegion[] enemyMiddleRegion;
    private TextureRegion[] enemyHightRegion;


    private final Vector2 enemySmallV = new Vector2(0f, -0.2f);
    private final Vector2 enemyMiddleV = new Vector2(0f, -0.3f);
    private final Vector2 enemyHightV = new Vector2(0f, -0.1f);

    private TextureRegion bulletRegion;

    private EnemyPool enemyPool;

    public EnemiesEmitter(Rect worldBounds, EnemyPool enemyPool, TextureAtlas atlas) {
        this.worldBounds = worldBounds;
        this.enemyPool = enemyPool;
        TextureRegion textureRegion0 = atlas.findRegion("enemy0");
        TextureRegion textureRegion1 = atlas.findRegion("enemy1");
        TextureRegion textureRegion2 = atlas.findRegion("enemy2");
        this.enemySmallRegion = Regions.split(textureRegion0, 1, 2, 2);
        this.enemyMiddleRegion = Regions.split(textureRegion1, 1, 2, 2);
        this.enemyHightRegion = Regions.split(textureRegion2, 1, 2, 2);

        this.bulletRegion = atlas.findRegion("bulletEnemy");
        random = new Random();
    }

    public void generate(float delta) {
        generateTimer += delta;
        i = random.nextInt(3);
        if (generateTimer >= generateInterval) {
            generateTimer = 0f;
            Enemy enemy = enemyPool.obtain();
            switch (i) {
                case 0:
                    enemy.set(
                            enemySmallRegion,
                            enemySmallV,
                            bulletRegion,
                            ENEMY_SMALL_BULLET_HEIGHT,
                            ENEMY_SMALL_BULLET_VY,
                            ENEMY_SMALL_BULLET_DAMAGE,
                            ENEMY_SMALL_RELOAD_INTERVAL,
                            ENEMY_SMALL_HEIGHT,
                            ENEMY_SMALL_HP
                    );
                    break;
                case 1:
                    enemy.set(
                            enemyMiddleRegion,
                            enemyMiddleV,
                            bulletRegion,
                            ENEMY_MIDDLE_BULLET_HEIGHT,
                            ENEMY_MIDDLE_BULLET_VY,
                            ENEMY_MIDDLE_BULLET_DAMAGE,
                            ENEMY_MIDDLE_RELOAD_INTERVAL,
                            ENEMY_MIDDLE_HEIGHT,
                            ENEMY_MIDDLE_HP
                    );
                    break;
                case 2:
                    enemy.set(
                            enemyHightRegion,
                            enemyHightV,
                            bulletRegion,
                            ENEMY_HIGHT_BULLET_HEIGHT,
                            ENEMY_HIGHT_BULLET_VY,
                            ENEMY_HIGHT_BULLET_DAMAGE,
                            ENEMY_HIGHT_RELOAD_INTERVAL,
                            ENEMY_HIGHT_HEIGHT,
                            ENEMY_HIGHT_HP
                    );
                    break;
            }
            enemy.pos.x = Rnd.nextFloat(worldBounds.getLeft() + enemy.getHalfWidth(), worldBounds.getRight() - enemy.getHalfWidth());
            enemy.setBottom(worldBounds.getTop());
        }
    }
}
