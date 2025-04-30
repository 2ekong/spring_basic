package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Jikwon {
    @Id
    private int jikwonno;
    private String jikwonname;
}
