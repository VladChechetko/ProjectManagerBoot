package ru.school.mvc.taskboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.school.mvc.taskboot.entity.Project;
import ru.school.mvc.taskboot.service.ProjectService;

@RestController
@RequestMapping("/rest/projects")
public class ProjectRestController {
	
	@Autowired
	private ProjectService projectService;

	@GetMapping
	public List<Project> list() {
		return projectService.getListProject();
	}
	
	@GetMapping(value="/{id}")
	public Project get(@PathVariable String id) {
		return projectService.getProjectById(id);
	}
	
	@PostMapping
	public Project save(@RequestBody Project project) {
		return projectService.merge(project);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable String id) {
		projectService.removeProjectById(id);
	}
	
}
