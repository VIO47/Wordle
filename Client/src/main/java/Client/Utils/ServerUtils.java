package Client.Utils;

import Commons.*;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.client.Entity;
import org.glassfish.jersey.client.ClientConfig;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

public class ServerUtils {

    private final String server = "http://localhost:8080/";
    private Player dummyPlayer = new Player("");
    private Player player = new Player("");
    private String word;

    public void setPlayer(Player player){
        this.player = player;
    }

    public String getWord(){
        return word;
    }

    public void setDummy(Player player){
        this.dummyPlayer = player;
    }

    public Player getDummyPlayer() {
        return dummyPlayer;
    }

    public Player createGame(){
        System.out.println(dummyPlayer.getName());
        Game game = ClientBuilder.newClient(new ClientConfig()) //
            .target(server).path("game/join") //
            .request(APPLICATION_JSON) //
            .accept(APPLICATION_JSON) //
            .post(Entity.entity(getDummyPlayer(), APPLICATION_JSON), Game.class);

        setPlayer(game.getPlayer());
        this.word = game.getWord();
        System.out.println(game.getWord());
        return player;
    }

    public boolean exactPosition(Character s, int poz){
        return word.charAt(poz) == s;
    }

    public boolean containsLetter(Character s){
        return word.contains(s.toString());
    }


}
