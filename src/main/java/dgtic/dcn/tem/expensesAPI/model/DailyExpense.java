package dgtic.dcn.tem.expensesAPI.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@Getter 
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@Document(collection="dailyExpenses")
public class DailyExpense {
	
	@Id
	private String id;
	
	private String concept;
	
	private Integer quantity;
	
	private LocalDate expDate; 
	
	private String category;
	
	private String currency; 
	
	private PayMethod payMethod; 
	
	private String details; 
	
	private String tripId; 

}
