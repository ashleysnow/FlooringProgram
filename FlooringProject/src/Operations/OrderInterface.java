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
public interface OrderInterface {
    
    
    @Override
    public abstract String toString();
    
    public abstract String getOrderNumber();

    public abstract String getCustName();

    public abstract String getState();

    public abstract String getProdType();

    public abstract double getTaxRate();

    public abstract double getArea();

    public abstract double getSqFtCost();

    public abstract double getSqFtLabor();
//can be calced ******
    public abstract double getMatCost();
    
    public abstract double getLaborCost();

    public abstract double getTax();

    public abstract double getTotal();
//setters
    public abstract void setCustName(String custName);

    public abstract void setState(String state);

    public abstract void setProdType(String prodType);

    public abstract void setTaxRate(double taxRate);

    public abstract void setArea(double area);

    public abstract void setSqFtCost(double sqFtCost);

    public abstract void setSqFtLabor(double sqFtLabor);
    
    
    
}
