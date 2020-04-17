package ru.school.mvc.taskboot.client;

import java.net.URI;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ru.school.mvc.taskboot.entity.Project;

@Component
public class ProjectRestClient {

	private RestTemplate template = new RestTemplate();
	
	public Project getProject() {
		Project p = template.getForObject("http://localhost:8080/rest/projects/11", Project.class);
		System.out.println("Project:"+p);
		return p;
	}
	
	public List<Project> getProjectList() {
		ResponseEntity<List<Project>> response = template.exchange("http://localhost:8080/rest/projects", HttpMethod.GET, null, new ParameterizedTypeReference<List<Project>>() {});
		List<Project> projectList = response.getBody();
		System.out.println("Projects:"+projectList);
		return projectList;
	}
	
	public Project postProject(Project p) {
		Project createdProject = template.postForObject("http://localhost:8080/rest/projects", p, Project.class);
		System.out.println("createdProject: "+createdProject);
		return createdProject;
	}
	
	public void deleteProject(String id) {
		template.delete(URI.create("http://localhost:8080/rest/projects/"+id));
		System.out.println("Project deleted");
	}

}
