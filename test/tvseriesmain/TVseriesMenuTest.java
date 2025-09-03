/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package tvseriesmain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
public class TVseriesMenuTest {
    
    public TVseriesMenuTest() {
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
     * Test of run method, of class TVseriesMenu.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        TVseriesMenu instance = new TVseriesMenu();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showMenu method, of class TVseriesMenu.
     */
    @Test
    public void testShowMenu() {
        System.out.println("showMenu");
        TVseriesMenu instance = new TVseriesMenu();
        instance.showMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of captureSeries method, of class TVseriesMenu.
     */
    @Test
    public void testCaptureSeries() {
        System.out.println("captureSeries");
        TVseriesMenu instance = new TVseriesMenu();
        instance.captureSeries();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValidSeriesAge method, of class TVseriesMenu.
     */
    @Test
    public void testGetValidSeriesAge() {
        System.out.println("getValidSeriesAge");
        TVseriesMenu instance = new TVseriesMenu();
        String expResult = "";
        String result = instance.getValidSeriesAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNumeric method, of class TVseriesMenu.
     */
    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric");
        String str = "";
        TVseriesMenu instance = new TVseriesMenu();
        boolean expResult = false;
        boolean result = instance.isNumeric(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchSeries method, of class TVseriesMenu.
     */
    @Test
    public void testSearchSeries() {
        System.out.println("searchSeries");
        TVseriesMenu instance = new TVseriesMenu();
        instance.searchSeries();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateSeries method, of class TVseriesMenu.
     */
    @Test
    public void testUpdateSeries() {
        System.out.println("updateSeries");
        TVseriesMenu instance = new TVseriesMenu();
        instance.updateSeries();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSeries method, of class TVseriesMenu.
     */
    @Test
    public void testDeleteSeries() {
        System.out.println("deleteSeries");
        TVseriesMenu instance = new TVseriesMenu();
        instance.deleteSeries();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printSeriesReport method, of class TVseriesMenu.
     */
    @Test
    public void testPrintSeriesReport() {
        System.out.println("printSeriesReport");
        TVseriesMenu instance = new TVseriesMenu();
        instance.printSeriesReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exitSeriesApplication method, of class TVseriesMenu.
     */
    @Test
    public void testExitSeriesApplication() {
        System.out.println("exitSeriesApplication");
        TVseriesMenu instance = new TVseriesMenu();
        instance.exitSeriesApplication();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of backToMenuOrExit method, of class TVseriesMenu.
     */
    @Test
    public void testBackToMenuOrExit() {
        System.out.println("backToMenuOrExit");
        TVseriesMenu instance = new TVseriesMenu();
        instance.backToMenuOrExit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
