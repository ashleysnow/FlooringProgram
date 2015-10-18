/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author apprentice
 */
public interface ConsoleInterface {
    
    public abstract int readInteger(String p);
    
    public abstract int readInteger(String p, int min, int max);
    
    public abstract int readInteger(String p, int min, int max, int exception);
    
     public abstract String readString(String p);
     
     public abstract float readFloat(String p);
     
     public abstract float readFloat(String p, float min, float max);
     
     public abstract double readDouble(String p);
     
     public abstract double readDouble(String p, double min, double max);
     
     public abstract void write(String p);
     
     
}
