package ru.geekbrains.pool;


import com.badlogic.gdx.audio.Sound;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Enemy;
import ru.geekbrains.sprite.MainShip;

public class EnemyPool extends SpritesPool<Enemy> {

    private BulletPool bulletPool;
    private MainShip mainShip;
    private Rect worldBounds;
    private Sound shootSound;

    public EnemyPool(BulletPool bulletPool, MainShip mainShip, Rect worldBounds, Sound shootSound) {
        this.bulletPool = bulletPool;
        this.mainShip = mainShip;
        this.worldBounds = worldBounds;
        this.shootSound = shootSound;

    }

    @Override
    protected Enemy newObject() {
        return new Enemy(bulletPool, mainShip, worldBounds, shootSound);
    }
}
