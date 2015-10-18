/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO implements ConsoleInterface{

    Scanner kb = new Scanner(System.in);

    @Override
    public int readInteger(String p) {
        boolean failed;
        int ret = 0;
        do {
            failed = false;
            System.out.println(p);
            kb.nextLine();
            try {
                ret = kb.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    @Override
    public int readInteger(String p, int min, int max) {
        boolean failed;
        int ret = 0;
        do {
            failed = false;
            System.out.println(p);
            try {
                ret = kb.nextInt();
                kb.nextLine();
                if (ret < min || ret > max) {
                    System.out.println("Value must be between " + min
                            + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer.");
                failed = true;
                kb.nextLine();
            }
        } while (failed || ret < min || ret > max);

        return ret;

    }

    @Override
    public int readInteger(String p, int min, int max, int exception) {
        boolean failed;
        int ret = 0;
        do {
            failed = false;
            System.out.println(p);
            try {
                ret = kb.nextInt();
                kb.nextLine();
                if (ret < min || ret > max&&ret!=exception) {
                    System.out.println("Value must be between " + min
                            + " and " + max + " or be: "+exception);
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be an integer.");
                failed = true;
                kb.nextLine();
            }
        } while (failed || ret < min || ret > max&&ret!=exception);

        return ret;

    }

    @Override
    public String readString(String p) {
        System.out.println(p);
        return kb.nextLine();
    }

    @Override
    public float readFloat(String p) {
        boolean failed;
        float ret = 0;
        do {
            failed = false;
            System.out.println(p);
            try {
                ret = kb.nextFloat();
                kb.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    @Override
    public float readFloat(String p, float min, float max) {
        boolean failed;
        float ret = 0;
        do {
            failed = false;
            System.out.println(p);
            try {
                ret = kb.nextFloat();
                kb.nextLine();
                if (ret < min || ret > max) {
                    System.out.println("Value must be between " + min
                            + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                failed = true;
                kb.nextLine();

            }
        } while (failed || ret < min || ret > max);

        return ret;
    }

    @Override
    public double readDouble(String p) {
        boolean failed;
        double ret = 0;
        do {
            failed = false;
            System.out.println(p);
            try {
                ret = kb.nextDouble();
                kb.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");
                failed = true;
                kb.nextLine();
            }
        } while (failed);
        return ret;
    }

    @Override
    public double readDouble(String p, double min, double max) {
        boolean failed;
        double ret = 0;
        do {
            failed = false;
            System.out.println(p);
            try {
                ret = kb.nextDouble();
                kb.nextLine();
                if (ret < min || ret > max) {
                    System.out.println("Value must be between " + min
                            + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be a number.");

                failed = true;
                kb.nextLine();
            }
        } while (failed || ret < min || ret > max);

        return ret;
    }
    /* public Address readAddress(){
     Address temp = new Address(readString("Please Enter First Name: \n"),
     readString("Please Enter Last Name: \n"),
     readString("Please Enter Street Address: \n"),
     readString("Please Enter City: \n"),
     readString("Please Enter State: \n"),
     readString("Please Enter Zip: \n"));
     return temp;
    
     }*/

    @Override
    public void write(String p) {
        System.out.print(p);
    }

   /* public boolean PinLockout(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        int pin = 12345;
        int tries = 0;

        System.out.println(prompt);
        int entry = keyboard.nextInt();
        tries++;

        while (entry != pin && tries < 3) {
            System.out.println("\nINCORRECT PIN. TRY AGAIN.");
            System.out.print("ENTER YOUR PIN: ");
            entry = keyboard.nextInt();
            tries++;
        }

        if (entry == pin) {
            System.out.println("\nPIN ACCEPTED. YOU NOW HAVE ACCESS TO YOUR ACCOUNT.");
            return true;
        } else if (tries >= 3) {
            System.out.println("\nYOU HAVE RUN OUT OF TRIES. ACCOUNT LOCKED.");
            return false;
        }
        return false;
    }
*/
}
