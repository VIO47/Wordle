package Commons;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Game")
@NoArgsConstructor
@Setter
@Getter
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "player_id")
    private Player player;
    private String word;

    public Game(Long id, Player player, String word){
        this.id = id;
        this.player = player;
        this.word = word;
    }
}
