package UI;

import java.util.Locale;
import java.util.Scanner;

public class FormandUI extends UI {

    Scanner keyboard = new Scanner(System.in);

    private void addMember() {

        System.out.println("""
                Type the full Name:
                """);
        System.out.print("Type here:");

        int enterMemberID = keyboard.nextInt();



    }

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
                Chairman - System:
                -----------------
                                    
                1). Create New Member:
                                    
                2). Overview Regitered Members:
                                    
                3). Register - Modify / Delete Member:
                
                ---------------------------------------
                                    
                4). Load Members from Database:       ( From a CSV file )
                
                5). Save Members from Database:      ( From the loaded CSV file )
                                    
                ---------------------------------------
                
                6). Back to Main Menu:
                
                7). Exit - System:
                """);

        System.out.println("--------------------------------------");
        System.out.println("Choose a Number & Press Enter. ");
        System.out.println("--------------------------------------");
        System.out.print("[Enter her]: ");


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
                            Are you sure that you want to exit? Yes/No?
                            ---------------------------------------------- """);
                    System.out.print("[Enter here]: ");


                    String commandEnd = keyboardEnd.nextLine().toLowerCase(Locale.ROOT);


                    if (commandEnd.equals("yes") || commandEnd.equals("y")) {

                        System.out.println("""
                                
                                ------------------
                                Exiting Program...
                                ------------------
                                                                
                                ----------------
                                Have a good day.
                                ----------------
                                
                                """);
                        Thread.sleep(1500);

                        System.exit(0);



                    } else if (commandEnd.equals("no") || commandEnd.equals("n")) {

                        displayUI_formand();



                    } else {

                        System.out.println("""
                            
                            -----------------------------
                            Invalid Command - Try again.
                            -----------------------------
                            
                            """);

                        Thread.sleep(1500);


                    }



                    break;






            } // End of formand switch

        } // End of formand while loop


    } // End of formand displayUI_Formand


} // End of formand FormandUI
