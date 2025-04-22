package pack.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "springboard")
public class DataDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;                       
	private String author;                  
	private String title;    
	@Column(columnDefinition = "TEXT")
	private String content;                
	private LocalDateTime  bwrite;              
	private int readcnt;        
	
	@PrePersist
	public void prePersist() {
	    this.bwrite = LocalDateTime.now();
	}
	public String getFormattedBwrite() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	    return bwrite.format(formatter);
	}


}
