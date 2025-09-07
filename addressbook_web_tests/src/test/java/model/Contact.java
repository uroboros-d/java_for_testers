package model;

public record Contact(String id, String firstname, String lastname, String address, String email, String mobile, String photo) {

    public Contact() {
        this("", "", "", "", "", "", "");
    }

    //метод создает новый контакт со всеми данными контакта, к которому метод применяется,
    //кроме значения поля firstname - оно передается в методе
    public Contact withFirstname(String firstname) {
        return new Contact(this.id, firstname, this.lastname, this.address, this.email, this.mobile, this.photo);
    }

    public Contact withLastname(String lastname) {
        return new Contact(this.id, this.firstname, lastname, this.address, this.email, this.mobile, this.photo);
    }

    public Contact withAddress(String address) {
        return new Contact(this.id, this.firstname, this.lastname, address, this.email, this.mobile, this.photo);
    }

    public Contact withEmail(String email) {
        return new Contact(this.id, this.firstname, this.lastname, this.address, email, this.mobile, this.photo);
    }

    public Contact withMobile(String mobile) {
        return new Contact(this.id, this.firstname, this.lastname, this.address, this.email, mobile, this.photo);
    }

    public Contact withId(String id) {
        return new Contact(id, this.firstname, this.lastname, this.address, this.email, this.mobile, this.photo);
    }

    public Contact withPhoto(String photo) {
        return new Contact(this.id, this.firstname, this.lastname, this.address, this.email, this.mobile, photo);
    }
}