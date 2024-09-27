package dgtic.dcn.tem.expensesAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dgtic.dcn.tem.expensesAPI.model.DailyExpense;

@Repository
public interface DailyExpenseRepository extends MongoRepository<DailyExpense, String>{
	
	List<DailyExpense> findAllByTripId(String tripId); 

}
