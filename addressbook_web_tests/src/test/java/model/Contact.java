package model;

public record Contact(String firstname,
                      String lastname,
                      String address,
                      String email,
                      String mobile
                      ) {


    public Contact() {
        this("", "", "", "", "");
    }

    //метод создает новый контакт со всеми данными контакта, к которому метод применяется,
    //кроме значения поля firstname - оно передается в методе
    public Contact withNameOnly(String firstname) {
        return new Contact(firstname,this.lastname,this.address,this.email,this.mobile);
    }
}