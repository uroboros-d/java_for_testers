package model;

public record Contact(String id,
                      String firstname,
                      String middlename,
                      String lastname,
                      String address,
                      String email,
                      String mobile,
                      String photo,
                      String company,
                      String home,
                      String work,
                      String phone2) {

    public Contact() {
        this("", "", "", "", "", "", "", "", "", "", "", "");
    }

    //метод создает новый контакт со всеми данными контакта, к которому метод применяется,
    //кроме значения поля firstname - оно передается в методе
    public Contact withFirstname(String firstname) {
        return new Contact(this.id, firstname, this.middlename, this.lastname, this.address, this.email, this.mobile, this.photo, this.company, this.home, this.work, this.phone2);
    }

    public Contact withMiddlename(String middlename) {
        return new Contact(this.id, this.firstname, middlename, this.lastname, this.address, this.email, this.mobile, this.photo, this.company, this.home, this.work, this.phone2);
    }

    public Contact withLastname(String lastname) {
        return new Contact(this.id, this.firstname, this.middlename, lastname, this.address, this.email, this.mobile, this.photo, this.company, this.home, this.work, this.phone2);
    }

    public Contact withAddress(String address) {
        return new Contact(this.id, this.firstname, this.middlename, this.lastname, address, this.email, this.mobile, this.photo, this.company, this.home, this.work, this.phone2);
    }

    public Contact withEmail(String email) {
        return new Contact(this.id, this.firstname, this.middlename, this.lastname, this.address, email, this.mobile, this.photo, this.company, this.home, this.work, this.phone2);
    }

    public Contact withId(String id) {
        return new Contact(id, this.firstname, this.middlename, this.lastname, this.address, this.email, this.mobile, this.photo, this.company, this.home, this.work, this.phone2);
    }

    public Contact withPhoto(String photo) {
        return new Contact(this.id, this.firstname, this.middlename, this.lastname, this.address, this.email, this.mobile, photo, this.company, this.home, this.work, this.phone2);
    }

    public Contact withCompany(String company) {
        return new Contact(this.id, this.firstname, this.middlename, this.lastname, this.address, this.email, this.mobile, this.photo, company, this.home, this.work, this.phone2);
    }

    public Contact withMobile(String mobile) {
        return new Contact(this.id, this.firstname, this.middlename, this.lastname, this.address, this.email, mobile, this.photo, this.company, this.home, this.work, this.phone2);
    }

    public Contact withHome(String home) {
        return new Contact(this.id, this.firstname, this.middlename, this.lastname, this.address, this.email, this.mobile, this.photo, this.company, home, this.work, this.phone2);
    }

    public Contact withWork(String work) {
        return new Contact(this.id, this.firstname, this.middlename, this.lastname, this.address, this.email, this.mobile, this.photo, this.company, this.home, work, this.phone2);
    }

    public Contact withPhone2 (String phone2) {
        return new Contact(this.id, this.firstname, this.middlename, this.lastname, this.address, this.email, this.mobile, this.photo, this.company, this.home, this.work, phone2);
    }
}