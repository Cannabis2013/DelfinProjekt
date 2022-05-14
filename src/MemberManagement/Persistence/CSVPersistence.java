package MemberManagement.Persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVPersistence implements iCSVPersistence {


    @Override
    public void save(String file_path, List objects) throws FileNotFoundException {
        File file = new File(file_path);
        if (file.exists() && !file.isDirectory()) {
            PrintStream stream = new PrintStream(file);
            objects.forEach(object -> {
                Persistable perObject = (Persistable) object;
                perObject.saveScheme(stream);
            });
        }
    }

    @Override
    public List<Object> load(iManager manager) throws FileNotFoundException {
        File file = new File(manager.file_path());
        List<Object> objects = new ArrayList<>();
        if (file.exists() && !file.isDirectory()) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line).useDelimiter(";");
                objects.add(manager.loadScheme(lineScanner));
            }
        }
        return objects;
    }

}
