package UI.PrintScreen;

import Backend.Contracts.BackendDomain;
import UI.Contracts.PrintScreenByDomain;

public class PrintRegisterPaymentScreen implements PrintScreenByDomain {

    private void printIntro(){
        var red = "\33[31m";
        var reset = "\33[m";
        var msg = """
                    ---------------------
                    Update payment status
                    ---------------------
                """;
        System.out.println(red + msg + reset);
    }

    @Override
    public void print(BackendDomain domain) {
    }
}
