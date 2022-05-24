package UI.Controllers.RegisterMemberDetails.ContactInformation;

import Backend.Contracts.BackendDomain;
import UI.Contracts.ReadUserInput;
import UI.Controllers.RegisterMemberDetails.ContactInformation.Mail.InvalidMailFormatException;
import UI.Controllers.RegisterMemberDetails.ContactInformation.Mail.ReadMail;
import UI.Controllers.RegisterMemberDetails.ContactInformation.Phone.InvalidPhoneFormatException;
import UI.Controllers.RegisterMemberDetails.ContactInformation.Phone.ReadDanishPhoneNumber;
import UI.Controllers.ReadUserInput.ConsoleHaltForInput;
import UI.Controllers.RegisterMemberDetails.ContactInformation.Address.InvalidAddressFormatException;
import UI.Controllers.RegisterMemberDetails.ContactInformation.Address.ReadDanishAddress;

public class RegisterContactInformation {
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
        System.out.print("Enter address: ");;
        String address;
        try {
            address = _readAddress.read();
        } catch (InvalidAddressFormatException e){
            clearLine();
            return "No address. Probably homeless.";
        }
        clearLine();
        return address;
    }

    public String register(BackendDomain domain, String id){
        var phone = readPhone();
        var mail = readMail();
        var address = readAddress();
        domain.registerContactDetails(id,phone,mail,address);
        return id;
    }
}
