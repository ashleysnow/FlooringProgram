/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
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
public class DateListTest {

    public DateListTest() {
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
     * Test of newOrderNum method, of class DateList.
     */
    @Test
    public void testNewOrderNum() {
        System.out.println("newOrderNum");
        DateList instance = new DateList();
        int expResult = 0;
        int result = instance.newOrderNum();
        assertEquals(1, result);

    }

    /**
     * Test of addOrder method, of class DateList.
     */
    @Test
    public void testAddOrder_8args() {

        System.out.println("addOrder");
        String dateString = "10122020";

        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        DateList instance = new DateList();
        instance.addOrderList(dateString);
        instance.addOrder(dateString, custName, state, taxRate, prodType, area, sqFtCost, sqFtLabor);
        OrderInterface temp = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        assertEquals(orderNumber, instance.getDatelist().get(dateString).get(0).getOrderNumber());
        assertEquals(custName, instance.getDatelist().get(dateString).get(0).getCustName());
        assertEquals(state, instance.getDatelist().get(dateString).get(0).getState());
        assertEquals(taxRate, instance.getDatelist().get(dateString).get(0).getTaxRate(),0.0);
        assertEquals(prodType, instance.getDatelist().get(dateString).get(0).getProdType());
        assertEquals(area, instance.getDatelist().get(dateString).get(0).getArea(),0.0);
        assertEquals(sqFtCost, instance.getDatelist().get(dateString).get(0).getSqFtCost(),0.0);
        assertEquals(sqFtLabor, instance.getDatelist().get(dateString).get(0).getSqFtLabor(),0.0);
        
    }

    /**
     * Test of addOrder method, of class DateList.
     */
    @Test
    public void testAddOrder_9args() {
        System.out.println("addOrder");
        System.out.println("addOrder");
        String dateString = "10122020";
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        DateListInterface instance = new DateList();
        instance.addOrderList(dateString);
        instance.addOrder(dateString, custName, state, taxRate, prodType, area, sqFtCost, sqFtLabor);
        Order temp = new Order(orderNumber, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor);
        
        instance.addOrder(orderNumber, dateString, custName, state, taxRate, prodType, area, sqFtCost, sqFtLabor);
        assertEquals(orderNumber, instance.getDatelist().get(dateString).get(0).getOrderNumber());
        assertEquals(custName, instance.getDatelist().get(dateString).get(0).getCustName());
        assertEquals(state, instance.getDatelist().get(dateString).get(0).getState());
        assertEquals(taxRate, instance.getDatelist().get(dateString).get(0).getTaxRate(),0.0);
        assertEquals(prodType, instance.getDatelist().get(dateString).get(0).getProdType());
        assertEquals(area, instance.getDatelist().get(dateString).get(0).getArea(),0.0);
        assertEquals(sqFtCost, instance.getDatelist().get(dateString).get(0).getSqFtCost(),0.0);
        assertEquals(sqFtLabor, instance.getDatelist().get(dateString).get(0).getSqFtLabor(),0.0);
    }

    /**
     * Test of editOrder method, of class DateList.
     */
    @Test
    public void testEditOrder() {
        System.out.println("editOrder");
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        String taxRate = "5", area = "200", sqFtCost = "10", sqFtLabor = "10";

        String dateString = "";

        DateList instance = new DateList();
        instance.addOrderList(dateString);
        instance.addOrder(dateString, custName, state, Double.parseDouble(taxRate), prodType, Double.parseDouble(area), Double.parseDouble(sqFtCost), Double.parseDouble(sqFtLabor));

        instance.editOrder(dateString, orderNumber, "Tom", "PA", taxRate, prodType, area, sqFtCost, sqFtLabor);

        assertEquals("Tom", instance.getDatelist().get(dateString).get(0).getCustName());
        assertEquals("PA", instance.getDatelist().get(dateString).get(0).getState());
    }

    /**
     * Test of removeOrder method, of class DateList.
     */
    @Test
    public void testRemoveOrder() {
        System.out.println("removeOrder");
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        String taxRate = "5", area = "200", sqFtCost = "10", sqFtLabor = "10";

        String dateString = "";
        DateList instance = new DateList();
        instance.addOrderList(dateString);
        instance.addOrder(dateString, custName, state, Double.parseDouble(taxRate), prodType, Double.parseDouble(area), Double.parseDouble(sqFtCost), Double.parseDouble(sqFtLabor));

        instance.removeOrder(dateString, "1");
        assertEquals(0, instance.getDatelist().get(dateString).size());

    }

    /**
     * Test of orderNumExists method, of class DateList.
     */
    @Test
    public void testOrderNumExists() {
        System.out.println("orderNumExists");
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        String taxRate = "5", area = "200", sqFtCost = "10", sqFtLabor = "10";
        String dateString = "";
        String orderNum = "1";
        DateList instance = new DateList();
        instance.addOrderList(dateString);
        instance.addOrder(dateString, custName, state, Double.parseDouble(taxRate), prodType, Double.parseDouble(area), Double.parseDouble(sqFtCost), Double.parseDouble(sqFtLabor));

        boolean expResult = false;
        boolean result = instance.orderNumExists(orderNum);
        assertEquals(true, instance.orderNumExists(orderNum));

    }

    /**
     * Test of findOrderString method, of class DateList.
     */
    @Test
    public void testFindOrderString() {
        System.out.println("findOrderString");
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        String dateString = "";

        DateListInterface instance = new DateList();
        instance.addOrderList(dateString);
        instance.addOrder(dateString, custName, state, taxRate, prodType, area, sqFtCost, sqFtLabor);

        String expResult = "\nOrder Number: " + orderNumber + "\nCustomer Name: " + custName + "\nState: " + state
                + "\nTax Rate: " + taxRate + "\nProduction Type: " + prodType + "\nArea: " + area
                + "\nCost per Square Foot: " + sqFtCost + "\nLabor Cost per Square Foot: " + sqFtLabor;
        String result = instance.findOrderString(dateString, orderNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of findOrder method, of class DateList.
     */
    @Test
    public void testFindOrder() {
        System.out.println("findOrder");
        String orderNumber = "1", custName = "Bob", state = "OH", prodType = "Wood";
        double taxRate = 5, area = 200, sqFtCost = 10, sqFtLabor = 10;
        String dateString = "";
        
        DateListInterface instance = new DateList();
        instance.addOrderList(dateString);
        instance.addOrder(dateString, custName, state, taxRate, prodType, area, sqFtCost, sqFtLabor);

        assertEquals(200 , instance.findOrder(orderNumber).getArea(), 0.0);
        assertEquals( 5 , instance.findOrder(orderNumber).getTaxRate(), 0.0);
        assertEquals( 10 , instance.findOrder(orderNumber).getSqFtCost(), 0.0);
        assertEquals(10, instance.findOrder(orderNumber).getSqFtLabor(), 0.0);
        assertEquals("1" , instance.findOrder(orderNumber).getOrderNumber());
        assertEquals("Bob", instance.findOrder(orderNumber).getCustName());
        assertEquals("OH", instance.findOrder(orderNumber).getState());
        assertEquals("Wood", instance.findOrder(orderNumber).getProdType());
    }

    /**
     * Test of getDatelist method, of class DateList.
     */
    @Test
    public void testGetDatelist() {
        System.out.println("getDatelist");
        DateList instance = new DateList();
        HashMap<String, ArrayList<OrderInterface>> expResult = instance.getDatelist();
        HashMap<String, ArrayList<OrderInterface>> result = instance.getDatelist();
        assertEquals(expResult, result);

    }

    /**
     * Test of dateExists method, of class DateList.
     */
    @Test
    public void testDateExists() {
        System.out.println("dateExists");
        String dateString = "12345678";
        DateList instance = new DateList();
        instance.addOrderList("12345678");
        instance.addOrderList("10122020");
        boolean expResult = false;
        boolean result = instance.dateExists(dateString);
        assertEquals(true, result);
        dateString = "98765432";
        assertEquals(false,instance.dateExists(dateString));
 
    }

    /**
     * Test of addOrderList method, of class DateList.
     */
    @Test
    public void testAddOrderList() {
        System.out.println("addOrderList");
        String date = "";
        DateList instance = new DateList();
        instance.addOrderList(date);

    }

    /**
     * Test of getKeys method, of class DateList.
     */
    @Test
    public void testGetKeys() {
        System.out.println("getKeys");
        DateList instance = new DateList();
        Set<String> expResult = instance.getDatelist().keySet();
        Set<String> result = instance.getKeys();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of displayAll method, of class DateList.
     */
    @Test
    public void testDisplayAll() {
        System.out.println("displayAll");
        DateList instance = new DateList();
        instance.displayAll();

    }

}
