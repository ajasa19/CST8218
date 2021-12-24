/*
 *Class:    ConvertColorTest
 *Author    Asim Jasarevic & Nathan Denyer
 *project:  Assignment 02
 */
package utility;

import java.awt.Color;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
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
public class ConvertColorTest {
    
    public ConvertColorTest() {
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
     * Test of getAsObject method, of class ConvertColor.
     */
    @Test
    public void testGetAsObject() {
        System.out.println("getAsObject");
        FacesContext context = null;
        UIComponent component = null;
        String value = "#ffffff";
        ConvertColor instance = new ConvertColor();
        Color expResult = Color.WHITE;
        Color result = (Color)instance.getAsObject(context, component, value);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAsString method, of class ConvertColor.
     */
    @Test
    public void testGetAsString() {
        System.out.println("getAsString");
        FacesContext context = null;
        UIComponent component = null;
        Color value = Color.WHITE;
        ConvertColor instance = new ConvertColor();
        String expResult = "#ffffff";
        String result = instance.getAsString(context, component, value);
        assertEquals(expResult, result);
    }
    
}
