/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public interface DateListInterface{

    
    
    public abstract int newOrderNum();

    public abstract void addOrder(String dateString, String custName, String state, double taxRate,
            String prodType, double area, double sqFtCost, double sqFtLabor);

    public abstract void addOrder(String orderNum, String dateString, String custName, String state, double taxRate,
            String prodType, double area, double sqFtCost, double sqFtLabor);

    public abstract void editOrder(String dateString, String orderNumber, String custName, String state,
            String taxRate, String prodType, String area, String sqFtCost, String sqFtLabor);

    public abstract void removeOrder(String dateString, String orderNumber);

    public abstract boolean orderNumExists(String orderNum);

    public abstract String findOrderString(String dateString, String orderNumber);

    public abstract OrderInterface findOrder(String orderNumber);

    public abstract HashMap<String, ArrayList<OrderInterface>> getDatelist();

    public abstract boolean dateExists(String dateString);

    public abstract void addOrderList(String date);

    public abstract Set<String> getKeys();

    public abstract void displayAll();

}
