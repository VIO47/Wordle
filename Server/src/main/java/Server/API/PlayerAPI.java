package Server.API;

import Commons.Player;
import java.util.List;
import Server.Database.PlayerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "player")
public class PlayerAPI {

    private final PlayerRepository repo;

    public PlayerAPI(PlayerRepository repo){
        this.repo = repo;
    }

    /**
     * API for retrieving all players (for testing)
     * @return a list of all players
     */
    @GetMapping(path = "")
    public ResponseEntity<List<Player>> getAll(){
        return ResponseEntity.ok(repo.findAll());
    }

    /**
     * API for adding a player to the database.
     * @param player the newly added player
     * @return a new player
     */
    @PostMapping(path = "")
    public ResponseEntity<Player> add(@RequestBody Player player){
        return ResponseEntity.ok(repo.save(player));
    }

}
