package Server.API;

import Commons.Game;
import Commons.Player;
import Server.Database.GameRepository;
import Server.Database.PlayerRepository;
import Server.Utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "game")
public class GameAPI {

    private final GameRepository repo;
    private final PlayerRepository playerRepo;
    private Utils utils;

    public GameAPI(GameRepository repo, PlayerRepository playerRepo){
        this.repo = repo;
        this.playerRepo = playerRepo;
    }

    @PostMapping(path = "/join")
    public ResponseEntity<Game> createGame(@RequestBody Player player){
        Game game = new Game();
        game.setWord(utils.getWord());
        repo.save(game);

        game.setPlayer(player);
        player.setGameId(game.getId());
        playerRepo.save(player);
        return ResponseEntity.ok(game);
    }
}
