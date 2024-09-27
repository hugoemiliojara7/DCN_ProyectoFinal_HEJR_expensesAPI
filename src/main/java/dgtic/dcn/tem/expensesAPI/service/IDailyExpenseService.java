package dgtic.dcn.tem.expensesAPI.service;

import java.util.List;
import java.util.Optional;

import dgtic.dcn.tem.expensesAPI.model.DailyExpense;
public interface IDailyExpenseService {
	
	List<DailyExpense> findAllDailyExpenses();
	
	List<DailyExpense> findDailyExpensesByTrip(String tripId);
	
	Optional<DailyExpense> findDailyExpenseById(String id); 

}
