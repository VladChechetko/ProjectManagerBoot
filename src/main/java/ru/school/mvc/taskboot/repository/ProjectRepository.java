package ru.school.mvc.taskboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.school.mvc.taskboot.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>  {

}
