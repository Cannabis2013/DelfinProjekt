package UI;

import java.util.Scanner;

public class FormandUI extends UI {

    public void displayUI_formand() throws InterruptedException {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("");
        System.out.println("---------------------");
        System.out.println("[ DELFIN - DATABASE ]");
        System.out.println("---------------------");
        System.out.println("");

        Thread.sleep(2000);

        System.out.println("""                                      
                -----------------
                Formand - System:
                -----------------
                                    
                1). Indmeld nye medlemmer:
                                    
                2). Oversigt af registeret medlemmer:
                                    
                3). Registere - Ændre / Fjern medlemmer:
                
                ---------------------------------------
                                    
                4). Hent medlemmer til databasen:       ( Fra en vilkårlig CSV fil )
                
                5). Gemme medlemmer til databasen:      ( Fra den hentet CSV fil )
                                    
                ---------------------------------------
                
                6). Tilbage til Hovedmenu:
                
                7). Sluk - System:
                """);

        System.out.println("--------------------------------------");
        System.out.println("Vælg et af følgende tal - Tryk Enter. ");
        System.out.println("--------------------------------------");
        System.out.print("[Indtast her]: ");


        int commandFormand = keyboard.nextInt();


        while (running) {

            switch (commandFormand) {


                case 1:


                    break;



                case 2:
                    System.out.println("Test 2_Formand");


                    break;



                case 3:
                    System.out.println("Test 3_Formand");


                    break;




                case 4:
                    System.out.println("Test 4_Formand");


                    break;



                case 5:
                    System.out.println("Test 5_Formand");


                    break;



                case 6:

                    displayUI_delfin();


                    break;



                case 7:
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

                        displayUI_formand();



                    } else {

                        System.out.println("""
                            
                            ------------------------------
                            Du tastet forkert - Prøv igen.
                            ------------------------------
                            
                            """);

                        Thread.sleep(1500);


                    }



                    break;






            } // End of formand switch

        } // End of formand while loop


    } // End of formand displayUI_Formand


} // End of formand FormandUI
