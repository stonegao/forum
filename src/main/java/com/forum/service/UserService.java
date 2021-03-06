package com.forum.service;

import com.forum.domain.Country;
import com.forum.domain.Privilege;
import com.forum.domain.User;
import com.forum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(int id) {
        return userRepository.getById(id);
    }

    public List<Country> getAvailableCountries() {
        List<Country> countries = new ArrayList<Country>();
        Scanner scanner = null;
        InputStream countriesInputStream = UserService.class.getClassLoader().getResourceAsStream("countries.txt");
        scanner = new Scanner(countriesInputStream);
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            Country country = new Country(string, string);
            countries.add(country);
        }
        scanner.close();
        return countries;
    }

    public boolean checkExistenceOfUsername(String username) {
        if (userRepository.getByUsername(username) == null)
            return false;
        return true;
    }

    public boolean checkExistenceOfEmail(String email) {
        if(userRepository.getByEmail(email) == null)
            return false;
        return true;
    }

    public void validate(User user) throws BadCredentialsException{
        if(userRepository.getByUsername(user.getUsername()) == null) throw new BadCredentialsException("The user name is invalid");
        String passwordFromDatabase = userRepository.getPasswordByUsername(user.getUsername());
        if(!((passwordFromDatabase).equals(user.getPassword()))) throw new BadCredentialsException("The password is incorrect");
    }


    public int createUser(User user) throws  RuntimeException {
        int expectedRowCount = user.getExpectedRowCount();
        int actualRowCount = userRepository.createUser(user);

        if ( actualRowCount != expectedRowCount)
            throw new RuntimeException(
                    "user object has not been fully stored in the database, user is " + user.toString()
            );

        return actualRowCount;
    }

    public Privilege getRole(User user) {
        int privilege =  userRepository.getUserPrivilege(user);
        return Privilege.getPrivilege(privilege);
    }

    public User getByUserName(String username) {
        return userRepository.getByUsername(username);
    }
}
