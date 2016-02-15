package administrate.service.impl;

import administrate.dao.UserDao;
import administrate.dao.impl.UserDaoImpl;
import administrate.db.HibernateUtil;
import administrate.entity.Phone;
import administrate.entity.User;
import administrate.service.UserService;

import java.util.List;

/**
 * Created by USER on 15.02.2016.
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> setUsers() {

        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().begin();
        List<User> users = dao.getAll();

        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        HibernateUtil.getSessionFactory().getCurrentSession().close();

        return users;
    }


}
