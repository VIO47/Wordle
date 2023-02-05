package Commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Player")
@Table(name = "Player")
@NoArgsConstructor
@Setter
@Getter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private Long gameId;
    private Long bestScore;

    public Player(Long id, String name){
        this.id = id;
        this.name = name;
    }

}
