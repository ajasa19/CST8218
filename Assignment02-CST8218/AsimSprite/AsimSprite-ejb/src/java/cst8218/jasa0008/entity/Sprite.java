/*
 *Class:    Sprite
 *Author    Asim Jasarevic & Nathan Denyer
 *project:  Assignment 02
 */
package cst8218.jasa0008.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Sprite entity class. Contains annotations for ORM.                                       
 * @author Nathan Denyer
 * @version 1
 * @since 1.8
 * @see SpriteFacade
 */
@Entity
public class Sprite implements Serializable {

    private static final long serialVersionUID = 1L;

    public final static Random random = new Random();

    final static int SIZE = 10;
    final static int MAX_SPEED = 5;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column
    private Integer panelWidth;
    @Column
    private Integer panelHeight;
    @Column
    private Integer x;
    @Column
    private Integer y;
    @Column
    private Integer dx;
    @Column
    private Integer dy;
    @Column
    private Color color = Color.BLUE;

    public Sprite() { }

    public Sprite(Integer height, Integer width) {
        this.panelWidth = width;
        this.panelHeight = height;
        x = random.nextInt(width);
        y = random.nextInt(height);
        dx = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
        dy = random.nextInt(2 * MAX_SPEED) - MAX_SPEED;
    }

    public Sprite(Integer height, Integer width, Color color) {
        this(height, width);
        this.color = color;
    }
    /**
     * Copy new sprite non-null fields to the current sprite
     * @param sprite 
     */
    public void update(Sprite sprite)
    {
        //Test if each sprite field is null.
        //If the field is not null, update the field with new information.
        //If the field is null, don't update the field.
        if (null != sprite.getPanelWidth())
        {
            this.setPanelWidth(sprite.getPanelWidth());
        }
        if (null != sprite.getPanelHeight())
        {
            this.setPanelHeight(sprite.getPanelHeight());
        }
        if (null != sprite.getX())
        {
            this.setX(sprite.getX());
        }
        if (null != sprite.getY())
        {
            this.setY(sprite.getY());
        }
        if (null != sprite.getDx())
        {
            this.setDx(sprite.getDx());
        }
        if (null != sprite.getDx())
        {
            this.setDy(sprite.getDy());
        }
    }
    
    public Integer getPanelWidth() {
        return panelWidth;
    }

    public void setPanelWidth(Integer panelWidth) {
        this.panelWidth = panelWidth;
    }

    public Integer getPanelHeight() {
        return panelHeight;
    }

    public void setPanelHeight(Integer panelHeight) {
        this.panelHeight = panelHeight;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getDx() {
        return dx;
    }

    public void setDx(Integer dx) {
        this.dx = dx;
    }

    public Integer getDy() {
        return dy;
    }

    public void setDy(Integer dy) {
        this.dy = dy;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, SIZE, SIZE);
    }

    public void move() {

        // check for bounce and make the ball bounce if necessary
        //
        if (x < 0 && dx < 0) {
            //bounce off the left wall 
            x = 0;
            dx = -dx;
        }
        if (y < 0 && dy < 0) {
            //bounce off the top wall
            y = 0;
            dy = -dy;
        }
        if (x > panelWidth - SIZE && dx > 0) {
            //bounce off the right wall
            x = panelWidth - SIZE;
            dx = -dx;
        }
        if (y > panelHeight - SIZE && dy > 0) {
            //bounce off the bottom wall
            y = panelHeight - SIZE;
            dy = -dy;
        }

        //make the ball move
        x += dx;
        y += dy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sprite)) {
            return false;
        }
        Sprite other = (Sprite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sprite[ id=" + id + " ]";
    }

}
