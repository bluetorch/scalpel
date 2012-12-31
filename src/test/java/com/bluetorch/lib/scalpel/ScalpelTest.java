/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluetorch.lib.scalpel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private List<Replacement> replacements;
    private String expected;

    public ScalpelTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        replacements = new ArrayList<Replacement>();
        replacements.add(new Replacement("#node", new Fragment("<a href='#node'>anchor!</a>", FragmentType.NODE)));
        replacements.add(new Replacement("#text", new Fragment("Text Replaced!", FragmentType.TEXT)));
        replacements.add(new Replacement("#contents", new Fragment("<ul><li>Lorem</li><li>ipsum</li><li>dolor</li><li>sit</li><li>amet</li></ul>", FragmentType.CONTENTS)));
        replacements.add(new Replacement("#position", new Fragment("<div>This is after!</div>", FragmentType.AFTER)));
        replacements.add(new Replacement("#position", new Fragment("<li>Last item</li>", FragmentType.APPEND)));
        replacements.add(new Replacement("#position", new Fragment("<li>First item</li>", FragmentType.PREPEND)));
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("class", "replaced fun");
        attributes.put("title", "new title");
        replacements.add(new Replacement("#change", new Fragment(attributes)));
        expected = readFile(new File(this.getClass().getResource("testResult.html").toURI()));
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
        System.out.println("replace file");
        File html = new File(this.getClass().getResource("testScalpel.html").toURI());
        Scalpel instance = Scalpel.getInstance();
        String result = instance.replace(html, replacements);
        assertEquals(expected, result);
    }

    /**
     * Test of replace method, of class Scalpel.
     */
    @Test
    public void testReplace_String_List() throws Exception {
        System.out.println("replace string");
        File htmlFile = new File(this.getClass().getResource("testScalpel.html").toURI());
        String html = readFile(htmlFile);
        Scalpel instance = Scalpel.getInstance();
        String result = instance.replace(html, replacements);
        assertEquals(expected, result);
    }

    /**
     * Test of replace method, of class Scalpel.
     */
    @Test
    public void testReplace_InputStream_List() throws Exception {
        System.out.println("replace stream");
        InputStream html = new FileInputStream(new File(this.getClass().getResource("testScalpel.html").toURI()));
        Scalpel instance = Scalpel.getInstance();
        String result = instance.replace(html, replacements);
        assertEquals(expected, result);
    }

    /**
     * Test of replace method, of class Scalpel.
     */
    @Test
    public void testReplace_URL_List() throws Exception {
        System.out.println("replace url");
        URL url = new URL("http://www.bluetorchsource.com/testScalpel.html");
        Scalpel instance = Scalpel.getInstance();
        String result = instance.replace(url, replacements);
        assertEquals(expected, result);
    }

    private String readFile(File file) throws Exception {
        FileInputStream stream = new FileInputStream(file);
        try {
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            /* Instead of using default, pass in a decoder. */
            return Charset.defaultCharset().decode(bb).toString();
        } finally {
            stream.close();
        }
    }
}
