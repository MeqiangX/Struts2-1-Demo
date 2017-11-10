package dao;

import java.util.List;

import bean.Custom;
import bean.User;

public interface CustomDao {
     public boolean Login(User user);
     public boolean Register(Custom ct);
     public List<Custom> getAll();
}
