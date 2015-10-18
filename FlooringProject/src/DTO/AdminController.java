/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.Storage;
import DAO.StorageInterface;
import UI.ConsoleIO;
import UI.ConsoleInterface;
import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class AdminController {

    private ConsoleInterface io = new ConsoleIO();
    private StorageInterface sto = new Storage();

    void runAdmin() {

        int userInput = io.readInteger("\n*  Admin  *\n"
                + "1. add state"
                + "2. edit state"
                + "3. remove state"
                + "4. add product"
                + "5. edit product"
                + "6. remove product", 1, 6);

        switch (userInput) {
            case 1:
                ArrayList<String[]> taxes = sto.read("DataTaxes.txt");
                String[] newstate = new String[2];
                newstate[0] = io.readString("Enter new State");
                newstate[1] = "" + io.readDouble("Enter Tax Rate", 0, 100);
                taxes.add(newstate);
                sto.write("DataTaxes.txt", taxes);
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                ArrayList<String[]> products = sto.read("DataProducts.txt");
                String[] newprod = new String[3];
                newprod[0] = io.readString("Enter new Product Type");
                newprod[1] = "" + io.readDouble("Enter Material Cost Per Square Foot", 0, 100);
                newprod[2] = "" + io.readDouble("Enter Labor Cost Per Square Foot", 0, 100);
                products.add(newprod);
                sto.write("DataTaxes.txt", products);
                break;
            case 5:

                break;
            case 6:

                break;

            default:
                throw new AssertionError();
        }

    }

}
