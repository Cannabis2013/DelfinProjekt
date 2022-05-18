package UI.PrintScreen;

import UI.Contracts.PrintScreen;

public class PrintDolphinWelcomeScreen implements PrintScreen {
    PrintScreen _printBlank = new PrintBlankScreen();
    @Override
    public void print() {
        _printBlank.print();
        System.out.println("");
        System.out.println("---------------------");
        System.out.println("[ DELFIN - DATABASE ]");
        System.out.println("---------------------");
        System.out.println("");
    }
}
