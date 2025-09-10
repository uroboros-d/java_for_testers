package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import common.commonFunctions;
import model.Group;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Generator {
    //параметр, описывающий тип генерируемых значений
    //можно будет использовать длинную запись или короткую при испльзовании этого параметра
    @Parameter(names={"--type", "-t"})
    String type;

    @Parameter(names={"--output", "-o"})
    String output;

    @Parameter(names={"--format", "-f"})
    String format;

    @Parameter(names={"--count", "-c"})
    int count;

    public static void main(String[] args) throws IOException {
        //создать новый генератор и запустить
        var generator = new Generator();
        //анализирует код командной строки
        //создается парсер коммандной строки, который будет анализировать
        //параметры, описанные в объекте generator, а потом на вход этому
        //парсеру передаются аргументы
        //после того как парсер отработает, в объекте genereator
        //в соотв св-вах будут прописаны значения, переданные в @Parameter
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        generator.run();
    }

    private void run() throws IOException {
        //сгенерировать данные
        var data = generate();
        //сохранить
        save(data);
    }

    private void save(Object data) throws IOException {
        if ("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            //результат преобразования поместим в переменную json
            var json = mapper.writeValueAsString(data);
            //запишем в файл
            try(var writer = new FileWriter(output)) {
                writer.write(json);
            }
        } else {
            throw new IllegalArgumentException("Неизвестный формат данных " + format);
        }
    }

    private Object generate(){
        if("groups".equals(type)){
            return generateGroups();
        } else if ("contacts".equals(type)){
            return generateContacts();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных " + type);
        }
    }

    private Object generateGroups() {
        //создаем список объектов типа Group
        var result = new ArrayList<Group>();
        //цикл до параметра count генерирует объекты Group и добавляет их в список
        for (int i=0; i<count; i++){
            result.add(new Group()
                    .withName(commonFunctions.randomString(i*10))
                    .withHeader(commonFunctions.randomString(i*10))
                    .withFooter(commonFunctions.randomString(i*10)));
        }
        //метод возвращает список сгенерированных объектов Group
        return result;
    }

    private Object generateContacts() {
        return null;
    }
}
