package Backend.Persistence;

import Backend.Contracts.Persistence.Persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class AbstractPersistence<T> implements Persistence<T> {
    protected void createFolderIfNotExists(String folderName){
        var folder = new File(folderName);
        if(!folder.isDirectory())
            folder.mkdir();
    }

    protected PrintStream instantiateStream(String folderName, String fileName){
        var path = folderName + "/" + fileName;
        PrintStream stream = null;
        try {
            stream = new PrintStream(path);
        } catch (FileNotFoundException e) {
            return null;
        }
        return stream;
    }

    protected Scanner instantiateScanner(String folderName, String fileName){
        var path = folderName + "/" + fileName;
        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return null;
        }
        return scanner;
    }
}
