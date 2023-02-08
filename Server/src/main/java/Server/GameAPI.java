package Server;

import Commons.Game;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "game")
public class GameAPI {

    private final GameRepository repo;
    private final PlayerRepository playerRepo;

    public GameAPI(GameRepository repo, PlayerRepository playerRepo){
        this.repo = repo;
        this.playerRepo = playerRepo;
    }

    @PostMapping(path = "/join/{id}")
    public ResponseEntity<Game> createGame(@PathVariable("id") Long playerId){
        if(!playerRepo.existsById(playerId)) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        Game game = new Game();
        game.setWord("PIZZA");
        game.setPlayerId(playerId);
        return ResponseEntity.ok(game);
    }
}
