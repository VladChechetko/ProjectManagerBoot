package ru.school.mvc.taskboot.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ru.school.mvc.taskboot.entity.Project;

@SpringBootTest
public class ProjectRestClientTest {
	
	@Autowired
	private ProjectRestClient restClient;
	
	@Test
	public void testGetProject() {
		assertNotNull(restClient.getProject());
	}

	@Test
	public void testGetProjectList() {
		assertNotNull(restClient.getProjectList());
	}
	
	@Test
	public void testPostProject() {
		Project p = new Project();
		p.setName("Project from RestClient");
		p.setDateBegin(new Date());
		p.setDateEnd(new Date());
		p.setDescription("Project from RestClient description");
		
		assertNotNull(restClient.postProject(p));
	}

	@Test
	public void testDeleteProject() {
		restClient.deleteProject("10");
	}

}
