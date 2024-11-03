package by.potapchuk.controller;

import by.potapchuk.core.Employee;
import by.potapchuk.service.IEmployeeService;
import by.potapchuk.service.dto.EmployeeDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private IEmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addEmployee_ShouldReturnEmployeeDTO() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstName("John");
        dto.setLastName("Doe");
        dto.setSurname("Smith");
        dto.setEmail("john.doe@example.com");
        dto.setPosition("Developer");

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setSurname("Smith");
        employee.setEmail("john.doe@example.com");
        employee.setPosition("Developer");

        when(employeeService.addEmployee(any())).thenReturn(employee);

        var response = employeeController.addEmployee(dto);

        assertEquals(OK, response.getStatusCode());
        assertEquals("John", Objects.requireNonNull(response.getBody()).getFirstName());
        verify(employeeService).addEmployee(any());
    }
}