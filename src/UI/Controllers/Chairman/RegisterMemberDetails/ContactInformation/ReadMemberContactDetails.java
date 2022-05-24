package UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation;

import UI.Contracts.ReadUserInput;
import UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.Address.InvalidAddressFormatException;
import UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.Address.ReadDanishAddress;
import UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.Mail.InvalidMailFormatException;
import UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.Mail.ReadMail;
import UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.Phone.InvalidPhoneFormatException;
import UI.Controllers.Chairman.RegisterMemberDetails.ContactInformation.Phone.ReadDanishPhoneNumber;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;

public class ReadMemberContactDetails {
    private ReadUserInput<String> _readPhone = new ReadDanishPhoneNumber();
    private ReadUserInput<String> _readMail = new ReadMail();
    private ReadUserInput<String> _readAddress = new ReadDanishAddress();
    private ReadUserInput<String> _halt = new ConsoleHaltForInput();

    private void clearLine(){
        System.out.print("\33[A");
        System.out.print("\33[2K");
    }

    public String readPhone(){
        System.out.print("Enter phone: ");
        String phone;
        try {
            phone = _readPhone.read();
        } catch (InvalidPhoneFormatException e){
            phone = null;
        }
        clearLine();
        return phone;
    }

    public String readMail(){
        var errLine = "";
        while (true){
            String mail;
            try {
                System.out.printf("Enter mail%s: ",errLine);
                mail = _readMail.read();
                clearLine();
                return mail;
            } catch (InvalidMailFormatException e){
                clearLine();
                errLine = "(Invalid mail format)";
            }
        }
    }

    public String readAddress(){
        var err = "";
        String address;
        while (true){
            try {
                System.out.printf("Enter address%s: ",err);
                address = _readAddress.read();
                clearLine();
                return address;
            } catch (InvalidAddressFormatException e){
                clearLine();
                err = "Invalid address format";
            }
        }
    }

    public ContactDetails register(){
        var phone = readPhone();
        var mail = readMail();
        var address = readAddress();
        return new ContactDetails(phone,mail,address);
    }
}
