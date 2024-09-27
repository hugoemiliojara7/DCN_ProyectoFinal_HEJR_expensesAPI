package dgtic.dcn.tem.expensesAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dgtic.dcn.tem.expensesAPI.model.DailyExpense;
import dgtic.dcn.tem.expensesAPI.service.IDailyExpenseService;

@RestController
public class DailyExpenseController implements DailyExpenseApi {
	
	@Autowired
	private IDailyExpenseService service; 

	@Override
	public List<DailyExpense> getAllDailyExpenses() {		
		return service.findAllDailyExpenses();
	}

	@Override
	public List<DailyExpense> getDailyExpensesByTripId(String tripId) {		
		return service.findDailyExpensesByTrip(tripId);
	}

	@Override
	public ResponseEntity<DailyExpense> getExpenseById(String id) {
		Optional<DailyExpense> expense = service.findDailyExpenseById(id);
		
		if(expense.isPresent())
			return new ResponseEntity<>(expense.get(), HttpStatus.OK);
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Override
	public DailyExpense saveDailyExpense(DailyExpense expense) {
		return service.saveExpense(expense);
	}

	@Override
	public ResponseEntity<DailyExpense> updateDailyExpense(String id, DailyExpense expense) {
		DailyExpense updatedExpense = service.updateExpense(id, expense);
		
		if (updatedExpense != null)
			return new ResponseEntity<>(updatedExpense, HttpStatus.OK) ;
		
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Override
	public void deleteDailyExpense(String id) {
		service.deleteExpense(id);
	} 
}
