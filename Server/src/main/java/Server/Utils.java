package Server;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utils {

    public List<String> words = read();

    public static List<String> read(){
        List<String> l = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("Wordle_words.txt"));
            scanner.useDelimiter("\n");
            while(scanner.hasNextLine()){
                l.add(scanner.nextLine());
            }
            System.out.println("File was read!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return l;
    }

    public String getWord(){
        Random r = new Random(words.size());
        int next = r.nextInt();
        if (next < 0 ) next = -next;
        return words.get(next);
    }
}
