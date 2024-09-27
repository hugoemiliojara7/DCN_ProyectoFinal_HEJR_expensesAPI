package dgtic.dcn.tem.expensesAPI.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgtic.dcn.tem.expensesAPI.model.DailyExpense;
import dgtic.dcn.tem.expensesAPI.repository.DailyExpenseRepository;
import dgtic.dcn.tem.expensesAPI.service.IDailyExpenseService;

@Service 
public class DailyExpenseService implements IDailyExpenseService {
	
	@Autowired
	private DailyExpenseRepository repository; 

	@Override
	public List<DailyExpense> findAllDailyExpenses() {		
		return repository.findAll();
	}

	@Override
	public List<DailyExpense> findDailyExpensesByTrip(String tripId) {
		return repository.findAllByTripId(tripId);
	}

	@Override
	public Optional<DailyExpense> findDailyExpenseById(String id) {		
		return repository.findById(id);
	}
	
	@Override
	public DailyExpense saveExpense(DailyExpense expense) {		
		return repository.save(expense);
	}

	@Override
	public DailyExpense updateExpense(String id, DailyExpense expense) {
		Optional<DailyExpense> oldExpense = repository.findById(id);
		
		if (oldExpense.isPresent()) {
			repository.save(expense);
			return expense;
		}
		return null;
	}

	@Override
	public void deleteExpense(String id) {
		repository.deleteById(id);
	} 

	
}
