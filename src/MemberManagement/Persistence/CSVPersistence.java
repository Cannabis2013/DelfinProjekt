package MemberManagement.Persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVPersistence implements iCSVPersistence {


    @Override
    public void save(Manager manager) throws FileNotFoundException {
        PrintStream stream = new PrintStream(manager.file_path());
        manager.printThroughStream(stream);
        stream.close();
    }

    @Override
    public List<Object> load(Manager manager) throws FileNotFoundException {
        File file = new File(manager.file_path());
        List<Object> objects = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line).useDelimiter(";");
            objects.add(manager.loadSchema(lineScanner));
        }
        return objects;
    }

}
