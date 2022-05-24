package UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.Phone;

import UI.Contracts.ReadUserInput;

import java.util.Scanner;

public class ReadDanishPhoneNumber implements ReadUserInput<String> {
    @Override
    public String read() {
        var phone = new Scanner(System.in).nextLine();
        if(phone.matches("\\d{8}") || phone.matches("\\+45\\d{8}"))
            return phone;
        throw new InvalidPhoneFormatException();
    }
}
