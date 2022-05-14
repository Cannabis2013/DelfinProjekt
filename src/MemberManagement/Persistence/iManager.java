package MemberManagement.Persistence;

import java.io.PrintStream;
import java.util.Scanner;

public interface iManager {
    String file_path();
    Object loadScheme(Scanner lineScanner);
    void save();
    void load();
}
