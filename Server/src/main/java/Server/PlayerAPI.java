package Server;

import Commons.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "player")
public class PlayerAPI {

    private final PlayerRepository repo;

    public PlayerAPI(PlayerRepository repo){
        this.repo = repo;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Player>> getAll(){
        return ResponseEntity.ok(repo.findAll());
    }

    @PostMapping(path = "")
    public ResponseEntity<Player> add(@RequestBody Player player){
        return ResponseEntity.ok(repo.save(player));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Player> getById(@PathVariable("id") Long id){
        Optional<Player> player = repo.findById(id);
        if(player.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(player.get());

    }
}
