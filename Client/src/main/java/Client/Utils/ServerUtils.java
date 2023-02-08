package Client.Utils;

import Commons.*;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

public class ServerUtils {

    private final String server = "https://localhost:8080/";
    private Player dummyPlayer = new Player();
    private Player player = new Player();
    private String word;

    public void setPlayer(Player player){
        this.player = player;
    }

    public Game getGame(){
        return ClientBuilder.newClient(new ClientConfig())
            .target(server).path("game/" + player.getGameId())
            .request(APPLICATION_JSON)
            .accept(APPLICATION_JSON)
            .get(new GenericType<>(){});
    }

    public Game createGame(){
        Response response = ClientBuilder.newClient(new ClientConfig())
            .target(server).path("game/join")
            .request()
            .post(Entity.json(dummyPlayer));
        Game game = response.readEntity(Game.class);
        Player p = game.getPlayer();
        setPlayer(p);
        word = game.getWord();
        return game;
    }

    public boolean exactPosition(Character s, int poz){
        return word.charAt(poz) == s;
    }

    public boolean containsLetter(Character s){
        return word.contains(s.toString());
    }

    public String getWord(){
        return word;
    }

}
