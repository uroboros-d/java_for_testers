package model;

public record GroupData(String name, String header, String footer) {
    // явно указываем второй конструктор (первый заложен вверху в record)
    public GroupData() {
        // создаем объект, вызывая тот конструктор, который создается в record по дефолту
        this("","","");
    }
}