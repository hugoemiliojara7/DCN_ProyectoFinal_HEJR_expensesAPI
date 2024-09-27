package dgtic.dcn.tem.expensesAPI.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import dgtic.dcn.tem.expensesAPI.model.DailyExpense;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(path="api/dailyExpenses", produces="application/json")
@CrossOrigin(origins="*")
@Tag(name="dailyExpenses", description="EndPoint of daiyl expenses resource")
public interface DailyExpenseApi {

	@Operation(summary = "Get all daily expenses saved in collection")
	@ApiResponse(responseCode = "200", description = "Daily expenses retrieved successfully", 
				content = {@Content(mediaType="application/json", 
				schema = @Schema(implementation = DailyExpense.class))})
	@GetMapping
	List<DailyExpense> getAllDailyExpenses();
	
	@Operation(summary = "Get all daily expenses by its trip id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Daily expenses retrieved successfully",
					content = {@Content(mediaType="application/json", 
							schema = @Schema(implementation = DailyExpense.class))})
	})	
	@GetMapping("{tripId}")
	List<DailyExpense> getDailyExpensesByTripId(@PathVariable("tripId") String tripId);
	
	@Operation(summary = "Get a specific expense by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Expense retrieved successfully",
					content = {@Content(mediaType="application/json", 
							schema = @Schema(implementation = DailyExpense.class))}), 
			@ApiResponse(responseCode = "404", description = "Expense not found",
			content = @Content)
	})	
	@GetMapping("{id}")
	ResponseEntity<DailyExpense> getExpenseById(@PathVariable("id") String id);
	

}
