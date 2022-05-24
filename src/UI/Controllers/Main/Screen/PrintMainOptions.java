package UI.Controllers.Main.Screen;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreen;

public class PrintMainOptions implements PrintScreen {
    @Override
    public void print(BackendDomain domain) {
        System.out.println("""
                    ------------
                    Who are you?
                    ------------
                    
                    1). Chairman
                    
                    2). Cashier
                    
                    3). Trainer
                    
                    4). Print members
                    
                    *). Exit
                    
                    """);
    }
}
