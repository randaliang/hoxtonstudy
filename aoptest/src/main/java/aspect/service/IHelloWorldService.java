package aspect.service;

import aspect.common.model.User;

public interface IHelloWorldService {

	String getHelloMessage(String name);

	String getHelloMessage();

	public User addUser(User user);

}