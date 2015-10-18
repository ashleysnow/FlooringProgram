/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.Storage;
import DAO.StorageInterface;
import Operations.DateList;
import Operations.DateListInterface;
import UI.ConsoleIO;
import UI.ConsoleInterface;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;

/**
 *
 * @author apprentice
 */
public class Controller {

    private ConsoleInterface io = new ConsoleIO();
    private DateListInterface list = new DateList();
    private StorageInterface sto = new Storage();
    private Date date = new Date();
    private boolean testMode;

    void runProgram() {

        load();
        if (testMode == true) {
            io.write("Test Mode On.");
        }
        while (true) {

            int userInput = io.readInteger("\n*  Flooring Program  *\n"
                    + "\n 1. Display Orders\n"
                    + "\n 2. Add An Order\n"
                    + "\n 3. Edit An Order\n"
                    + "\n 4. Remove An Order\n"
                    + "\n 5. Save Current Work\n"
                    + "\n 6. Quit\n", 1, 6);

            switch (userInput) {

                case 1:
                    displayOrder();
                    break;
                case 2:
                    addOrder();
                    break;
                case 3:
                    editOrder();
                    break;
                case 4:
                    removeOrder();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    if (quit()) {
                        return;
                    }

            }

        }

    }

    void displayOrder() {

        if (list.getDatelist().isEmpty()) {

            io.write("Your current date list is empty, please enter values first.\n");
            return;

        }
        String temp = io.readString("Please enter the date you would like diplayed: ");

        if (list.getDatelist().containsKey(temp)) {

            for (int i = 0; i < list.getDatelist().get(temp).size(); i++) {

                io.write(list.getDatelist().get(temp).get(i).toString());

            }

        } else {

            io.write("This date does not exist.");

        }

    }

    private void addOrder() {

        ArrayList<String[]> dt = sto.read("DataTaxes.txt");
        ArrayList<String[]> dp = sto.read("DataProducts.txt");
        boolean validState = false;
        boolean validProduction = false;
        double newTaxRate, newSqFtCost, newSqFtLabor;
        String dateString = getDate();
        String state = " ";
        String prodType = " ";
        String custName = io.readString("\nEnter name: ");

        String[] info = validStateRate(validState, state, dt);
        state = info[0];
        newTaxRate = Double.parseDouble(info[1]);

        String[] sqFtCosts = validProductionCosts(validProduction, prodType, dp);
        prodType = sqFtCosts[0];
        newSqFtCost = Double.parseDouble(sqFtCosts[1]);
        newSqFtLabor = Double.parseDouble(sqFtCosts[2]);

        double area = io.readDouble("Enter area: ");

        io.write("\nDate: " + dateString + "\nCustomer Name: " + custName + "\nState: " + state
                + "\nTax Rate: " + newTaxRate + "\nProduction Type: " + prodType + "\nArea: " + area
                + "\nCost per Square Foot: " + newSqFtCost + "\nLabor Cost per Square Foot: " + newSqFtLabor
                + "\nMaterial Cost: " + area * newSqFtCost + "\nLabor Cost: " + area * newSqFtLabor + "\nTax: " + (area * newSqFtLabor + area * newSqFtCost) * newTaxRate / 100
                + "\nTotal: " + ((area * newSqFtLabor + area * newSqFtCost) + (newTaxRate * (area * newSqFtLabor + area * newSqFtCost)) / 100));

        addConfirm(dateString, custName, state, newTaxRate,
                prodType, area, newSqFtCost, newSqFtLabor);

    }

    private void editOrder() {

        if (list.getDatelist().isEmpty()) {

            io.write("Your current date list is empty, please add orders first.\n");
            return;

        }

        String dateString = getDate();
        ArrayList<String[]> dt = sto.read("DataTaxes.txt");
        ArrayList<String[]> dp = sto.read("DataProducts.txt");
        String orderNumber;
        String state = " ";
        String prodType = " ";
        double newTaxRate = 0;
        double newSqFtCost = 0;
        double newSqFtLabor = 0;
        boolean validState = false;
        boolean validProduction = false;

        do {

            orderNumber = "" + io.readInteger("Please enter order number", 1, list.newOrderNum() - 1);

            if (list.findOrderString(dateString, orderNumber) != null) {

                io.write(list.findOrderString(dateString, orderNumber));
                String custName = io.readString("\nEnter name: ");
                String[] info = validStateRate_Edit(validState, orderNumber, state, dt);

                state = info[0];
                newTaxRate = Double.parseDouble(info[1]);
                String[] sqFtCosts = validProductionCosts_Edit(validProduction, orderNumber, prodType, dp);

                prodType = sqFtCosts[0];
                newSqFtCost = Double.parseDouble(sqFtCosts[1]);
                newSqFtLabor = Double.parseDouble(sqFtCosts[2]);
                String tempArea = io.readString("Enter area: ");

                if (editConfirm(dateString, orderNumber, custName, state, newTaxRate, prodType, tempArea, newSqFtCost, newSqFtLabor)) {

                    return;

                }

            } else {

                io.write("Error. Please enter valid information.");

                if (io.readInteger("Try again? [1. yes / 2. no]", 1, 2) == 2) {

                    return;

                }
            }

        } while (list.findOrderString(dateString, orderNumber) == null);

    }

    private void removeOrder() {

        String dateString;
        String orderNumber;

        if (list.getDatelist().isEmpty()) {

            io.write("Your current date list is empty, please add orders first.\n");
            return;

        }

        do {

            dateString = getDate();
            orderNumber = "" + io.readInteger("Please enter order number", 1, list.newOrderNum() - 1);

            if (!removeConfirm(dateString, orderNumber)) {
                return;
            }

        } while (list.findOrderString(dateString, orderNumber) == null);

    }

    private void save() {

        if (!testMode) {

            Set<String> keys = list.getKeys();

            for (String k : keys) {

                boolean hasDate = false;
                ArrayList<String[]> tempAL = new ArrayList<>();
                ArrayList<String[]> dateAL = new ArrayList<>();

                for (int i = 0; i < list.getDatelist().get(k).size(); i++) {

                    String temp = "";
                    temp += list.getDatelist().get(k).get(i).getOrderNumber() + ",";
                    temp += list.getDatelist().get(k).get(i).getCustName() + ",";
                    temp += list.getDatelist().get(k).get(i).getState() + ",";
                    temp += list.getDatelist().get(k).get(i).getTaxRate() + ",";
                    temp += list.getDatelist().get(k).get(i).getProdType() + ",";
                    temp += list.getDatelist().get(k).get(i).getArea() + ",";
                    temp += list.getDatelist().get(k).get(i).getSqFtCost() + ",";
                    temp += list.getDatelist().get(k).get(i).getSqFtLabor() + ",";
                    temp += list.getDatelist().get(k).get(i).getMatCost() + ",";
                    temp += list.getDatelist().get(k).get(i).getLaborCost() + ",";
                    temp += list.getDatelist().get(k).get(i).getTax() + ",";
                    temp += list.getDatelist().get(k).get(i).getTotal();

                    String[] tempArr = temp.split(",");
                    String[] dateArr = {k};
                    tempAL.add(tempArr);
                    dateAL.add(dateArr);

                    if (dateAL.get(i)[0].equals(k)) {

                        hasDate = true;

                    }
                }
                if (!hasDate) {

                    sto.write("Dates.txt", dateAL);

                }

                sto.write("Orders_" + k, tempAL);
            }
        } else {

            io.write("Test Mode Enabled. Save functionality disabled.");

        }

    }

    private void load() {

        ArrayList<String[]> dt = sto.read("DataTaxes.txt");
        ArrayList<String[]> dp = sto.read("DataProducts.txt");
        ArrayList<String[]> dl = sto.read("Dates.txt");
        this.testMode = sto.read("Config.txt").get(0)[0].split("=")[1].equals("1");

        for (int i = 0; i < dl.size(); i++) {

            double newTaxRate = 0;
            double newSqFtCost = 0;
            double newSqFtLabor = 0;
            ArrayList<String[]> read = sto.read("Orders_" + dl.get(i)[0]);

            for (int j = 0; j < read.size(); j++) {

                for (int k = 0; k < dt.size(); k++) {

                    if (dt.get(k)[0].equals(read.get(j)[2])) {

                        newTaxRate = Double.parseDouble(dt.get(k)[1]);
                    }

                }

                for (int k = 0; k < dt.size(); k++) {

                    if (dp.get(k)[0].equals(read.get(j)[4])) {

                        newSqFtCost = Double.parseDouble(dp.get(k)[1]);
                        newSqFtLabor = Double.parseDouble(dp.get(k)[2]);
                    }

                }

                if (!list.getDatelist().containsKey(dl.get(i)[0])) {

                    list.addOrderList(dl.get(i)[0]);

                }

                list.addOrder(read.get(j)[0], dl.get(i)[0], read.get(j)[1], read.get(j)[2],
                        newTaxRate, read.get(j)[4], Double.parseDouble(read.get(j)[5]),
                        newSqFtCost, newSqFtLabor);

            }

        }
    }

    private String getDate() {

        int month = io.readInteger("Enter order Month: [mm]", 1, 12);
        int day;

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {

            day = io.readInteger("Enter order Day: [dd]", 1, 31);

        } else if (month == 2) {

            day = io.readInteger("Enter order Day: [dd]", 1, 28);

        } else {

            day = io.readInteger("Enter order Day: [dd]", 1, 30);

        }

        return "" + month + day + io.readInteger("Enter order Year: [yyyy]", date.getYear() + 1900, date.getYear() + 1901);
    }

    private String[] validStateRate(boolean validState, String state, ArrayList<String[]> dt) {
        String[] temp = new String[2];
        double newTaxRate = 0;
        while (!validState) {

            state = io.readString("Enter State: ");
            temp[0] = state;

            for (int k = 0; k < dt.size(); k++) {

                if (dt.get(k)[0].equals(state)) {

                    newTaxRate = Double.parseDouble(dt.get(k)[1]);
                    validState = true;
                }

            }
            if (!validState) {

                String tempStr = " [ ";

                for (int i = 0; i < dt.size(); i++) {

                    tempStr += dt.get(i)[0] + " ";

                }

                tempStr += "]";
                io.write("Please enter a valid state." + tempStr + "\n");
            }
        }
        temp[1] = newTaxRate + "";
        return temp;
    }

    private String[] validStateRate_Edit(boolean validState, String orderNumber, String state, ArrayList<String[]> dt) {
        String[] temp = new String[2];
        double newTaxRate = 0;

        while (!validState && !state.equals("")) {

            state = io.readString("Enter State: ");
            temp[0] = state;
            for (int k = 0; k < dt.size(); k++) {

                if (dt.get(k)[0].equals(state)) {

                    newTaxRate = Double.parseDouble(dt.get(k)[1]);
                    validState = true;

                }

            }

            if (!validState && !state.equals("")) {

                String tempStr = " [ ";

                for (int i = 0; i < dt.size(); i++) {

                    tempStr += dt.get(i)[0] + " ";

                }

                tempStr += "]";
                io.write("Please enter a valid state." + tempStr + "\n");

            }
        }

        if (!validState) {

            newTaxRate = list.findOrder(orderNumber).getTaxRate();

        }

        temp[1] = newTaxRate + "";
        return temp;

    }

    private String[] validProductionCosts(boolean validProduction, String prodType, ArrayList<String[]> dp) {

        String[] sqFtCosts = new String[3];

        while (!validProduction && !prodType.equals("")) {

            prodType = io.readString("Enter product type: ");
            sqFtCosts[0] = prodType;
            for (int k = 0; k < dp.size(); k++) {

                if (dp.get(k)[0].equals(prodType)) {

                    sqFtCosts[1] = dp.get(k)[1];
                    sqFtCosts[2] = dp.get(k)[2];
                    validProduction = true;

                }

            }

            if (!validProduction && !prodType.equals("")) {

                String temp = " [ ";

                for (int i = 0; i < dp.size(); i++) {

                    temp += "|" + dp.get(i)[0] + "|" + " ";

                }

                temp += "]";
                io.write("Please enter a valid type." + temp + "\n");
            }
        }

        return sqFtCosts;

    }

    private String[] validProductionCosts_Edit(boolean validProduction, String orderNumber, String prodType, ArrayList<String[]> dp) {

        String[] sqFtCosts = new String[3];
        
        while (!validProduction) {

            prodType = io.readString("Enter product type: ");
            sqFtCosts[0] = prodType;
            for (int k = 0; k < dp.size(); k++) {

                if (dp.get(k)[0].equals(prodType)) {

                    sqFtCosts[1] = dp.get(k)[1];
                    sqFtCosts[2] = dp.get(k)[2];
                    validProduction = true;

                    return sqFtCosts;
                }

            }
            if (!validProduction) {

                String temp = " [ ";

                for (int i = 0; i < dp.size(); i++) {

                    temp += "|" + dp.get(i)[0] + "|" + " ";

                }

                temp += "]";
                io.write("Please enter a valid type." + temp + "\n");
            }

            if (!validProduction) {

                sqFtCosts[0] = "" + list.findOrder(orderNumber).getSqFtCost();
                sqFtCosts[1] = "" + list.findOrder(orderNumber).getSqFtCost();

            }
        }

        return sqFtCosts;

    }

    private void addConfirm(String dateString, String custName, String state, double newTaxRate,
            String prodType, double area, double newSqFtCost, double newSqFtLabor) {

        if (list.dateExists(dateString)) {

            if (io.readInteger("\nCommit? [ 1. yes / 2. no]", 1, 2) == 1) {

                list.addOrder(dateString, custName, state, newTaxRate,
                        prodType, area, newSqFtCost, newSqFtLabor);

            }
        } else {

            if (io.readInteger("\nCommit? [1. yes / 2. no]", 1, 2) == 1) {

                list.addOrderList(dateString);
                list.addOrder(dateString, custName, state, newTaxRate,
                        prodType, area, newSqFtCost, newSqFtLabor);

            }

        }
    }

    private boolean removeConfirm(String dateString, String orderNumber) {

        if (list.findOrderString(dateString, orderNumber) != null) {

            io.write(list.findOrderString(dateString, orderNumber));

            if (io.readInteger("Confirm Remove? [1. yes / 2. no]", 1, 2) == 1) {

                list.removeOrder(dateString, orderNumber);

            }
        } else if (list.findOrderString(dateString, orderNumber) == null) {

            io.write("Error. Please enter valid information.");

            if (io.readInteger("Try again? [1. yes / 2. no]", 1, 2) == 2) {

                return true;

            }

        }
        return false;

    }

    private boolean editConfirm(String dateString, String orderNumber, String custName, String state, double newTaxRate, String prodType, String tempArea, double newSqFtCost, double newSqFtLabor) {

        if (io.readInteger("Confirm Edit? [1. yes / 2. no]", 1, 2) == 1) {

            list.editOrder(dateString, orderNumber, custName, state, "" + newTaxRate, prodType, tempArea, "" + newSqFtCost, "" + newSqFtLabor);

        } else if (list.findOrderString(dateString, orderNumber) == null) {

            io.write("Error. Please enter valid information.");

            if (io.readInteger("Try again? [1. yes / 2. no]", 1, 2) == 2) {

                return true;

            }
        }
        return false;

    }

    private boolean quit() {

        int userInput = io.readInteger("\nConfirm Quit? [1. Yes / 2. No]", 1, 2);

        if (userInput == 1) {

            save();
            return true;

        }
        if (userInput == 2) {

            return false;

        }

        return false;

    }
}
