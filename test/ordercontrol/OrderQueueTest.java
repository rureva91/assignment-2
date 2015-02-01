/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ordercontrol;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author c0643680
 */
public class OrderQueueTest {
    
    public OrderQueueTest() {
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
     * Test of add method, of class OrderQueue.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        Order order = null;
        OrderQueue instance = new OrderQueue();
        instance.add(order);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
        @Test
    public void testWhenCustomerExistsAndPurchasesExistThenTimeReceivedIsNow() throws Exception {
        OrderQueue orderQueue = new OrderQueue();
        Order order = new Order("CUST00001", "ABC Construction");
        order.addPurchase(new Purchase("PROD0004", 450));
        order.addPurchase(new Purchase("PROD0006", 250));
        orderQueue.add(order);
        
        long expResult = new Date().getTime();
        long result = order.getTimeReceived().getTime();
        assertTrue(Math.abs(result - expResult) < 1000);
    }

        
    @Test
    public void testWhenCustomerIDAndCustomerNameNotExistThenThrowException() {
        boolean check = false;
        OrderQueue orderQueue = new OrderQueue();
        Order ord = new Order(null, null);
        try {
            orderQueue.add(ord);
        } catch (Exception e) {
            check = true;
        }
        assertTrue(check);
    }
    
    @Test
    public void testWhenListOfPurchasesDoesNotExistThenThrowException() throws Exception {
        boolean check = false;
        OrderQueue orderQueue = new OrderQueue();
        Order ord = new Order("CUST00002", "XYZ");
        try {
           orderQueue.add(ord);
        } catch (Exception e) {
            check = true;
        }
        assertTrue(check);
    }
    
    @Test
    public void testWhenThereAreOrdersInSystemThenReturnEarliestTimeRecievedOrder() throws Exception {
        OrderQueue orderQueue = new OrderQueue();
        Order ord = new Order("CUST00003", "RST");
        ord.addPurchase(new Purchase("PROD00001", 4));
        ord.addPurchase(new Purchase("PROD00002", 2));
        orderQueue.add(ord);
        
        Order ord1 = new Order("CUST00004", "PDR");
        ord1.addPurchase(new Purchase("PROD00003", 5));
        ord1.addPurchase(new Purchase("PROD00004", 5));
        orderQueue.add(ord1);
        
        Order ord2 = new Order("CUST00005", "UVW");
        ord2.addPurchase(new Purchase("PROD00005", 5));
        ord2.addPurchase(new Purchase("PROD00006", 5));
        orderQueue.add(ord2);
        
        assertEquals(ord, orderQueue.next());
    }
    
    @Test
    public void testWhenNoOrdersInSystemThenReturnNull() {
        OrderQueue queue = new OrderQueue();
        Order expectedResult = null;
        String result = "";
        try {
            queue.next();
        } catch (Exception e) {
            result = null;
        }
        assertEquals(expectedResult, result);
    }
    
}
    

