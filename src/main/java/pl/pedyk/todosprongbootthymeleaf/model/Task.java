package pl.pedyk.todosprongbootthymeleaf.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Task's description must not be empty")
    private String description;

    private boolean done;

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
