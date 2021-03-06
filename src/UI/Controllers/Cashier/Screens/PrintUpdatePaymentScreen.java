package UI.Controllers.Cashier.Screens;

import Backend.Contracts.BackendDomain;
import Backend.Members.MemberManager.MemberNotFoundException;
import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.ID.ReadID;
import UI.Controllers.ConsoleUtils.PrintBlankScreen;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;

public class PrintUpdatePaymentScreen implements PrintScreen {
    private ReadUserInput<String> _readInput = new ReadID();
    private PrintScreen _printBlankScreen = new PrintBlankScreen();
    private ReadUserInput<String> _haltScreen = new ConsoleHaltForInput();
    @Override
    public void print(BackendDomain domain) {
        String enteredId = "";

        while (true) {
            try {
                domain.registerPayment(enteredId);
                _printBlankScreen.print(null);
                System.out.println(String.format("""
                        -----------------------------------
                        Payment status updated for ID: %s
                        -----------------------------------
                        """, enteredId));
                _haltScreen.read();
                _printBlankScreen.print(null);
                break;
            } catch (MemberNotFoundException e) {
                _printBlankScreen.print(null);
                if (enteredId.equals("EXIT")) break;
                System.out.println("Enter EXIT to escape");
                System.out.print("Enter a MemberID: ");
                enteredId = _readInput.read();
            }
        }

    }

}
