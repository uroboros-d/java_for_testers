package model;

public record Contact(String firstname,
                      String middlename,
                      String lastname,
                      String nickname,
                      String title,
                      String company,
                      String address,
                      String home,
                      String mobile,
                      String work,
                      String fax,
                      String email,
                      String email2,
                      String email3,
                      String homepage){
    public Contact(){
        this("","","","","","","","","","","","","","","");
    }

//метод создает новый контакт со всеми данными контакта, к которому метод применяется,
//кроме значения поля firstname - оно передается в методе
    public Contact withName(String firstname) {
        return new Contact(firstname, this.middlename, this.lastname,
                this.nickname, this.title, this.company, this.address,
                this.home, this.mobile, this.work, this.fax, this.email,
                this.email2, this.email3, this.homepage);
    }
}