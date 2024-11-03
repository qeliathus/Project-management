package by.potapchuk.service.converter;

import by.potapchuk.core.Employee;
import by.potapchuk.service.dto.EmployeeDTO;

public class EmployeeConverter {
    public static EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setSurname(employee.getSurname());
        dto.setEmail(employee.getEmail());
        dto.setPosition(employee.getPosition());
        return dto;
    }

    public static Employee toEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setSurname(dto.getSurname());
        employee.setEmail(dto.getEmail());
        employee.setPosition(dto.getPosition());
        return employee;
    }
}