package UI;

import Backend.BackendDomain;

import java.util.Scanner;



public class UI {

    private BackendDomain _backend;
    Scanner keyboard = new Scanner(System.in);

    boolean running = true;

    // Variabler:

/*
    public void displayUI_intro() throws InterruptedException {

        System.out.println("");
        System.out.println("---------------------");
        System.out.println("[ DELFIN - DATABASE ]");
        System.out.println("---------------------");
        System.out.println("");


        Thread.sleep(3000);


    }
*/

    public void displayUI_delfin() throws InterruptedException {

        System.out.println("");
        System.out.println("---------------------");
        System.out.println("[ DELFIN - DATABASE ]");
        System.out.println("---------------------");
        System.out.println("");
        
        Thread.sleep(2000);

        System.out.println("""
                    ----------
                    Hovedmenu:
                    ----------
                    
                    1). Formand - System:
                    
                    2). Kasserer - System:
                    
                    3). Træner - System:
                    
                    4). Sluk - System:
                    
                    ---------------------
                    5). Sprog / Language:
                    """);

        System.out.println("--------------------------------------");
        System.out.println("Vælg et af følgende tal - Tryk Enter. ");
        System.out.println("--------------------------------------");
        System.out.print("[Indtast her]: ");


        int commandMenu = keyboard.nextInt();


        while(running) {

            switch (commandMenu) {
                case 1 -> new FormandUI().displayUI_formand();
                case 2 -> System.out.println("Test 2");
                case 3 -> System.out.println("Test 3");
                case 4 -> {
                    Scanner keyboardEnd = new Scanner(System.in);
                    System.out.println("""
                                                        
                            ----------------------------------------------
                            Er du sikker på at slukke systemet - ja/nej ??
                            ---------------------------------------------- """);
                    System.out.print("[Indtast her]: ");
                    String commandEnd = keyboardEnd.nextLine();
                    if (commandEnd.equals("ja") || commandEnd.equals("Ja") || commandEnd.equals("j") || commandEnd.equals("J")) {

                        System.out.println("""
                                                                
                                                                
                                Sluk systemet:
                                -------------
                                                                
                                ----------------------------------------
                                Systemet slukkes - Har en god svømmedag.
                                -----------------------------------------
                                                                
                                """);
                        Thread.sleep(1500);

                        System.exit(0);


                    } else if (commandEnd.equals("nej") || commandEnd.equals("Nej") || commandEnd.equals("n") || commandEnd.equals("N")) {

                        displayUI_delfin();


                    } else {

                        System.out.println("""
                                                            
                                ------------------------------
                                Du tastet forkert - Prøv igen.
                                ------------------------------
                                                            
                                """);

                        Thread.sleep(1500);


                    }
                }
                case 5 -> {
                    System.out.println("");
                    System.out.println("----------------------");
                    System.out.println("Kommer en anden dag...");
                    System.out.println("----------------------");
                    System.out.println("");
                    Thread.sleep(1500);
                    displayUI_delfin();
                }
                default -> {
                    System.out.println("""
                                                        
                            ------------------------------
                            Du tastet forkert - Prøv igen.
                            ------------------------------
                                                        
                            """);
                    Thread.sleep(1500);
                    displayUI_delfin();
                }
            }  // End of hoved switch

        } // End of while loop.

    } // End of UI class.
}
