package model;

public record Contact(String id,String firstname,String lastname,String address,String email,String mobile) {

    public Contact() {
        this("", "", "", "", "", "");
    }

    //метод создает новый контакт со всеми данными контакта, к которому метод применяется,
    //кроме значения поля firstname - оно передается в методе
    public Contact withFirstame(String firstname) {
        return new Contact("", firstname,this.lastname,this.address,this.email,this.mobile);
    }

    public Contact withLastame(String lastname) {
        return new Contact("", this.firstname,lastname,this.address,this.email,this.mobile);
    }

    public Contact withAddress(String address) {
        return new Contact("", this.firstname,this.lastname,address,this.email,this.mobile);
    }

    public Contact withEmail(String email) {
        return new Contact("", this.firstname,this.lastname,this.address,email,this.mobile);
    }

    public Contact withMobile(String mobile) {
        return new Contact("", this.firstname,this.lastname,this.address,this.email,mobile);
    }


}