package demo.springcrud.crudapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.springcrud.crudapp.dao.EmployeeRepository;
import demo.springcrud.crudapp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository; // Either use the Field injection or Constructor injection
	
//	@Autowired
//	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee theEmployee = null;
		
		if(result.isPresent())
			theEmployee = result.get();
		else
			// In case we didn't find the employee by that id
			throw new RuntimeException("Employee Not Found with Id : "+id);
			
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}
