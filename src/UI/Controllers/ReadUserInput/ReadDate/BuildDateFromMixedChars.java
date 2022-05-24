package UI.Controllers.ReadUserInput.ReadDate;

import java.time.LocalDate;
import java.util.Scanner;

/*
    This class takes into account for danish and english month naming.
    That means only the minimum number of letters that danish and english
    months has in common is matched, except for March and May.

 */

public class BuildDateFromMixedChars {
    private int monthAsDigit(String month){
        var monthLowered = month.toLowerCase();
        if(monthLowered.startsWith("jan"))
            return 1;
        else if(monthLowered.startsWith("feb"))
            return 2;
        else if(monthLowered.startsWith("mar"))
            return 3;
        else if(monthLowered.startsWith("apr"))
            return 4;
        else if(monthLowered.startsWith("may") || monthLowered.startsWith("maj"))
            return 5;
        else if(monthLowered.startsWith("jun"))
            return 6;
        else if(monthLowered.startsWith("jul"))
            return 7;
        else if(monthLowered.startsWith("aug"))
            return 8;
        else if(monthLowered.startsWith("sep"))
            return 9;
        else if(monthLowered.startsWith("oct") || monthLowered.startsWith("okt"))
            return 10;
        else if(monthLowered.startsWith("nov"))
            return 11;
        else if(monthLowered.startsWith("dec"))
            return 12;
        else
            throw new InvalidDateException();
    }

    public LocalDate build(String str){
        var reader = new Scanner(str).useDelimiter(" ");
        var day = reader.nextInt();
        var month = monthAsDigit(reader.next());
        var year = reader.nextInt();
        return LocalDate.of(year,month,day);
    }
}
