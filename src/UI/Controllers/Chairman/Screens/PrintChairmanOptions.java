package UI.Controllers.Chairman.Screens;

import UI.Contracts.PrintScreen;

public class PrintChairmanOptions implements PrintScreen {
    @Override
    public void print() {
        System.out.println("""                                      
                -----------------
                Chairman - System:
                -----------------
                                    
                1). Create New Member:
                2). Back to Main Menu:
                """);
    }
}
