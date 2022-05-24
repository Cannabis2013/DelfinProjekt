package UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.Address;

import UI.Contracts.ReadUserInput;

import java.util.Scanner;

public class ReadDanishAddress implements ReadUserInput<String> {
    private final String AddressFormatA = "[A-zæøå ]+\\s*\\d+\\s*[\\d.A-z]*,\\s*\\d{4}\\w?\\s*\\w+";
    private final String AddressFormatB = "^[A-zæøå 0-9]+,\\s*[A-z. 0-9]+,\\s*\\w+$";

    @Override
    public String read() {
        var address = new Scanner(System.in).nextLine();
        if(address.matches(AddressFormatA) || address.matches(AddressFormatB))
            return address;
        throw new InvalidAddressFormatException();
    }
}
