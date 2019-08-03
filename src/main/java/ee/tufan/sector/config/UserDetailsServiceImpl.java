package ee.tufan.sector.config;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import ee.tufan.sector.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ee.tufan.sector.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.getOne(username);
		if (user == null)
			throw new UsernameNotFoundException(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority("USER"));

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}

	@Autowired
	@Qualifier("userRepository")
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
