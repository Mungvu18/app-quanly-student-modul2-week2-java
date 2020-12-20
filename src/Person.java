import java.util.Scanner;

public class Person {
    private String name;
    String gender;
    String birthday;
    String address;

    public Person() {
    }

    public Person(String name, String gender, String birthday, String address) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }
    public void inputInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name");
        name = input.nextLine();
        System.out.println("Enter gender");
        gender = input.nextLine();
        System.out.println("Enter birthday");
        birthday = input.nextLine();
        System.out.println("Enter address");
        address = input.nextLine();
    }
    public void showInfo(){
        System.out.print("Name: " + name +", gender " + gender +", birthday "+birthday +", address "+address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
