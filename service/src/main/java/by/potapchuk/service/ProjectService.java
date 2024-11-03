package by.potapchuk.service;

import by.potapchuk.core.Employee;
import by.potapchuk.core.Project;
import by.potapchuk.repository.EmployeeRepository;
import by.potapchuk.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProjectService implements IProjectService {
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    public ProjectService(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Project> getAllProjects(Pageable pageable) {
        Pageable sortedByName = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("name").ascending());
        return projectRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public String addEmployeeToProject(Long projectId, Long employeeId) {
        Optional<Project> projectOpt = projectRepository.findById(projectId);
        Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);

        if (projectOpt.isPresent() && employeeOpt.isPresent()) {
            Project project = projectOpt.get();
            Employee employee = employeeOpt.get();
            project.getEmployees().add(employee);
            projectRepository.save(project);
            return "Employee added to project successfully";
        } else {
            return "Project or Employee not found";
        }
    }
}