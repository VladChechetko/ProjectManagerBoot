package ru.school.mvc.taskboot.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ru.school.mvc.taskboot.entity.Project;
import ru.school.mvc.taskboot.repository.ProjectRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {

	@Autowired
	private ProjectService projectService;
	
	@MockBean
	private ProjectRepository projectRepository;
	
	@Before
	public void init() {
		List<Project> projects = new ArrayList<Project>();
		projects.add(createMockProject(1L, "name1"));
		projects.add(createMockProject(2L, "name2"));
		projects.add(createMockProject(3L, "name3"));
		
		Mockito.when(projectRepository.findAll()).thenReturn(projects);
	}
	
	private Project createMockProject(Long id, String name) {
		Project p = new Project();
		p.setId(id);
		p.setName(name);
		return p;
	}
	
	@Test
	public void testListProject() {
		List<Project> projects = projectService.getListProject();
		assertThat(projects.size()).isEqualTo(3);
	}

}
