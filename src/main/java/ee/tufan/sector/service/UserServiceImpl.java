package ee.tufan.sector.service;

import ee.tufan.sector.model.User;
import ee.tufan.sector.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Override
	public User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return userRepository.getOne(authentication.getName());
	}

	@Override
	public User saveCurrentUser(User user) {
		User current = getCurrentUser();
		current.setName(user.getName());
		current.setUserSectorList(user.getUserSectorList());
		return userRepository.save(current);
	}

	@Autowired
	@Qualifier("userRepository")
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
