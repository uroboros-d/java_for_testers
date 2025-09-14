package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import model.Group;

import java.util.ArrayList;

import static tests.TestBase.randomString;

public class Generator {
    //объявление набора св-тв, которые соотв-ют параметрам запуска
    //св-во описывает тип генерируемых значений
    //можно будет использовать длинную запись или короткую при испльзовании этого параметра
    @Parameter(names={"--type", "-t"})
    String type;

    //св-во описывает название файла значений
    @Parameter(names={"--output", "-o"})
    String output;

    // св-во описывает формат генерируемых значений
    @Parameter(names={"--format", "-f"})
    String format;

    // св-во описывает кол-во генерируемых объектов
    @Parameter(names={"--count", "-c"})
    int count;

    public static void main(String[] args) {
        var generator = new Generator();
        //считывает пар-ры ком строки из args и помещает в объект generator
        JCommander.newBuilder()
                .addObject(generator)
                .build()
                .parse(args);
        //генерир-ся объекты
        generator.run();
    }


    private void run() {
        var data = generate();
        save(data);
    }

    private void save(Object data) {
    }

    private Object generate(){
        //если в параметрах указано groups, то сгенерировать список групп
        if("groups".equals(type)){
            return generateGroups();
        } else if ("contacts".equals(type)){
            return generateContacts();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных " + type);
        }
    }

}
