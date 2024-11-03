package by.potapchuk.service.converter;

import by.potapchuk.core.Project;
import by.potapchuk.service.dto.ProjectDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectConverterTest {

    @Test
    void toDTO_ShouldConvertProjectToProjectDTO() {
        Project project = new Project();
        project.setName("Project A");
        project.setDescription("Description of Project A");
        project.setEmployees(Collections.emptySet());

        ProjectDTO dto = ProjectConverter.toDTO(project);

        assertEquals("Project A", dto.getName());
        assertEquals("Description of Project A", dto.getDescription());
        assertTrue(dto.getEmployeeIds().isEmpty());
    }

    @Test
    void toEntity_ShouldConvertProjectDTOToProject() {
        ProjectDTO dto = new ProjectDTO();
        dto.setName("Project A");
        dto.setDescription("Description of Project A");

        Project project = ProjectConverter.toEntity(dto);

        assertEquals("Project A", project.getName());
        assertEquals("Description of Project A", project.getDescription());
    }
}