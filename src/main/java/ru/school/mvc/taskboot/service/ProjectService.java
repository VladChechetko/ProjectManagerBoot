package ru.school.mvc.taskboot.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.school.mvc.taskboot.entity.Project;
import ru.school.mvc.taskboot.repository.ProjectRepository;

@Service
@Transactional
public class ProjectService {

	@Autowired
    private ProjectRepository projectRepository;

    public Project createProject(final String name) {
        if (name == null || name.isEmpty()) return null;
        Project p = new Project();
        p.setName(name);
        return projectRepository.save(p);
    }

    public Project merge(final Project project) {
        if (project == null) return null;
        return projectRepository.save(project);
    }

	
    public void merge(Collection<Project> projects) {
    	for (Project p : projects) {
    		projectRepository.save(p);
    	}
    }

    public Project getProjectById(final String id) {
        if (id == null || id.isEmpty()) return null;
        Project p = projectRepository.getOne(Long.valueOf(id));
        p.getTaskList();
        return p;
    }

    public void removeProjectById(final String id) {
        if (id == null || id.isEmpty()) return;
        projectRepository.deleteById(Long.valueOf(id));
    }

    public List<Project> getListProject() {
        return projectRepository.findAll();
    }

    public void clear() {
        projectRepository.deleteAll();
    }

    public void merge(final Project... projects) {
        if (projects == null || projects.length == 0) return;
    	for (Project p : projects) {
    		projectRepository.save(p);
    	}
    }

    public void load(Collection<Project> projects) {
        if (projects == null) return;
    	for (Project p : projects) {
    		projectRepository.save(p);
    	}
    }

    public void load(final Project... projects) {
        if (projects == null) return;
    	for (Project p : projects) {
    		projectRepository.save(p);
    	}
    }

    public void removeByOrderIndex(Long orderIndex) {
        if (orderIndex == null) return;
        projectRepository.deleteById(orderIndex);
    }

}
