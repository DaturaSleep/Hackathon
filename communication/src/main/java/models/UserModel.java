package models;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class UserModel {
	private Integer id;
	private String username;
	private List<ProjectModel> listOfProjects;

	public static TreeMap<Integer, UserModel> allRegistratedUsers = new TreeMap<>();

	public UserModel(Integer id, String username) {
		this.setId(id);
		this.setUsername(username);
		listOfProjects = new ArrayList<>();
		allRegistratedUsers.put(id, this);
		System.out.println(String.format("User created with params: %d and name %s", id, username));
	}

	public void addProject(ProjectModel project) {
		if (!listOfProjects.contains(project)) {
			listOfProjects.add(project);
			project.addUser(this);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<ProjectModel> getListOfProjects() {
		return listOfProjects;
	}

	public void setListOfProjects(List<ProjectModel> listOfProjects) {
		this.listOfProjects = listOfProjects;
	}

}
