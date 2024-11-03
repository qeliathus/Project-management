package by.potapchuk.service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeDTO {

    @NotBlank(message = "First name is required")
    @NotNull(message = "First name is required")
    @Size(max = 20, message = "First name should be at most 20 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Only Latin letters are allowed")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @NotNull(message = "Last name is required")
    @Size(max = 40, message = "Last name should be at most 40 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Only Latin letters are allowed")
    private String lastName;

    @NotBlank(message = "Surname name is required")
    @NotNull(message = "Surname name is required")
    @Size(max = 40, message = "Surname should be at most 40 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Only Latin letters are allowed")
    private String surname;

    @NotBlank(message = "Email is required")
    @NotNull(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Size(max = 50, message = "Email should be at most 50 characters")
    private String email;

    @NotBlank(message = "Position name is required")
    @NotNull(message = "Position name is required")
    @Size(max = 40, message = "Position should be at most 40 characters")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Only Latin letters are allowed")
    private String position;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
