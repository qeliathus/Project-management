package by.potapchuk.service.converter;

import by.potapchuk.core.Employee;
import by.potapchuk.core.Project;
import by.potapchuk.service.dto.ProjectDTO;

import java.util.stream.Collectors;

public class ProjectConverter {
    public static ProjectDTO toDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setEmployeeIds(project.getEmployees().stream().map(Employee::getId).collect(Collectors.toSet()));
        return dto;
    }

    public static Project toEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        return project;
    }
}