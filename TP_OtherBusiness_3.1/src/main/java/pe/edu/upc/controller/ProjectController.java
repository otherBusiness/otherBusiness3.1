package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Category;
import pe.edu.upc.entity.Project;
import pe.edu.upc.serviceinterface.IcategoryService;
import pe.edu.upc.serviceinterface.IprojectService;

@Named
@RequestScoped
public class ProjectController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// variables
	@Inject
	private IprojectService iService;

	@Inject
	private IcategoryService caService;

	private Project i;
	private Category ca;

	List<Project> listaProject;
	List<Category> listaCategory;

	// constructor
	@PostConstruct
	public void init() {
		this.listaProject = new ArrayList<Project>();
		this.listaCategory = new ArrayList<Category>();
		this.i = new Project();
		this.ca = new Category();
		this.list();
		this.listCategory();

	}

	// Metodos
	public String newProject() {
		this.setI(new Project());
		return "project.xhtml";
	}

	public void insert() {
		try {
			iService.insert(i);
			cleanProject();
			this.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void list() {
		try {
			listaProject = iService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listCategory() {
		try {
			listaCategory = caService.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void cleanProject() {
		this.init();
	}

	// getters y setters

	public IprojectService getiService() {
		return iService;
	}

	public void setiService(IprojectService iService) {
		this.iService = iService;
	}

	public Project getI() {
		return i;
	}

	public void setI(Project i) {
		this.i = i;
	}

	public List<Project> getListaProject() {
		return listaProject;
	}

	public void setListaProject(List<Project> listaProject) {
		this.listaProject = listaProject;
	}

	public IcategoryService getCaService() {
		return caService;
	}

	public void setCaService(IcategoryService caService) {
		this.caService = caService;
	}

	public Category getCa() {
		return ca;
	}

	public void setCa(Category ca) {
		this.ca = ca;
	}

	public List<Category> getListaCategory() {
		return listaCategory;
	}

	public void setListaCategory(List<Category> listaCategory) {
		this.listaCategory = listaCategory;
	}

	
}
