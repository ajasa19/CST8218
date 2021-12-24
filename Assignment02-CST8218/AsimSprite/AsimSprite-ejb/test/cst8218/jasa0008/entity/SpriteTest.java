/*
 *Class:    SpriteTest
 *Author    Asim Jasarevic & Nathan Denyer
 *project:  Assignment 02
 */
package cst8218.jasa0008.entity;

import java.awt.Color;
import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nathan Denyer
 */
public class SpriteTest {
    
    public SpriteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Sprite.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Sprite instance = new Sprite();
        Long expResult = 1L;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Sprite.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Sprite instance = new Sprite();
        Long id = 1L;
        instance.setId(id);
        assertEquals(instance.getId(), id);
    }

    /**
     * Test of update method, of class Sprite.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Sprite instance = new Sprite();
        Sprite updateSprite = new Sprite();
        instance.update(updateSprite);
        assertEquals(updateSprite, instance);
    }

    /**
     * Test of getPanelWidth method, of class Sprite.
     */
    @Test
    public void testGetPanelWidth() {
        System.out.println("getPanelWidth");
        Sprite instance = new Sprite();
        Integer expResult = null;
        Integer result = instance.getPanelWidth();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPanelWidth method, of class Sprite.
     */
    @Test
    public void testSetPanelWidth() {
        System.out.println("setPanelWidth");
        Integer panelWidth = 1;
        Sprite instance = new Sprite();
        instance.setPanelWidth(panelWidth);
        assertEquals(panelWidth, instance.getPanelWidth());
    }

    /**
     * Test of getPanelHeight method, of class Sprite.
     */
    @Test
    public void testGetPanelHeight() {
        System.out.println("getPanelHeight");
        Sprite instance = new Sprite();
        Integer expResult = null;
        Integer result = instance.getPanelHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPanelHeight method, of class Sprite.
     */
    @Test
    public void testSetPanelHeight() {
        System.out.println("setPanelHeight");
        Integer panelHeight = 1;
        Sprite instance = new Sprite();
        instance.setPanelHeight(panelHeight);
        assertEquals(panelHeight, instance.getPanelHeight());
    }

    /**
     * Test of getX method, of class Sprite.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Sprite instance = new Sprite();
        Integer expResult = null;
        Integer result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of setX method, of class Sprite.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        Integer x = 1;
        Sprite instance = new Sprite();
        instance.setX(x);
        assertEquals(x, instance.getX());
    }

    /**
     * Test of getY method, of class Sprite.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Sprite instance = new Sprite();
        Integer expResult = null;
        Integer result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of setY method, of class Sprite.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        Integer y = 1;
        Sprite instance = new Sprite();
        instance.setY(y);
        assertEquals(y, instance.getY());
    }

    /**
     * Test of getDx method, of class Sprite.
     */
    @Test
    public void testGetDx() {
        System.out.println("getDx");
        Sprite instance = new Sprite();
        Integer expResult = null;
        Integer result = instance.getDx();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDx method, of class Sprite.
     */
    @Test
    public void testSetDx() {
        System.out.println("setDx");
        Integer dx = 1;
        Sprite instance = new Sprite();
        instance.setDx(dx);
        assertEquals(dx, instance.getDx());
    }

    /**
     * Test of getDy method, of class Sprite.
     */
    @Test
    public void testGetDy() {
        System.out.println("getDy");
        Sprite instance = new Sprite();
        Integer expResult = null;
        Integer result = instance.getDy();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDy method, of class Sprite.
     */
    @Test
    public void testSetDy() {
        System.out.println("setDy");
        Integer dy = 1;
        Sprite instance = new Sprite();
        instance.setDy(dy);
        assertEquals(dy, instance.getDy());
    }

    /**
     * Test of getColor method, of class Sprite.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Sprite instance = new Sprite();
        Color expResult = Color.BLUE;
        Color result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setColor method, of class Sprite.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Color color = Color.black;
        Sprite instance = new Sprite();
        instance.setColor(color);
        assertEquals(color, instance.getColor());
    }

    /**
     * Test of draw method, of class Sprite.
     */
    @Test(expected=NullPointerException.class)
    public void testDraw() {
        System.out.println("draw");
        Sprite instance = new Sprite();
        Graphics g = null;
        instance.draw(g);
    }
    
    //Possible to test this?
    /**
     * Test of move method, of class Sprite.
     */
  //  @Test
  //  public void testMove() {
   //     System.out.println("move");
  //      Sprite instance = new Sprite();
   //     instance.move();
   //     Integer result = instance.getX() + instance.getDx();
   //     Integer 
   //     assertEquals(instance.)
 //   }

    /**
     * Test of hashCode method, of class Sprite.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Sprite instance = new Sprite();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Sprite.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Sprite instance = new Sprite();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Sprite.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Sprite instance = new Sprite();
        String expResult = "entities.Sprite[ id=null ]";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
