package UI.PrintScreen;

import UI.Contracts.PrintScreen;

public class PrintChairmanOptions implements PrintScreen {
    @Override
    public void print() {
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
    }
}
