package expenses.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import expenses.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaSpecificationExecutor<Employee>, JpaRepository<Employee, Long> {
	List<Employee> findBySupervisor(Employee employee);

	Employee findOneByUsername(String username);
}
