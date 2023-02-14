package Server.API;

import Commons.Word;
import Server.Database.WordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "word")
public class WordAPI {

    private final WordRepository repo;

    public WordAPI(WordRepository repo){
        this.repo = repo;
    }

    @GetMapping(path = "")
    public List<Word> getAll(){
        return repo.findAll();
    }

    @PostMapping(path = "")
    public Word addWord(@RequestBody Word word){
        return repo.save(word);
    }
}
