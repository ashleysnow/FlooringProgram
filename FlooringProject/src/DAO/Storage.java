/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Storage  implements StorageInterface{

    @Override
    public ArrayList<String[]> read(String fileName){
        try {
            Scanner file = new Scanner(new BufferedReader(new FileReader("Data/"+fileName)));
            ArrayList<String[]> temp = new ArrayList<>();
            String[] splitLine;
            while (file.hasNextLine()) {

                String line = file.nextLine();
                splitLine = line.split(",");
                temp.add(splitLine);

            }

            file.close();
            return temp;

        } catch (FileNotFoundException e) {
            System.out.println("File Read Failed: " + e.getMessage());
            return new ArrayList<String[]>();
        }

    }

    @Override
    public void write(String fileName, ArrayList<String[]> temp) {
//                      "dates.txt    ,  dateAL
        try {

            PrintWriter out = new PrintWriter(new FileWriter("Data/"+fileName));
            for (int i = 0; i < temp.size(); i++) {

                for (int j = 0; j < temp.get(i).length; j++) {

                    if (j < temp.get(i).length - 1) {
                        out.print(temp.get(i)[j] + ",");
                        
                    } else {
                        out.print(temp.get(i)[j]);
                        
                    }

                }
                out.println();

            }
            out.flush();
            out.close();

        } catch (IOException e) {
            System.out.println("File Write Failed: " + e.getMessage());

        }

    }


}
