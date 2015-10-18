/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

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
public class OrderTest {

    public OrderTest() {
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
     * Test of toString method, of class Order.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        String expResult = "\nOrder Number: " + orderNumber + "\nCustomer Name: " + custName + "\nState: " + state
                + "\nTax Rate: " + taxRate + "\nProduction Type: " + prodType + "\nArea: " + area
                + "\nCost per Square Foot: " + sqFtCost + "\nLabor Cost per Square Foot: " + sqFtLabor;
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of getOrderNumber method, of class Order.
     */
    @Test
    public void testGetOrderNumber() {
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 6, area = 200, sqFtCost = 25, sqFtLabor = 25;

        System.out.println("getOrderNumber");
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);

        String expResult = "1";
        String result = instance.getOrderNumber();

        assertEquals(expResult, result);

    }

    /**
     * Test of getCustName method, of class Order.
     */
    @Test
    public void testGetCustName() {
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 6, area = 200, sqFtCost = 25, sqFtLabor = 25;

        System.out.println("getCustName");
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        String expResult = "Bob";
        String result = instance.getCustName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getState method, of class Order.
     */
    @Test
    public void testGetState() {
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 6, area = 200, sqFtCost = 25, sqFtLabor = 25;

        System.out.println("getState");
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        String expResult = "OH";
        String result = instance.getState();
        assertEquals(expResult, result);

    }

    /**
     * Test of getProdType method, of class Order.
     */
    @Test
    public void testGetProdType() {
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 6, area = 200, sqFtCost = 25, sqFtLabor = 25;

        System.out.println("getProdType");
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        String expResult = "Wood";
        String result = instance.getProdType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTaxRate method, of class Order.
     */
    @Test
    public void testGetTaxRate() {
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 6, area = 200, sqFtCost = 25, sqFtLabor = 25;

        System.out.println("getTaxRate");
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        double expResult = 6.0;
        double result = instance.getTaxRate();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getArea method, of class Order.
     */
    @Test
    public void testGetArea() {

        System.out.println("getArea");
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 6, area = 200, sqFtCost = 25, sqFtLabor = 25;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        double expResult = 200.0;
        double result = instance.getArea();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getSqFtCost method, of class Order.
     */
    @Test
    public void testGetSqFtCost() {
        System.out.println("getSqFtCost");
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 6, area = 200, sqFtCost = 25, sqFtLabor = 25;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        double expResult = 25.0;
        double result = instance.getSqFtCost();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getSqFtLabor method, of class Order.
     */
    @Test
    public void testGetSqFtLabor() {
        System.out.println("getSqFtLabor");
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 6, area = 200, sqFtCost = 25, sqFtLabor = 25;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        double expResult = 25.0;
        double result = instance.getSqFtLabor();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getMatCost method, of class Order.
     */
    @Test
    public void testGetMatCost() {
        System.out.println("getMatCost");
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 6, area = 200, sqFtCost = 10, sqFtLabor = 10;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        double expResult = 2000.0;
        double result = instance.getMatCost();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getLaborCost method, of class Order.
     */
    @Test
    public void testGetLaborCost() {
        System.out.println("getLaborCost");
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 6, area = 200, sqFtCost = 10, sqFtLabor = 10;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        double expResult = 2000.0;
        double result = instance.getLaborCost();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getTax method, of class Order.
     */
    @Test
    public void testGetTax() {
        System.out.println("getTax");
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        double expResult = 200.0;
        double result = instance.getTax();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getTotal method, of class Order.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        double expResult = 4200.0;
        double result = instance.getTotal();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of setCustName method, of class Order.
     */
    @Test
    public void testSetCustName() {
        System.out.println("custName");
        String custName2 = "Ted";
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        instance.setCustName(custName2);
        assertEquals("Ted", instance.getCustName());

    }

    /**
     * Test of setState method, of class Order.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        String state2 = "PA";
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        instance.setState(state2);
        assertEquals("PA", instance.getState());
    }

    /**
     * Test of setProdType method, of class Order.
     */
    @Test
    public void testSetProdType() {
        System.out.println("setProdType");
        String prodType2 = "Wood";
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        instance.setProdType(prodType2);
        assertEquals("Wood", instance.getProdType());

    }

    /**
     * Test of setTaxRate method, of class Order.
     */
    @Test
    public void testSetTaxRate() {
        System.out.println("setTaxRate");
        double taxRate2 = 5.0;
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        instance.setTaxRate(taxRate2);
        assertEquals(5, instance.getTaxRate(), 0.0);

    }

    /**
     * Test of setArea method, of class Order.
     */
    @Test
    public void testSetArea() {
        System.out.println("setArea");
        double area2 = 100.0;
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        instance.setArea(area2);
        assertEquals(100, instance.getArea(), 0.0);
    }

    /**
     * Test of setSqFtCost method, of class Order.
     */
    @Test
    public void testSetSqFtCost() {
        System.out.println("setSqFtCost");
        double sqFtCost2 = 2.0;
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        instance.setSqFtCost(sqFtCost2);
        assertEquals(2, instance.getSqFtCost(), 0.0);
    }

    /**
     * Test of setSqFtLabor method, of class Order.
     */
    @Test
    public void testSetSqFtLabor() {
        System.out.println("setSqFtLabor");
        double sqFtLabor2 = 2.0;
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        Order instance = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        instance.setSqFtLabor(sqFtLabor2);
        assertEquals(2, instance.getSqFtLabor(), 0.0);
    }

}
