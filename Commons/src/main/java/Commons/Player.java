package Commons;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Player")
@NoArgsConstructor
@Setter
@Getter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long gameId;

    public Player(Long id, String name){
        this.id = id;
        this.name = name;
        this.gameId = 0L;
    }

    public Player(String name){
        this.name = name;
        this.gameId = 0L;
    }
}
