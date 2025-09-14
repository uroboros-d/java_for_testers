package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import common.CommonFunctions;
import model.Contact;
import model.Group;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Generator {
    //объявление набора св-тв, которые соотв-ют параметрам запуска
    //св-во описывает тип генерируемых значений
    //можно будет использовать длинную запись или короткую при испльзовании этого параметра
    @Parameter(names = {"--type", "-t"})
    String type;

    //св-во описывает название файла значений
    @Parameter(names = {"--output", "-o"})
    String output;

    // св-во описывает формат генерируемых значений
    @Parameter(names = {"--format", "-f"})
    String format;

    // св-во описывает кол-во генерируемых объектов
    @Parameter(names = {"--count", "-c"})
    int count;

    public static void main(String[] args) throws IOException {
        var generator = new Generator();
        //считывает пар-ры ком строки из args и помещает в объект generator
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        //генерир-ся объекты
        generator.run();
    }

    private void run() throws IOException {
        var data = generate();
        save(data);
    }

    private Object generate() {
        //если в параметрах указано groups, то сгенерировать список групп
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generateContacts();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных " + type);
        }
    }

    private Object generateGroups() {
        //создаем список объектов типа Group
        var result = new ArrayList<Group>();
        //цикл до параметра count генерирует объекты Group и добавляет их в список
        for (int i = 0; i < count; i++) {
            result.add(new Group()
                    .withName(CommonFunctions.randomString(i * 10))
                    .withHeader(CommonFunctions.randomString(i * 10))
                    .withFooter(CommonFunctions.randomString(i * 10))
            );
        }
        //метод возвращает список сгенерированных объектов Group
        return result;
    }

    private Object generateContacts() {
        //создаем список объектов типа Contact
        var result = new ArrayList<Contact>();
        //цикл до параметра count генерирует объекты Contact и добавляет их в список
        for (int i = 0; i < count; i++) {
            result.add(new Contact()
                    .withLastname(CommonFunctions.randomString(i * 10))
                    .withFirstname(CommonFunctions.randomString(i * 10))
            );
        }
        //метод возвращает список сгенерированных объектов Contact
        return result;
    }


    private void save(Object data) throws IOException {
        if ("json".equals(format)) {
            //создать объект ObjectMapper - он будет преобразовывать
            ObjectMapper mapper = new ObjectMapper();
            //сделать json не в одну строку
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            // с помощью mapper сохраняем в файл из переменной output данные data
            mapper.writeValue(new File(output), data);
        } else {
            throw new IllegalArgumentException("Неизвестный формат данных " + format);
        }
    }
}
