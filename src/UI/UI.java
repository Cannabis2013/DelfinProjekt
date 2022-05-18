package UI;

import Backend.Contracts.BackendDomain;
import Backend.DolphinDomain;

import java.util.Locale;
import java.util.Scanner;



public class UI {

    protected BackendDomain _backend = new DolphinDomain();

    Scanner keyboard = new Scanner(System.in);

    boolean running = true;

    public void displayUI_delfin() throws InterruptedException {

        System.out.println("");
        System.out.println("---------------------");
        System.out.println("[ DELFIN - DATABASE ]");
        System.out.println("---------------------");
        System.out.println("");

        System.out.println("""
                    ----------
                    Main Menu:
                    ----------
                    
                    1). Chairman - System:
                    
                    2). Cashier - System:
                    
                    3). Trainer - System:
                    
                    4). Exit - System:
                    
                    """);

        System.out.print("""
                            -----------------------------
                            Choose a Number & Press Enter
                            -----------------------------
                            
                            [Enter here]: """);

        int commandMenu = keyboard.nextInt();


        while(running) {

            switch (commandMenu) {
                case 1 -> new FormandUI().displayUI_formand();
                case 2 -> System.out.println("Test 2");
                case 3 -> System.out.println("Test 3");
                case 4 -> {
                    Scanner keyboardEnd = new Scanner(System.in);
                    System.out.print("""
                                                        
                            ----------------------------------------
                            Are you sure, you want to exit - Yes/No?
                            ---------------------------------------- """);
                    System.out.println("[Enter here]: ");
                    String commandEnd = keyboardEnd.nextLine().toLowerCase(Locale.ROOT);
                    if (commandEnd.equals("yes") || commandEnd.equals("y") ) {

                        System.out.println("""
                                                                
                                ------------------                                
                                Exiting Program.
                                ------------------
                                                                
                                ----------------
                                Have a good day.
                                ----------------
                                                                
                                """);
                        Thread.sleep(1500);

                        System.exit(0);


                    } else if (commandEnd.equals("nej") || commandEnd.equals("n")) {

                        displayUI_delfin();


                    } else {

                        System.out.println("""
                                                            
                                -----------------------------
                                Invalid Command - Try again.
                                -----------------------------
                                                            
                                """);
                        Thread.sleep(1500);


                    }
                }
                case 5 -> {
                    System.out.println("");
                    System.out.println("----------------------");
                    System.out.println("Implement - Kommer en anden dag...");
                    System.out.println("----------------------");
                    System.out.println("");
                    Thread.sleep(1500);
                    displayUI_delfin();
                }
                default -> {
                    System.out.println("""
                                                        
                            -----------------------------
                            Invalid Command - Try again.
                            -----------------------------
                                                        
                            """);
                    Thread.sleep(1500);
                    displayUI_delfin();
                }
            }  // End of hoved switch

        } // End of while loop.

    } // End of UI class.
}
