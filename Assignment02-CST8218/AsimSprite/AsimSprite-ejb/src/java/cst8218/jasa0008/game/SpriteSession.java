/*
 *Class:    SpriteSession
 *Author    Asim Jasarevic & Nathan Denyer
 *project:  Assignment 02
 */
package cst8218.jasa0008.game;

import cst8218.jasa0008.entity.Sprite;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 * Stateful session bean. Will maintain of the client across multiple requests.
 * The client invokes these methods and the work is performed on the server.
 * @author tgk
 */
@Stateful
public class SpriteSession implements SpriteSessionRemote {

    public static final Random random = new Random();
    Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    @EJB
    private SpriteGame spriteGame;

    public List<Sprite> getSpriteList() {
        return spriteGame.getSpriteList();
    }

    @Override
    public void newSprite(MouseEvent event) {
        spriteGame.newSprite(event, color);
    }
    @Override
    public int getHeight() {
        return spriteGame.HEIGHT;
    }
    @Override
    public int getWidth() {
        return spriteGame.WIDTH;
    }
}
