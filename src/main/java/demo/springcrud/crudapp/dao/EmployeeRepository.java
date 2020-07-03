package demo.springcrud.crudapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.springcrud.crudapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// No need for any code
}
