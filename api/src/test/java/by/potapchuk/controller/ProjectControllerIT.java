package by.potapchuk.controller;

import by.potapchuk.service.dto.ProjectDTO;
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
class ProjectControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addProject_ShouldReturnOk() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Project A");
        projectDTO.setDescription("Description of Project A");

        mockMvc.perform(post("/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Project A\",\"description\":\"Description of Project A\"}"))
                .andExpect(status().isOk());
    }
}