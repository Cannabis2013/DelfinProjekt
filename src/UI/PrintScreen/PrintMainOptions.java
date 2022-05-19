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
                    
                    2). Print members in arrears
                    
                    3). Trainer
                    
                    *). Exit
                    
                    """);
    }
}
