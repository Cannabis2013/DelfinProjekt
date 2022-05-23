package UI.PrintScreen;

import UI.Contracts.PrintScreen;
import UI.Contracts.ReadUserInput;
import UI.Models.MemberDetails;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ClearScrollBuffer implements PrintScreen {
    @Override
    public void print() {
        System.out.print("\33[3J");
    }
}
