package com.Services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetailsServiceImpl loadUserByUsername(String username) throws UserPrincipalNotFoundException {

        // Buscar el usuario con el repositorio y si no existe lanzar una exepcion
        com.loginSecurity.entity.User appUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

        // Mapear nuestra lista de Authority con la de spring security
        List grantList = new ArrayList();
        for (Authority authority : appUser.getAuthority()) {
            // ROLE_USER, ROLE_ADMIN,..
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantList.add(grantedAuthority);
        }

        // Crear El objeto UserDetails que va a ir en sesion y retornarlo.
        UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
        return user;
    }
}