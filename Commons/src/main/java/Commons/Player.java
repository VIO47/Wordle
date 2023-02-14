package Commons;

import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import javax.persistence.*;

@Entity(name = "Player")
@NoArgsConstructor
@Setter
@Getter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long gameId = 0L;

    public Player(String name){
        this.name = name;
    }

    /**
     * A method that uses an API supportive version of the "equals" method.
     *
     * @return a boolean stating if 2 players are the same
     */
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    /**
     * A method that uses an API supportive version of hashing.
     *
     * @return a hash code of the Player object
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * A method that uses an API supportive method of transforming data into a string.
     *
     * @return a string containing every detail about the player
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, MULTI_LINE_STYLE);
    }
}
