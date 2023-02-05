package Server.api;

import Commons.Game;
import Commons.Player;
import Server.database.GameRepository;
import Server.database.PlayerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("game")
public class GameController {

    private final GameRepository gameRepo;
    private final PlayerRepository playerRepo;

    public GameController(GameRepository gameRepo, PlayerRepository playerRepo){
        this.gameRepo = gameRepo;
        this.playerRepo = playerRepo;
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<List<Game>> getGames(){
        return ResponseEntity.ok(gameRepo.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable("id") Long id){
        Optional<Game> game = gameRepo.findById(id);
        return game.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping(path = "/join")
    public ResponseEntity<Game> joinGame(Player player){
        Game game = new Game();
        game.setPlayerId(player.getId());
        player.setGameId(game.getId());
        //TODO: Change word
        game.setWord("PIZZA");
        return ResponseEntity.ok(game);
    }

}
