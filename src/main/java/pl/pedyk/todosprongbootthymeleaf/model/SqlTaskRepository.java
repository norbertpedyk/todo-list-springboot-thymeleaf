package pl.pedyk.todosprongbootthymeleaf.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Long> {
}
