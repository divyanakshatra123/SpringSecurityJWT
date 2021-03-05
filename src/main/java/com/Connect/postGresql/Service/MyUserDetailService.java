package com.Connect.postGresql.Service;

import com.Connect.postGresql.Model.MyUserDetails;
import com.Connect.postGresql.Model.User;
import com.Connect.postGresql.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(s);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found" + s));
        return user.map(MyUserDetails::new).get();
    }
}
