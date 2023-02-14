package Server;

import Server.Database.GameRepository;
import Server.Database.PlayerRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Service
public class Utils {

    private final GameRepository gameRepo;
    private final PlayerRepository playerRepo;
    public static List<String> words = new ArrayList<>();
    public Random r = new Random();

    public Utils(GameRepository gameRepo, PlayerRepository playerRepo) {
        this.gameRepo = gameRepo;
        this.playerRepo = playerRepo;
        read();
    }

    /**
     * Method for reading all words inside the "word.txt" file
     */
    public static void read(){
        try {
            Scanner scanner = new Scanner(new File("Wordle_words.txt"));
            scanner.useDelimiter("\n");
            while(scanner.hasNextLine()){
                String w = scanner.nextLine();
                words.add(w);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Helper method for getting a random word out of the poll
     * @return a word
     */
    public String getWord(){
        int next = r.nextInt(words.size());
        return words.get(next);
    }
}
