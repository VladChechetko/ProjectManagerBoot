package ru.school.mvc.taskboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import ru.school.mvc.taskboot.entity.Project;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource("classpath:application_mysql.properties")
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ProjectRepositoryMysqlIntegrationTest {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Test
	public void testFindById_notFound() {
		Optional<Project> p = projectRepository.findById(1L);
		assertThat(p.isPresent()).isFalse();
	}
	
	@Test
	public void testFindById_foundOne() {
	    Project p2 = projectRepository.getOne(11L);
	    
		assertThat(p2).isNotNull();
	}
	
}
