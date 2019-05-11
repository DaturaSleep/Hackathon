package models;

import java.util.List;
import java.util.Map;

public class ProjectModel {
	private String name;
	private String description;
	private Integer percentsOfDoneWork = 0;
	private CategoryModel category;
	private Map<String, Boolean> targets;
	private List<UserModel> listOfUsers;
	private Long chatId;
	
	public ProjectModel(String name,String description) {
		this.setName(name);
		this.setDescription(description);
		
	}
	public void addUser(UserModel user) {
		if(!this.listOfUsers.contains(user)) {
			this.listOfUsers.add(user);
			user.addProject(this);
		}
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public Map<String, Boolean> getTargets() {
		return targets;
	}

	public void setTargets(Map<String, Boolean> targets) {
		this.targets = targets;
	}

	public List<UserModel> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(List<UserModel> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}

	public Long getChatId() {
		return chatId;
	}

	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}

}
