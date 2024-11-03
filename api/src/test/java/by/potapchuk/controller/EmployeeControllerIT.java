package by.potapchuk.controller;

import by.potapchuk.service.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addEmployee_ShouldReturnOk() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName("John");
        employeeDTO.setLastName("Doe");
        employeeDTO.setSurname("Smith");
        employeeDTO.setEmail("john.doe@example.com");
        employeeDTO.setPosition("Developer");

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"John\",\"lastName\":\"Doe\",\"surname\":\"Smith\",\"email\":\"john.doe@example.com\",\"position\":\"Developer\"}"))
                .andExpect(status().isOk());
    }
}