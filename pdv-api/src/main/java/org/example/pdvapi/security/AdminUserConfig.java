package org.example.pdvapi.security;

import jakarta.transaction.Transactional;
import org.example.pdvapi.entities.Role;
import org.example.pdvapi.entities.Usuario;
import org.example.pdvapi.repositories.RoleRepository;
import org.example.pdvapi.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;
import java.util.Optional;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public AdminUserConfig(RoleRepository roleRepository,
                           UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Optional<Role> roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());
        Role role = new Role();
        if (roleAdmin.isPresent()){
            role = roleAdmin.get();
            System.out.println("Role admin já existe");
        } else {
            role = new Role();
            role.setName(Role.Values.ADMIN.name());
            roleRepository.save(role);
        }
        Role roleAux = new Role();
        roleAux.setId(role.getId());
        roleAux.setName(role.getName());


        Optional<Usuario> userAdmin = userRepository.findByUsernameIgnoreCase("admin");

        if (userAdmin.isPresent()) {
            System.out.println("admin já existe");
        } else {
            Usuario user = new Usuario();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("123"));
            List<Role> roles = List.of(roleAux);
            user.setRoles(roles);
            userRepository.save(user);
        }
    }

}