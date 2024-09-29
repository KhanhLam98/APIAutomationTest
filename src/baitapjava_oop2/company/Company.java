package baitapjava_oop2.company;

import baitapjava_oop2.person.Person;

public class Company {
    private Person person;
    public Company (Person person){
        this.person = person;
    }
    public void getInfo(){
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Gender: " + person.getGender());
    }
    public static void main(String[] args) {
        Person person1 = new Person("Tung",30,"Nam","Ha Noi","665869865");
        Company company = new Company(person1);
        company.getInfo();
    }
}
