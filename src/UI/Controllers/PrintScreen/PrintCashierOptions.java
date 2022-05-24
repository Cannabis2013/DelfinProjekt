package UI.Controllers.PrintScreen;

import UI.Contracts.PrintScreen;

public class PrintCashierOptions implements PrintScreen {


    @Override
    public void print() {

        System.out.println("""
                           
                -----------------
                Cashier - System:
                -----------------
                                
                1). Expected Income
                                
                2). Overview Restance Members
                
                3). Register payment                
                -------------------------------------
                  
                4). Back to Main Menu

                """);





}
}
