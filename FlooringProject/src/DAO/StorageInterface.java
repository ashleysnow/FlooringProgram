/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public interface StorageInterface {
    
    public abstract ArrayList<String[]> read(String fileName);
    
    public abstract void write(String fileName, ArrayList<String[]> temp);
}
