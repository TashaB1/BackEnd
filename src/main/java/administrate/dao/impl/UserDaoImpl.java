package administrate.dao.impl;

import administrate.dao.AbstractHibernateDao;
import administrate.dao.UserDao;
import administrate.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Created by USER on 03.02.2016.
 */
public class UserDaoImpl extends AbstractHibernateDao<User,Long> implements UserDao {

}
