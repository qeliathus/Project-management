package by.potapchuk.controller;

import by.potapchuk.core.Project;
import by.potapchuk.service.IProjectService;
import by.potapchuk.service.dto.ProjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

class ProjectControllerTest {

    @InjectMocks
    private ProjectController projectController;

    @Mock
    private IProjectService projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addProject_ShouldReturnProjectDTO() {
        ProjectDTO dto = new ProjectDTO();
        dto.setName("Project A");
        dto.setDescription("Description of Project A");

        Project project = new Project();
        project.setName("Project A");
        project.setDescription("Description of Project A");

        when(projectService.addProject(any())).thenReturn(project);

        var response = projectController.addProject(dto);

        assertEquals(OK, response.getStatusCode());
        assertEquals("Project A", response.getBody().getName());
        verify(projectService).addProject(any());
    }
}