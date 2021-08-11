package ru.postlife.gdx.pool;

import ru.postlife.gdx.base.SpritesPool;
import ru.postlife.gdx.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newSprite() {
        return new Bullet();
    }
}
