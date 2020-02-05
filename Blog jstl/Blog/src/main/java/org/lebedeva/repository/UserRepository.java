package org.lebedeva.repository;

import org.lebedeva.model.user.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class UserRepository {

    private List<User> users;
    private AtomicInteger id;

    private static volatile UserRepository instance;

    private UserRepository() {
        users = new CopyOnWriteArrayList<>();
        id = new AtomicInteger(-1);
        init();
    }

    public static UserRepository getInstance() {
        UserRepository localInstance = instance;
        if (localInstance == null) {
            synchronized (UserRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new UserRepository();
                }
            }
        }
        return localInstance;
    }

    public void save(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public int setId() {
        return id.incrementAndGet();
    }

    public void init() {
        User user = User.builder().id(setId()).login("user@com").password("123").build();
        users.add(user);
    }
}



