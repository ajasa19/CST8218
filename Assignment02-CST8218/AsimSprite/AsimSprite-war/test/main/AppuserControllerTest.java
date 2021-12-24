/*
 *Class:    AppuserControllerTest
 *Author    Asim Jasarevic & Nathan Denyer
 *project:  Assignment 02
 */
package main;

import cst8218.jasa0008.entity.Appuser;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import main.util.PaginationHelper;
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
public class AppuserControllerTest {
    
    public AppuserControllerTest() {
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
     * Test of getSelected method, of class AppuserController.
     */
    @Test
    public void testGetSelected() {
        System.out.println("getSelected");
        AppuserController instance = new AppuserController();
        Appuser expResult = new Appuser();
        Appuser result = instance.getSelected();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPagination method, of class AppuserController.
     */
    /**
    @Test
    public void testGetPagination() {
        System.out.println("getPagination");
        AppuserController instance = new AppuserController();
        PaginationHelper expResult = new PaginationHelper(10) {
            @Override
            public int getItemsCount() {
                return 0;
            }

            @Override
            public DataModel createPageDataModel() {
                return new ListDataModel();
            }
        };
        System.out.println(expResult.toString());
        PaginationHelper result = instance.getPagination();
        System.out.println(result.getItemsCount());
        assertEquals(expResult.getItemsCount(), result.getItemsCount());
    }
    * */

    /**
     * Test of prepareList method, of class AppuserController.
     */
    @Test
    public void testPrepareList() {
        System.out.println("prepareList");
        AppuserController instance = new AppuserController();
        String expResult = "List";
        String result = instance.prepareList();
        assertEquals(expResult, result);
    }

    /**
     * Test of prepareView method, of class AppuserController.
     * Expected to fail as pagination is not configured.
     */
    @Test(expected = NullPointerException.class)
    public void testPrepareView() {
        System.out.println("prepareView");
        AppuserController instance = new AppuserController();
        String expResult = "View";
        String result = instance.prepareView();
        assertEquals(expResult, result);
    }

    /**
     * Test of prepareCreate method, of class AppuserController.
     * 
     */
    @Test
    public void testPrepareCreate() {
        System.out.println("prepareCreate");
        AppuserController instance = new AppuserController();
        String expResult = "Create";
        String result = instance.prepareCreate();
        assertEquals(expResult, result);
    }


    /**
     * Test of prepareEdit method, of class AppuserController.
     * Expected to fail as pagination is not configured.
     */
    @Test(expected = NullPointerException.class)
    public void testPrepareEdit() {
        System.out.println("prepareEdit");
        AppuserController instance = new AppuserController();
        String expResult = "Edit";
        String result = instance.prepareEdit();
        assertEquals(expResult, result);
    }

    /**
     * Test of destroy method, of class AppuserController.
     * Expected to fail as there is nothing to destroy
     */
    @Test(expected = NullPointerException.class)
    public void testDestroy() {
        System.out.println("destroy");
        AppuserController instance = new AppuserController();
        String expResult = "List";
        String result = instance.destroy();
        assertEquals(expResult, result);
    }

    /**
     * Test of getItems method, of class AppuserController.
     * Expected to fail as there are no items
     */
    @Test(expected = NullPointerException.class)
    public void testGetItems() {
        System.out.println("getItems");
        AppuserController instance = new AppuserController();
        DataModel expResult = instance.getPagination().createPageDataModel();
        DataModel result = instance.getItems();
        assertEquals(expResult, result);
    }

    /**
     * Test of next method, of class AppuserController.
     * Expected to fail as there is no next page
     */
    @Test(expected = NullPointerException.class)
    public void testNext() {
        System.out.println("next");
        AppuserController instance = new AppuserController();
        String expResult = "List";
        String result = instance.next();
        assertEquals(expResult, result);
    }

    /**
     * Test of previous method, of class AppuserController
     * Expected to fail as there is no previous page.
     */
   @Test
    public void testPrevious() {
        System.out.println("previous");
        AppuserController instance = new AppuserController();
        String expResult = "";
        String result = instance.previous();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getItemsAvailableSelectMany method, of class AppuserController.
     * Expected to fail as there are no items to get.
     */
    @Test(expected = NullPointerException.class)
    public void testGetItemsAvailableSelectMany() {
        System.out.println("getItemsAvailableSelectMany");
        AppuserController instance = new AppuserController();
        SelectItem[] expResult = null;
        SelectItem[] result = instance.getItemsAvailableSelectMany();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getItemsAvailableSelectOne method, of class AppuserController.
     * * Expected to fail as there are no items to get.
     */
     @Test(expected = NullPointerException.class)
    public void testGetItemsAvailableSelectOne() {
        System.out.println("getItemsAvailableSelectOne");
        AppuserController instance = new AppuserController();
        SelectItem[] expResult = null;
        SelectItem[] result = instance.getItemsAvailableSelectOne();
        assertArrayEquals(expResult, result);
    }
    
    //TODO: NEED ID
    /**
     * Test of getAppuser method, of class AppuserController.
     * * Expected to fail as there are no users to get.
     */
    @Test(expected = NullPointerException.class)
    public void testGetAppuser() {
        System.out.println("getAppuser");
        Long id = null;
        AppuserController instance = new AppuserController();
        Appuser expResult = null;
        Appuser result = instance.getAppuser(id);
        assertEquals(expResult, result);
    }
    
}
