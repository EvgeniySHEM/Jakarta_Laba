package ru.sanctio.jakarta_laba;

import java.util.HashSet;
import java.util.Set;

public class UserStore {
    private static Set<User> users;

    static {
        users = new HashSet<>();
        users.add(new User("Andrey", "123qwe"));
        users.add(new User("Michail", "123qwe"));
        users.add(new User("Olga", "123qwe"));
        users.add(new User("Yana", "123qwe"));
        users.add(new User("Alexandr", "123qwe"));
    }

    public boolean checkUser(String username, String password) {
        return users.contains(new User(username, password));
    }
}
