package manager;

import model.Contact;
import model.Group;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcHelper extends HelperBase {

    public JdbcHelper(ApplicationManager manager) {
        super(manager);
    }

    public List<Group> getGroupList() {
        //создаем пустой список
        var groups = new ArrayList<Group>();
        //устанавливаем соединение с бд, сохраняя его в переменную conn
        try (
                var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
                var statement = conn.createStatement();
                //выполняем запрос
                var result = statement.executeQuery("SELECT group_id, group_name, group_header, group_footer FROM group_list");
        ) {
            while (result.next()) {
                //извлечь данные из табл и добавить в список новый объект с полями
                groups.add(new Group()
                        //получить значение столбца group_id
                        .withId(result.getString("group_id"))
                        .withName(result.getString("group_name"))
                        .withHeader(result.getString("group_header"))
                        .withFooter(result.getString("group_footer"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return groups;
    }

    public List<Contact> getContactList() {
        var contacts = new ArrayList<Contact>();
        try (
                var conn = DriverManager.getConnection("jdbc:mysql://localhost/addressbook", "root", "");
                var statement = conn.createStatement();
                var result = statement.executeQuery("SELECT id, firstname, middlename, lastname, company, address, email, mobile, company FROM addressbook");
        ) {
            //проходим по каждой строке таблицы
            while (result.next()) {
                //извлечь данные и добавить в список новый объект с этими данными
                contacts.add(new Contact()
                        .withId(result.getString("id"))
                        .withFirstname(result.getString("firstname"))
                        .withMiddlename(result.getString("middlename"))
                        .withLastname(result.getString("lastname"))
                        .withCompany(result.getString("company"))
                        .withAddress(result.getString("address"))
                        .withEmail(result.getString("email"))
                        .withMobile(result.getString("mobile"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }
}

