package manager;
import manager.hbm.ContactRecord;
import manager.hbm.GroupRecord;
import model.Contact;
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
                .addAnnotatedClass(ContactRecord.class)
                .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook")
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    //преобразует список объектов GroupRecord в список объектов Group
    static List<Group> convertList(List<GroupRecord> records) {
        List<Group> result = new ArrayList<>();
        for (var record : records) {
            result.add(convert(record));
        }
        return result;
    }

    //конвертирует 1 запись в объект Group
    private static Group convert(GroupRecord record) {
        return new Group("" + record.id, record.name, record.header, record.footer);
    }

    private static GroupRecord convert(Group group) {
        var id = group.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), group.name(), group.header(), group.footer());
    }

    public List<Group> getGroupList() {
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }

    public long getGroupCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupRecord", Long.class).getSingleResult();
        });
    }

    public void createGroup(Group group) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(group));
            session.getTransaction().commit();
        });
    }

    public List<Contact> getContactList() {
        return convertContactList(sessionFactory.fromSession(session -> {
            return session.createQuery("from ContactRecord", ContactRecord.class).list();
        }));
    }

    //преобразует список объектов ContactRecord в список объектов Contact
    static List<Contact> convertContactList(List<ContactRecord> records) {
        List<Contact> result = new ArrayList<>();
        for (var record : records) {
            result.add(convertContact(record));
        }
        return result;
    }

    private static Contact convertContact(ContactRecord record) {
        return new Contact("" + record.id, record.firstname, record.middlename, record.lastname, record.address, record.email, record.company, record.mobile, record.photo);
    }
}
