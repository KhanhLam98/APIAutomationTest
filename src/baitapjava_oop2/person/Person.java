package baitapjava_oop2.person;

public class Person {
    public String name;
    public int age;
    public String gender;
    protected String address;
    protected String phone;


    //Ham Constructor khong co tham so
    public Person (){
        System.out.println("***Employee Information***");
    }
    //Ham Constructor co tham so
    public Person(String name, int age, String gender, String address, String phone){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    //Ham in thong tin
    public void showInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
    }

    //Ham get de goi thong tin cho class Company
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
}
