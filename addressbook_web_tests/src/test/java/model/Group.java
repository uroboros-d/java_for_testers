package model;

public record Group(String name, String header, String footer) {

    // явно указываем второй конструктор (первый заложен вверху в record)
    public Group() {
        // создать объект с 0 параметров, вызывая тот конструктор, который создается в record по дефолту
        this("","","");
    }

    public Group withName(String name) {
        // вернуть объект с другим именем, а хэдер и футер такие же как у существующего объекта
        return new Group(name, this.header, this.footer);
    }

    public Group withHeader(String header) {
        // вернуть объект с другим хэдером, а имя и футер такие же как у существующего объекта
        return new Group(this.name, header, this.footer);
    }

    public Group withFooter(String footer) {
        // вернуть объект с другим футером, а хэдер и нейм такие же как у существующего объекта
        return new Group(this.name, this.header, footer);
    }
}