package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

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

    public static void main(String[] args) {
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

    private void run() {
        //сгенерировать данные
        var data = generate();
        //сохранить
        save(data);
    }

    private void save(Object data) {
    }

    private Object generate(){
        return null;
    }
}
