package UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.Mail;

import UI.Contracts.ReadUserInput;

import java.util.Scanner;

public class ReadMail implements ReadUserInput<String> {
    private final String REGEX = "[A-z.\\d]+@\\w+.\\w+";

    @Override
    public String read() {
        var mail = new Scanner(System.in).nextLine();
        if(mail.matches(REGEX))
            return mail;
        throw new InvalidMailFormatException();
    }
}
