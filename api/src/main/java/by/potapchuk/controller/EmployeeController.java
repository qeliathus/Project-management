package by.potapchuk.controller;

import by.potapchuk.core.Employee;
import by.potapchuk.service.IEmployeeService;
import by.potapchuk.service.converter.EmployeeConverter;
import by.potapchuk.service.dto.EmployeeDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);
    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {

        LOGGER.info("Adding employee: {}", employeeDTO);
        Employee employee = EmployeeConverter.toEntity(employeeDTO);
        Employee savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(EmployeeConverter.toDTO(savedEmployee));
    }
}