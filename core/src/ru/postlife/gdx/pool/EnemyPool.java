package ru.postlife.gdx.pool;

import ru.postlife.gdx.base.SpritesPool;
import ru.postlife.gdx.math.Rect;
import ru.postlife.gdx.sprite.EnemyShip;

public class EnemyPool extends SpritesPool<EnemyShip> {

    private final Rect worldBounds;
    private final BulletPool bulletPool;

    public EnemyPool(Rect worldBounds, BulletPool bulletPool) {
        this.worldBounds = worldBounds;
        this.bulletPool = bulletPool;
    }

    @Override
    protected EnemyShip newSprite() {
        return new EnemyShip(worldBounds, bulletPool);
    }
}
