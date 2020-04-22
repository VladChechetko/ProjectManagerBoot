package ru.school.mvc.taskboot.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import ru.school.mvc.taskboot.entity.Project;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectRepositoryH2DBIntegrationTest {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
    private TestEntityManager em;
	
	@Test
	public void testFindById_notFound() {
		Optional<Project> p = projectRepository.findById(1L);
		assertThat(p.isPresent()).isFalse();
	}
	
	@Test
	public void testFindById_foundOne() {
		Project p = new Project();
		p.setName("Name");
		
		p = em.persist(p);
	    em.flush();
	    
	    Project p2 = projectRepository.getOne(p.getId());
	    
		assertThat(p2).isNotNull();
		assertThat(p2.getName()).isEqualTo(p.getName());
	}
	
}
