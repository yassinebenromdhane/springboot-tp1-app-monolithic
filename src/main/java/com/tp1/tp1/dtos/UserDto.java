package com.tp1.tp1.dtos;

import com.tp1.tp1.entities.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link com.tp1.tp1.entities.User}
 */

public class UserDto implements Serializable {
     private UUID id;
     private String name;
     private String login;
     private String password;
     private List<Project> projects = new ArrayList<>();

    public UserDto() {
    }

    public UserDto(UUID id, String name, String login, String password, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.projects = projects;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(name, userDto.name) && Objects.equals(login, userDto.login) && Objects.equals(password, userDto.password) && Objects.equals(projects, userDto.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, password, projects);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", projects=" + projects +
                '}';
    }
}