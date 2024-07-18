package com.example.demo.Role;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "role")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "CreatedAt")
    private LocalDateTime created;
    @Column(name = "UpdatedAt")
    private LocalDateTime updated;

    public RoleModel() {
    }

    public RoleModel(Long id, String name, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.updated = updated;
    }

    public RoleModel(String name, LocalDateTime created, LocalDateTime updated) {
        this.name = name;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDateTime getCreated() {
        return created;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public LocalDateTime getUpdated() {
        return updated;
    }
    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
