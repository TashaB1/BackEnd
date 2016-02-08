import administrate.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import ru.mail.tasha2k7.entity.Patient;

/**
 * Created by Wolfsjunge on 07.02.2016.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().addPackage("ru.mail.tasha2k7.entity").addAnnotatedClass(User.class)
                    .configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close(){
        sessionFactory.close();
    }
}
