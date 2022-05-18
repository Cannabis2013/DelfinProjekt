package UI.PrintScreen;

import UI.Contracts.PrintScreen;

public class PrintMainOptions implements PrintScreen {
    @Override
    public void print() {
        System.out.println("""
                    ------------
                    Who are you?
                    ------------
                    
                    1). Chairman
                    
                    2). Cashier
                    
                    3). Trainer
                    
                    4). Exit
                    
                    """);
    }
}
