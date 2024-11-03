package by.potapchuk.controller;

import by.potapchuk.core.Project;
import by.potapchuk.service.IProjectService;
import by.potapchuk.service.converter.ProjectConverter;
import by.potapchuk.service.dto.ProjectDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private static final Logger LOGGER = LogManager.getLogger(ProjectController.class);
    private final IProjectService projectService;

    public ProjectController(IProjectService projectService) {
        this.projectService = projectService;
    }


    @PostMapping
    public ResponseEntity<ProjectDTO> addProject(@RequestBody ProjectDTO projectDTO) {
        LOGGER.info("Adding project: {}", projectDTO);
        Project project = ProjectConverter.toEntity(projectDTO);
        Project savedProject = projectService.addProject(project);
        return ResponseEntity.ok(ProjectConverter.toDTO(savedProject));
    }

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int size) {
        LOGGER.info("Fetching all projects with pagination");
        Pageable pageable = PageRequest.of(page, size);
        Page<Project> projectsPage = projectService.getAllProjects(pageable);
        List<ProjectDTO> projectDTOs = projectsPage.getContent().stream()
                .map(ProjectConverter::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(projectDTOs);
    }
}
