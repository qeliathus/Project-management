package by.potapchuk.service.converter;

import by.potapchuk.core.Employee;
import by.potapchuk.service.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeConverterTest {

    @Test
    public void testToDTO_ShouldConvertEmployeeToEmployeeDTO() {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setSurname("Smith");
        employee.setEmail("john.doe@example.com");
        employee.setPosition("Developer");

        EmployeeDTO dto = EmployeeConverter.toDTO(employee);

        assertEquals("John", dto.getFirstName());
        assertEquals("Doe", dto.getLastName());
        assertEquals("Smith", dto.getSurname());
        assertEquals("john.doe@example.com", dto.getEmail());
        assertEquals("Developer", dto.getPosition());
    }

    @Test
    public void testToEntity_ShouldConvertEmployeeDTOToEmployee() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setFirstName("Jane");
        dto.setLastName("Doe");
        dto.setSurname("Doe");
        dto.setEmail("jane.doe@example.com");
        dto.setPosition("Manager");

        Employee employee = EmployeeConverter.toEntity(dto);

        assertEquals("Jane", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("Doe", employee.getSurname());
        assertEquals("jane.doe@example.com", employee.getEmail());
        assertEquals("Manager", employee.getPosition());
    }
}