package model;

public record GroupData(String name, String header, String footer) {

    // явно указываем второй конструктор (первый заложен вверху в record)
    public GroupData() {
        // создаем объект, вызывая тот конструктор, который создается в record по дефолту
        this("","","");
    }

    public GroupData withName(String name) {
        // вернуть объект с другим именем, а хэдер и футер такие же как у существующего объекта
        return new GroupData(name, this.header, this.footer);
    }

    public GroupData withHeader(String header) {
        // вернуть объект с другим хэдером, а имя и футер такие же как у существующего объекта
        return new GroupData(this.name, header, this.footer);
    }

    public GroupData withFooter(String footer) {
        // вернуть объект с другим футером, а хэдер и нейм такие же как у существующего объекта
        return new GroupData(this.name, this.header, footer);
    }
}