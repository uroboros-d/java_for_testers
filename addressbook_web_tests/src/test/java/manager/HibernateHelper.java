package manager;
import manager.hbm.GroupRecord;
import model.Group;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    //конструктор, в котором передается ссылка на manager,
    //чтобы класс получил доступ к своему начальнику
    public HibernateHelper(ApplicationManager manager) {
        super(manager);

        sessionFactory = new Configuration()
//                        .addAnnotatedClass(Book.class)
                        .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.JAKARTA_JDBC_URL,
                        "jdbc:mysql://localhost/addressbook")
                // Credentials
                .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "root")
                .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "")
                .buildSessionFactory();
    }

    //преобразует список объектов GroupRecord в список объектов Group
    static List<Group> convertList(List<GroupRecord> records) {
        List<Group> result = new ArrayList<>();
        for (var record : records) {
            result.add(new Group("" + record.id, record.name, record.header, record.footer));
        }
    }

    public List<Group> getGroupList() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        });
    }
}
