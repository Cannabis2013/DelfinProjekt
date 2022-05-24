package UI.Controllers.Chairman.Screens;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;

public class PrintChairmanOptions implements PrintScreen {
    @Override
    public void print(BackendDomain domain) {
        System.out.println("""                                      
                -----------------
                Chairman - System:
                -----------------
                                    
                1). Create New Member:
                2). Back to Main Menu:
                """);
    }
}
