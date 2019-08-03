package ee.tufan.sector.service;

import ee.tufan.sector.model.User;

public interface UserService {

	User getCurrentUser();

	User saveCurrentUser(User user);

}
