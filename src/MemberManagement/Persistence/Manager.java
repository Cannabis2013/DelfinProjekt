package MemberManagement.Persistence;

import java.io.PrintStream;
import java.util.Scanner;

public interface Manager {
    String file_path();
    Persistable loadSchema(Scanner lineScanner);
    void printThroughStream(PrintStream stream);
    void csvSave();
    void csvLoad();
}
