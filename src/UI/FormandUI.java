package UI;

import UI.Contracts.ReadUserInput;
import UI.ReadUserInput.ReadMainMenuOption;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class FormandUI extends UI {
    private ReadUserInput<Integer> _readMainMenuOption = new ReadMainMenuOption();

    private void registerMember() throws InterruptedException {
        var keyboard = new Scanner(System.in);
        System.out.print("""
            
            Enter Name: """);
        String nameEntered = keyboard.nextLine();

        System.out.println("""
            (Enter like this = year-month-day)
            Enter Date of Birth: """);
        String birthdayEntered = keyboard.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthday = LocalDate.parse(birthdayEntered, formatter);

        System.out.print("""
            
            Enter Subscription Status -- Active or Passive: """);
        Boolean subStatusEntered = Boolean.valueOf(keyboard.nextLine().toLowerCase(Locale.ROOT));
        if (subStatusEntered.equals("active")) {
            subStatusEntered = true;

        } else if (subStatusEntered.equals("passive")) {
            subStatusEntered = false;
        }

        System.out.print("""
            ( Enter like this = BREAST / CRAWL )
            Enter Disciplines: """);

        String disciplinesEntered = keyboard.nextLine();
        disciplinesEntered.split(" |,|, ");

        _backend.registerMember(nameEntered, birthdayEntered, subStatusEntered, disciplinesEntered);

        displayUI_formand();
    }

    private void overviewMembers(){


    }

    public void displayUI_formand() throws InterruptedException {
        System.out.println("");
        System.out.println("---------------------");
        System.out.println("[ DELFIN - DATABASE ]");
        System.out.println("---------------------");
        System.out.println("");

        System.out.println("""                                      
                -----------------
                Chairman - System:
                -----------------
                                    
                1). Create New Member:
                                    
                2). Overview Registered Members:
                                    
                3). Register - Modify / Delete Member:
                                
                ---------------------------------------
                                    
                4). Load Members from Database:      ( From a CSV file )
                                
                5). Save Members from Database:      ( From the loaded CSV file )
                                    
                ---------------------------------------
                                
                6). Back to Main Menu:
                                
                7). Exit - System:
                """);
        int commandFormand = _readMainMenuOption.read();
        while (running) {

            switch (commandFormand) {


                case 1 -> registerMember();

                case 2 -> System.out.println("Test 2_Formand");

                case 3 -> System.out.println("Test 3_Formand");

                case 4 -> System.out.println("Test 4_Formand");

                case 5 -> System.out.println("Test 5_Formand");

                case 6 -> displayUI_delfin();

                case 7 -> {
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

                } // End of formand switch

            } // End of formand while loop

        } // End of formand displayUI_Formand

    } // End of formand FormandUI

}