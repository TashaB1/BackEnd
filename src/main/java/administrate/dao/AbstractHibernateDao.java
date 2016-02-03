package administrate.dao;

import org.hibernate.Criteria;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Convert2Diamond")
public abstract class AbstractHibernateDao<T, PK extends Serializable> implements GenericDao<T, PK> {


	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	protected Session getSession() {
        return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	protected Class<T> getGenericEntityClass() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked") //подавляет предупреждения компилятора
	public PK save(T obj) {
        Session session=getSession();
        return (PK) session.save(obj);
	}

	public void update(T o) {
		getSession().update(o);		
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Criteria cr = getSession().createCriteria(getGenericEntityClass());
		return (List<T>) cr.list();
	}

    public Long getLength(){
        return (Long) getSession().createCriteria(getGenericEntityClass()).setProjection( Projections.rowCount() ).uniqueResult();
    }

	@SuppressWarnings("unchecked")
	public List<T> getByCriteria(Criterion criterion) {
		Criteria criteria = getSession().createCriteria(getGenericEntityClass());
		criteria.add(criterion);
		return (List<T>) criteria.list();
	}

    @SuppressWarnings("unchecked")
    public Long getLength(Criterion criterion) {
        Criteria criteria = getSession().createCriteria(getGenericEntityClass());
        criteria.add(criterion);
        return (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<T> getByCriteria(Criterion criterion, int begin, int count) {
        if(begin< 0 ||count<0){
            return new ArrayList<T>();
        }
        Criteria criteria = getSession().createCriteria(getGenericEntityClass());
        if(criterion!=null){
            criteria.add(criterion);
        }
        criteria.setFirstResult(begin).setMaxResults(count);
        return (List<T>)criteria.list();
    }

    @SuppressWarnings("unchecked")
	public T getById(PK id) {
		return (T) getSession().get(getGenericEntityClass(), id);
	}

	@SuppressWarnings("unchecked")
	public void delete(PK id) {
		T persistentObject = (T) getSession().load(getGenericEntityClass(), id);
		try {
			getSession().delete(persistentObject);
		} catch (NonUniqueObjectException e) {
			// in a case of detached object
			T instance = (T) getSession().merge(persistentObject);
			getSession().delete(instance);
		}
	}

	@SuppressWarnings("unchecked")
	public void delete(T persistentObject) {
		try {
			getSession().delete(persistentObject);
		} catch (NonUniqueObjectException e) {
			// in a case of detached object
			T instance = (T) getSession().merge(persistentObject);
			getSession().delete(instance);
		}
	}
}
