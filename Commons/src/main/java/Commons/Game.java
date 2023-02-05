package Commons;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Game")
@Table(name = "Game")
@NoArgsConstructor
@Setter
@Getter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long playerId;
    private String word;

    public Game(Long id, Long playerId, String word){
        this.id = id;
        this.playerId = playerId;
        this.word = word;
    }

}
