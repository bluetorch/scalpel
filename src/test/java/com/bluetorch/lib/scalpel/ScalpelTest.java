/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluetorch.lib.scalpel;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author bruceholt
 */
public class ScalpelTest {
    
    public ScalpelTest() {
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
     * Test of getInstance method, of class Scalpel.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Scalpel scalpel = Scalpel.getInstance();
        assertNotNull(this);
    }

    /**
     * Test of replace method, of class Scalpel.
     */
    @Test
    public void testReplace_File_List() throws Exception {
        System.out.println("replace");
        File html = null;
        List<Replacement> replacements = null;
        Scalpel instance = null;
        String expResult = "";
        String result = instance.replace(html, replacements);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replace method, of class Scalpel.
     */
    @Test
    public void testReplace_String_List() {
        System.out.println("replace");
        String html = "";
        List<Replacement> replacements = null;
        Scalpel instance = null;
        String expResult = "";
        String result = instance.replace(html, replacements);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replace method, of class Scalpel.
     */
    @Test
    public void testReplace_InputStream_List() throws Exception {
        System.out.println("replace");
        InputStream html = null;
        List<Replacement> replacements = null;
        Scalpel instance = null;
        String expResult = "";
        String result = instance.replace(html, replacements);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replace method, of class Scalpel.
     */
    @Test
    public void testReplace_URL_List() throws Exception {
        System.out.println("replace");
        URL url = null;
        List<Replacement> replacements = null;
        Scalpel instance = null;
        String expResult = "";
        String result = instance.replace(url, replacements);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
