package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        this.modelData.setUsers(getAllUsers());
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        User orUpdateUser = userService.createOrUpdateUser(name, id, level);
        this.modelData.setUsers(getAllUsers());
    }

    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setDisplayDeletedUserList(true);
        this.modelData.setUsers(users);
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        this.modelData.setUsers(getAllUsers());
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }
    private List<User> getAllUsers() {
        List<User> usersBetweenLevels = userService.getUsersBetweenLevels(1, 100);
        return  userService.filterOnlyActiveUsers(usersBetweenLevels);
    }
}
