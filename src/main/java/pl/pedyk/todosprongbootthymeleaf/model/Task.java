package pl.pedyk.todosprongbootthymeleaf.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Task {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "generator")
    private Long id;

    @NotBlank(message = "Task's description must not be empty")
    private String description;

    private boolean done;

    public Long getId() {
        return id;
    }

    public Task() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
