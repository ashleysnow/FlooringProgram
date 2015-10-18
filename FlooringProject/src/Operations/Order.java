/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;


/**
 *
 * @author apprentice
 */
public class Order implements OrderInterface{
    private String orderNumber, custName, state, prodType;
    private double taxRate, area, sqFtCost,sqFtLabor;
            
    public Order(String orderNumber, String custName, String state, double taxRate,
            String prodType, double area, double sqFtCost, double sqFtLabor){
    
    this.orderNumber=orderNumber;
    this.custName=custName;
    this.state=state;
    this.taxRate=taxRate;
    this.prodType=prodType;
    this.area=area;
    this.sqFtCost=sqFtCost;
    this.sqFtLabor=sqFtLabor;
    }
    
    
    
    
    @Override
    public String toString(){
    
        return "\nOrder Number: "+orderNumber+"\nCustomer Name: "+custName+"\nState: "+state
                +"\nTax Rate: "+taxRate+"\nProduction Type: "+prodType+"\nArea: "+area+
                "\nCost per Square Foot: "+sqFtCost+"\nLabor Cost per Square Foot: "+sqFtLabor;
    
    }
//getters
    @Override
    public String getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String getCustName() {
        return custName;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public String getProdType() {
        return prodType;
    }

    @Override
    public double getTaxRate() {
        return taxRate;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getSqFtCost() {
        return sqFtCost;
    }

    @Override
    public double getSqFtLabor() {
        return sqFtLabor;
    }
//can be calced ******
    @Override
    public double getMatCost() {
        return sqFtCost*area;
    }

    @Override
    public double getLaborCost() {
        return sqFtLabor*area;
    }

    @Override
    public double getTax() {
        return taxRate*(getLaborCost()+getMatCost())/100;
    }

    @Override
    public double getTotal() {
        return (getLaborCost()+getMatCost())+(taxRate*(getLaborCost()+getMatCost())/100);
    }
//setters
    @Override
    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    @Override
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public void setSqFtCost(double sqFtCost) {
        this.sqFtCost = sqFtCost;
    }

    @Override
    public void setSqFtLabor(double sqFtLabor) {
        this.sqFtLabor = sqFtLabor;
    }
}
