package Commons;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Game")
@Table(name = "Game")
@NoArgsConstructor
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
