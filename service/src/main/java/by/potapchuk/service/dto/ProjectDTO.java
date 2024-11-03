package by.potapchuk.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class ProjectDTO {

    @NotBlank(message = "Name is required")
    @NotNull(message = "Name is required")
    @Size(max = 60, message = "Name should be at most 20 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Only Latin letters are allowed")
    private String name;

    @NotBlank(message = "Description is required")
    @NotNull(message = "Description is required")
    @Size(max = 150, message = "Name should be at most 20 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Only Latin letters are allowed")
    private String description;

    private Set<Long> employeeIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(Set<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }
}