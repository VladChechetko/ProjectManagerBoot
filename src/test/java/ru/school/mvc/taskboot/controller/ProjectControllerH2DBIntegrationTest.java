package ru.school.mvc.taskboot.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import ru.school.mvc.taskboot.entity.Project;
import ru.school.mvc.taskboot.repository.ProjectRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectControllerH2DBIntegrationTest {

	@Autowired
	private TestRestTemplate template;
	
	@Autowired
    private ProjectRepository projectRepository;
	
	@Before
	public void setUp() {
		Project p = new Project();
		p.setName("Name");
		
		projectRepository.save(p);
	}
	
	@Test
	public void testList() {
		ResponseEntity<List<Project>> response = template.exchange("/rest/projects", HttpMethod.GET, null, new ParameterizedTypeReference<List<Project>>() {});
		List<Project> projectList = response.getBody();
		
		assertThat(projectList.size()).isEqualTo(1);
	}
	
}
