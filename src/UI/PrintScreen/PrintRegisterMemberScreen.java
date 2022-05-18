package UI.PrintScreen;

import UI.Contracts.PrintScreen;

public class PrintRegisterMemberScreen implements PrintScreen {
    private void printMessage(){
        var msg = """
                Dolphin user registration.
                * Please use full name
                * Please enter date in format YYYY-dd-mm (Ex. 1985-04-02)
                * As a competitor, please type in desired disciplines separated by slash
                """;
        System.out.println(msg);
    }

    @Override
    public void print() {
        printMessage();
    }
}
