package Client.Utils;

import Commons.*;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import org.glassfish.jersey.client.ClientConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

public class ServerUtils {

    private final String server = "http://localhost:8080/";
    public Player dummyPlayer = new Player("");
    public Player player = new Player("");
    private String word;
    private List<String> words = new ArrayList<>();
    public List<Word> wordList = new ArrayList<>();

    public String getWord(){
        return word;
    }

    /**
     * Method for connecting to the server and creating a game.
     * @return a new game with the client's user inside it
     */
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

    /**
     * Method for checking if the word is a valid word out of the english dictionary
     * @param word the typed word
     * @return a boolean
     */
    public boolean isWord(String word){
        //return words.contains(word);
        List<Word> aux = wordList.stream().filter(x -> x.getWord().equals(word)).collect(Collectors.toList());
        return aux.size() != 0;
    }

    /**
     * Method for checking if a typed letter is on the exact position it was put
     * @param s the letter
     * @param poz the position of the letter inside the typed word
     * @return a boolean
     */
    public boolean exactPosition(Character s, int poz){
        return word.charAt(poz) == s;
    }

    /**
     * Method for checking if the typed letter is inside the word
     * @param s the letter
     * @return a boolean
     */
    public boolean containsLetter(Character s){
        return word.contains(s.toString());
    }

    /**
     * A method for choosing the color of a letter based on the helper check methods
     * @param s the letter
     * @param poz the position of the letter
     * @return a color in string format
     */
    public String setColor(Character s, int poz){
        String color;
        if(exactPosition(s, poz)) color = "#a7c957";
        else if (containsLetter(s)) color = "#ffbd00";
        else color = "#eae0d5";
        return "-fx-background-color:" + color;
    }

    //TODO: Not working now!
    public List<Word> read(){
        List<Word> words = ClientBuilder.newClient(new ClientConfig()) //
            .target(server).path("word") //
            .request(APPLICATION_JSON) //
            .get(new GenericType<>() {
            });
        for(Word w : words){
            this.words.add(w.getWord());
            wordList.add(w);
        }
        return words;
    }
}
