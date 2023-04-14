package com.rajdeep.restfulwebservice.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;
    static {
        users.add(new User(1, "Rajdeep", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Rahul", LocalDate.now().minusYears(32)));
        users.add(new User(3, "Rajib", LocalDate.now().minusYears(35)));
    }

    public static List<User> findAll() {
        return users;
    }
    public static User findOne(int id) {
        User userObj = users.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        return userObj;
    }

    public static User createOne (User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public static void deleteById(int id) {
        Predicate<User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }
}
