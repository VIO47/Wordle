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
    private Player dummyPlayer = new Player("");
    private Player player = new Player("");
    private String word = "";
    private List<String> words = new ArrayList<>();

    public void setPlayer(Player player){
        this.player = player;
    }

    public void setDummy(Player player){
        this.dummyPlayer = player;
    }

    public Player getDummyPlayer() {
        return dummyPlayer;
    }

    public String getWord(){
        return word;
    }

    public Player createGame(){
        Game game = ClientBuilder.newClient(new ClientConfig()) //
            .target(server).path("game/join") //
            .request(APPLICATION_JSON) //
            .accept(APPLICATION_JSON) //
            .post(Entity.entity(getDummyPlayer(), APPLICATION_JSON), Game.class);

        setPlayer(game.getPlayer());
        this.word = game.getWord();
        return player;
    }

    public boolean exactPosition(Character s, int poz){
        return word.charAt(poz) == s;
    }

    public boolean containsLetter(Character s){
        return word.contains(s.toString());
    }

    public void read(){
        try {
            Scanner scanner = new Scanner(new File("Wordle_words.txt"));
            scanner.useDelimiter("\n");
            while(scanner.hasNextLine()){
                words.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
