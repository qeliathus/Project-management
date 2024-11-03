package by.potapchuk.service;

import by.potapchuk.core.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProjectService {
    Project addProject(Project project);

    Page<Project> getAllProjects(Pageable pageable);

    String addEmployeeToProject(Long projectId, Long employeeId);
}