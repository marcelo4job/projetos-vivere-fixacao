package com.marcelo.pontocontrole.repository;

import com.marcelo.pontocontrole.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
