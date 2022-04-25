package com.mycompany;

import com.mycompany.user.User;
import com.mycompany.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAssNew() {
        User user = new User();
        user.setEmail("osamasaeed@yahoo.com");
        user.setPassword("123456789");
        user.setFirstname("osama");
        user.setLastname("saeed");

        User savedUser =  repo.save(user);

        Assertions.assert(savedUser).isNotNull();
        Assertions.assertThat(savedUser).getId().isGreaterThan(0);
    }
}
