package dgtic.dcn.tem.expensesAPI.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import dgtic.dcn.tem.expensesAPI.model.DailyExpense;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(path="api/v1/dailyExpenses", produces="application/json")
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
	@GetMapping("/trip/{tripId}")
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
	
	@Operation(summary = "Save a new daily expense")
	@ApiResponse(responseCode = "201", description = "Daily expense saved successfully",
			content = {@Content(mediaType="application/json", 
			schema = @Schema(implementation=DailyExpense.class))} )
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	DailyExpense saveDailyExpense(@RequestBody DailyExpense expense);

	@Operation(summary = "Update daiyl expense information or details")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Daily expense updated successfully",
					content = {@Content(mediaType="application/json", 
						schema = @Schema(implementation=DailyExpense.class))}), 
			@ApiResponse(responseCode = "404", description = "Daily expense not found",
			content = @Content)
	})
	@PutMapping(path="{id}", consumes="application/json")
	ResponseEntity<DailyExpense> updateDailyExpense(@PathVariable("id") String id, 
			@RequestBody DailyExpense expense);
	
	@Operation(summary = "Delete a daiyle expense")
	@ApiResponse(responseCode = "204", description = "Daily expense deleted successfully")
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteDailyExpense(@PathVariable("id") String id);
}
