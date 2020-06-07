package com.wujq.pay.employee;

import javax.validation.Valid;
import com.wujq.pay.employee.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping
	public ResponseEntity<List<Employee>> retrieveAllEmployees() {
		return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> retrieveEmployee(@PathVariable long id) {
		Optional<Employee> employee = employeeRepository.findById(id);

		if (!employee.isPresent())
			throw new EmployeeNotFoundException("id-" + id);

		Employee resource = employee.get();
		return new ResponseEntity<>(resource, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeRepository.deleteById(id);
	}

	@PostMapping
	public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);

		return new ResponseEntity<>(savedEmployee, HttpStatus.OK);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {

		Optional<Employee> employeeOptional = employeeRepository.findById(id);

		if (!employeeOptional.isPresent())
			return ResponseEntity.notFound().build();

		employee.setId(id);
		
		employeeRepository.save(employee);

		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
