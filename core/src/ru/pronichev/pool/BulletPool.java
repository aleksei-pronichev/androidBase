package ru.pronichev.pool;

import ru.pronichev.base.SpritesPool;
import ru.pronichev.sprite.Bullet;


public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
