package MemberManagement.Persistence;


import java.io.PrintStream;

public interface Persistable {
    void saveScheme(PrintStream stream);
}
