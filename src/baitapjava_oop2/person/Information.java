package baitapjava_oop2.person;

public class Information {
    public static void main(String[] args) {
        System.out.println("***First person***");
        Person person1 = new Person("Hoa", 25, "Female", "New York", "012649875");
        person1.showInfo();

        System.out.println(" ");
        System.out.println("***Second person***");
        Person person2 = new Person("Binh", 35, "Male", "Australia", "165579952");
        person2.showInfo();
    }
}
