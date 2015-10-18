/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class StorageTest {
    
    public StorageTest() {
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
     * Test of read method, of class Storage.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        String fileName = "Config.txt";
        Storage instance = new Storage();
        String expResult = "mode";
        String result = instance.read(fileName).get(0)[0].split("=")[0];
        assertEquals(expResult, result);
        
        boolean result2 = instance.read(fileName).get(0)[0].split("=")[0].equals("wrong thing");
        
        assertFalse(result2);
        
        
    }

    /**
     * Test of write method, of class Storage.
     */
    @Test
    public void testWrite() {
        System.out.println("write");
        String fileName = "testwrite.txt";
        ArrayList<String[]> temp = new ArrayList<>();
        String[] e={"test"};
        temp.add(e);
        Storage instance = new Storage();
        instance.write(fileName, temp);
        
        String fileName1 = "testwrite.txt";
        Storage instance1 = new Storage();
        String expResult1 = "test";
        String result1 = instance.read(fileName).get(0)[0].split("=")[0];
        
        
        assertEquals(expResult1, result1);
        
    }
    
}
