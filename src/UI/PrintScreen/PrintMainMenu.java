package UI.PrintScreen;

import UI.Contracts.PrintScreen;

public class PrintMainMenu implements PrintScreen {
    @Override
    public void print() {
        System.out.println("""
                    ----------
                    Main Menu:
                    ----------
                    
                    1). Chairman - System:
                    
                    2). Cashier - System:
                    
                    3). Trainer - System:
                    
                    4). Exit - System:
                    
                    """);
    }
}
