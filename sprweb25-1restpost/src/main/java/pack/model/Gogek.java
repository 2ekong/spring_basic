package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Gogek {
    @Id
    private int gogekno;
    private String gogekname;
    private String gogektel;
    private int gogekdamsano;
}