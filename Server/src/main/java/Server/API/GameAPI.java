package Server.API;

import Commons.Game;
import Commons.Player;
import Server.Database.GameRepository;
import Server.Database.PlayerRepository;
import Server.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "game")
public class GameAPI {

    private final GameRepository repo;
    private final PlayerRepository playerRepo;
    private Utils utils;

    public GameAPI(GameRepository repo, PlayerRepository playerRepo){
        this.repo = repo;
        this.playerRepo = playerRepo;
        utils = new Utils(repo, playerRepo);
    }

    /**
     * API for creating a game for one user
     * @param player the user that will join the game
     * @return a newly created game
     */
    @PostMapping(path = "/join")
    public ResponseEntity<Game> createGame(@RequestBody Player player){
        Game game = new Game();
        String word = utils.getWord();
        game.setWord(utils.getWord());
        repo.save(game);

        game.setPlayer(player);
        player.setGameId(game.getId());
        playerRepo.save(player);
        return ResponseEntity.ok(game);
    }

    @GetMapping(path = "")
    public List<Game> getAll(){
        return repo.findAll();
    }
}
