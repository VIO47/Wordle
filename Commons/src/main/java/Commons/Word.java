package Commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Word")
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Word {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String word;

    public Word(String str){
        this.word = str;
    }
}
