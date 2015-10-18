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

public class DateList implements DateListInterface{

    private HashMap<String, ArrayList<OrderInterface>> dates = new HashMap();
    private Set<String> keys = dates.keySet();

    @Override
    public int newOrderNum() {
        int nextOrderNum = 0;
        for (String k : keys) {

            for (int i = 0; i < dates.get(k).size(); i++) {

                if (nextOrderNum < Integer.parseInt(dates.get(k).get(i).getOrderNumber())) {

                    nextOrderNum = Integer.parseInt(dates.get(k).get(i).getOrderNumber());

                }

            }

        }
        return nextOrderNum+1;
    }

    @Override
    public void addOrder(String dateString, String custName, String state, double taxRate,
            String prodType, double area, double sqFtCost, double sqFtLabor) {

        dates.get(dateString).add(new Order(newOrderNum() + "", custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor));
    }
    
    @Override
    public void addOrder(String orderNum, String dateString, String custName, String state, double taxRate,
            String prodType, double area, double sqFtCost, double sqFtLabor) {

        dates.get(dateString).add(new Order(orderNum, custName, state, taxRate,
                prodType, area, sqFtCost, sqFtLabor));
    }
    
    @Override
    public void editOrder(String dateString,String orderNumber,String custName,String state, String taxRate,String prodType,String area,String sqFtCost,String sqFtLabor){

        if(!custName.equals("")){
        findOrder(orderNumber).setCustName(custName);
        }
        if(!state.equals("")){
        findOrder(orderNumber).setState(state);
        }
        if(!taxRate.equals("")){
        findOrder(orderNumber).setTaxRate(Double.parseDouble(taxRate));
        }
        if(!prodType.equals("")){
        findOrder(orderNumber).setProdType(prodType);
        }
        if(!area.equals("")){
        findOrder(orderNumber).setArea(Double.parseDouble(area));
        }
        if(!sqFtCost.equals("")){
        findOrder(orderNumber).setSqFtCost(Double.parseDouble(sqFtCost));
        }
        if(!sqFtLabor.equals("")){
        findOrder(orderNumber).setSqFtLabor(Double.parseDouble(sqFtLabor));
        }
        
    }

    @Override
    public void removeOrder(String dateString, String orderNumber) {
        dates.get(dateString).remove(findOrder(orderNumber));
        
    }

    @Override
    public boolean orderNumExists(String orderNum) {
        int temp = Integer.parseInt(orderNum);
        for (String k : keys) {

            for (int i = 0; i < dates.get(k).size(); i++) {

                if (Integer.parseInt(dates.get(k).get(i).getOrderNumber()) == temp) {
                    return true;
                }

            }

        }
        return false;

    }

    @Override
    public String findOrderString(String dateString, String orderNumber) {
        for (String k : keys) {

            for (int i = 0; i < dates.get(k).size(); i++) {

                if (dates.get(k).get(i).getOrderNumber().equals(orderNumber)
                        && k.equals(dateString)) {
                    return dates.get(k).get(i).toString();

                }

            }

        }
        return null;

    }
    
    @Override
    public OrderInterface findOrder(String orderNumber) {
         for (String k : keys) {

        for (int i=0;i<dates.get(k).size();i++) {

            if (dates.get(k).get(i).getOrderNumber().equals(orderNumber)) {
                
                return dates.get(k).get(i);
                
            }

        }}
        return null;
    }

    @Override
    public HashMap<String, ArrayList<OrderInterface>> getDatelist() {

        return dates;

    }

    @Override
    public boolean dateExists(String dateString) {

        return dates.containsKey(dateString);

    }

    @Override
    public void addOrderList(String date) {

        dates.put(date, new ArrayList<OrderInterface>());

    }
    
    @Override
    public Set<String> getKeys(){
    return keys;
    }
    @Override
    public void displayAll(){
    
        for(String k : keys){
        
            for(int j=0;j<dates.get(k).size();j++){
            
                System.out.println(dates.get(k).get(j).toString());
            
            }
        
        }
    
    }
}
