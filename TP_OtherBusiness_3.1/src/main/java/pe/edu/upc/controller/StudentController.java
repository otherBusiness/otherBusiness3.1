package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Campus;
import pe.edu.upc.entity.Student;
import pe.edu.upc.serviceinterface.IcampusService;
import pe.edu.upc.serviceinterface.IstudentService;

@Named
@RequestScoped
public class StudentController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Variables
	@Inject
	private IstudentService iService;
	
	@Inject
	private IcampusService cService;
	
	private Student i;
	private Campus c;
	
	List<Student> listaStudent;
	List<Campus> listaCampus;

	// constructor
	@PostConstruct
	public void init() {
		this.listaStudent = new ArrayList<Student>();
		this.listaCampus=new ArrayList<Campus>();
		this.i = new Student();
		this.c= new Campus();
		this.list();
		this.listCampus();
		

	}

	// metodos
	public String newStudent() {
		this.setI(new Student());
		return "student.xhtml";
	}

	
	public void insert() {
		try {
			iService.insert(i);
			cleanStudent();
			this.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void list() {
		try {
			listaStudent = iService.list();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void listCampus() {
		try {
			listaCampus = cService.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void cleanStudent() {
	this.init();
	}
	
	public String Modifpre(Student st) {
		this.setI(st);
		return "studentMod.xhtml";
	}
	public void modificar() {
		try {
			iService.modificar(this.i);
			cleanStudent();
			this.list();
		}catch(Exception e) {
			e.getMessage();
			}
	}

	
	
	// getters y setters
	public IstudentService getiService() {
		return iService;
	}

	public void setiService(IstudentService iService) {
		this.iService = iService;
	}

	public Student getI() {
		return i;
	}

	public void setI(Student i) {
		this.i = i;
	}

	public List<Student> getListaStudent() {
		return listaStudent;
	}

	public void setListaStudent(List<Student> listaStudent) {
		this.listaStudent = listaStudent;
	}

	public IcampusService getcService() {
		return cService;
	}

	public void setcService(IcampusService cService) {
		this.cService = cService;
	}

	public Campus getC() {
		return c;
	}

	public void setC(Campus c) {
		this.c = c;
	}

	public List<Campus> getListaCampus() {
		return listaCampus;
	}

	public void setListaCampus(List<Campus> listaCampus) {
		this.listaCampus = listaCampus;
	}

	
}
