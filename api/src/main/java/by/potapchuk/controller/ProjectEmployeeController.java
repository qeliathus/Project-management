package by.potapchuk.controller;

import by.potapchuk.service.IProjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project-employee")
public class ProjectEmployeeController {
    private static final Logger LOGGER = LogManager.getLogger(ProjectEmployeeController.class);
    private final IProjectService projectService;

    public ProjectEmployeeController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<String> addEmployeeToProject(@RequestParam Long projectId, @RequestParam Long employeeId) {
        LOGGER.info("Adding employee with ID {} to project with ID {}", employeeId, projectId);
        String result = projectService.addEmployeeToProject(projectId, employeeId);
        return ResponseEntity.ok(result);
    }
}