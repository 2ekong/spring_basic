package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gogek")
public class Gogek {
    @Id
    private int gogekno;
    private String gogekname;
    private int gogekdamsano;
    
    @ManyToOne
    @JoinColumn(name = "gogekdamsano", insertable = false, updatable = false)
    private Jikwon jikwon;
}
