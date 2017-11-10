package service;

import java.util.List;

import bean.Custom;
import bean.User;
import dao.CustomDao;
import daoimle.CustomDaoImpl;

public class CustomService {
        private CustomDao cd = new CustomDaoImpl();
        
        public boolean Login(User user) {
        	return cd.Login(user);
        }
        
        public boolean Register(Custom ct) {
        	return cd.Register(ct);
        }
        
        public List<Custom> getAll(){
        	return cd.getAll();
        }
}
