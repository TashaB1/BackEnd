package ru.mail.tasha2k7;

import administrate.dao.UserDao;
import administrate.dao.impl.UserDaoImpl;
import administrate.db.HibernateUtil;
import administrate.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.junit.Test;

import java.util.List;

/**
 * Created by Wolfsjunge on 08.02.2016.
 */
public class UserDaoTest {
    private UserDao userdao = new UserDaoImpl();

    @Test
    public void toTest() {
        Criterion criteria = Restrictions.eq("id", 1L);
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().begin();
        List<User> users = userdao.getByCriteria(criteria);
        System.out.println("users = " + users);
        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        HibernateUtil.getSessionFactory().getCurrentSession().close();
    }


}
