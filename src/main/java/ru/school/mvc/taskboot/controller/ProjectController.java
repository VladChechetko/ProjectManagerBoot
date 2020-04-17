package ru.school.mvc.taskboot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.school.mvc.taskboot.entity.Project;
import ru.school.mvc.taskboot.service.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model) {
		List<Project> projects = projectService.getListProject();
		model.addAttribute("projects", projects);
		return "projects";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(Model model) {
		Project project = new Project();
		project.setDateBegin(new Date());
		project.setDateEnd(new Date());
		model.addAttribute("project", project);
		return "project_edit";
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public String edit(Model model, @PathVariable String id) {
		Project project = projectService.getProjectById(id);
		model.addAttribute("project", project);
		return "project_edit";
	}

	@RequestMapping(value="/del/{id}", method=RequestMethod.GET)
	public String del(Model model, @PathVariable String id) {
		projectService.removeProjectById(id);
		return "redirect:/projects";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String save(@ModelAttribute Project project, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "redirect:/error";
		}
		projectService.merge(project);
		return "redirect:/projects";
	}
	
	
}
