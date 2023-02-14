package Client.Utils;

import Commons.*;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import org.glassfish.jersey.client.ClientConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

public class ServerUtils {

    private final String server = "http://localhost:8080/";
    public Player dummyPlayer = new Player("");
    public Player player = new Player("");
    private String word;
    private List<String> words = new ArrayList<>();

    public String getWord(){
        return word;
    }

    public Player createGame(){
        Game game = ClientBuilder.newClient(new ClientConfig()) //
            .target(server).path("game/join") //
            .request(APPLICATION_JSON) //
            .accept(APPLICATION_JSON) //
            .post(Entity.entity(dummyPlayer, APPLICATION_JSON), Game.class);

        player = game.getPlayer();
        word = game.getWord();
        return player;
    }

    public boolean isWord(String word){
        return words.contains(word);
    }
    public boolean exactPosition(Character s, int poz){
        return word.charAt(poz) == s;
    }

    public boolean containsLetter(Character s){
        return word.contains(s.toString());
    }

    public String setColor(Character s, int poz){
        String color;
        if(exactPosition(s, poz)) color = "#a7c957";
        else if (containsLetter(s)) color = "#ffbd00";
        else color = "#eae0d5";
        return color;
    }

    public void read(){
        try {
            Scanner scanner = new Scanner(new File("Wordle_words.txt"));
            scanner.useDelimiter("\n");
            while(scanner.hasNextLine()){
                words.add(scanner.nextLine());
            }
            System.out.println("Client read!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
