import java.util.Scanner;

public class Student extends Person {
    String rollNo;
    float mark;
    String email;

    public Student() {
    }

    public String getRollNo() {
        return rollNo;
    }

    public boolean setRollNo(String rollNo) {
        if (rollNo != null && rollNo.length() == 8) {
            this.rollNo = rollNo;
            return true;
        } else {
            System.err.println("Please Enter again rollNo with length is 8");
            return false;
        }
    }

    public float getMark() {
        return mark;
    }

    public boolean setMark(float mark) {
        if(mark>=0&&mark<=10) {
            this.mark = mark;
            return true;
        } else{
            System.err.println("You have to enter mark again with mark into[0,10]");
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(email !=null && email.contains("@")&&!email.contains(" ")) {
            this.email = email;
            return true;
        } else {
            System.err.println("Enter email again");
            return false;
        }
    }
    public boolean checkScholarship() {
        return mark >= 8;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.print("; roll: "+rollNo+ "; mark: " + mark + "; email: " + email+"\n");
        System.out.println("-----------------");
    }

    @Override
    public void inputInfo() {
        super.inputInfo(); // giu lai de trach nhap giu lieu cu
        Scanner input = new Scanner(System.in);
        addId(input);
        addMark(input);
        addEmail(input);
        System.out.println("---------");
    }

    private void addEmail(Scanner input) {
        do {
            System.out.println("Enter email");
            email = input.nextLine();
        }while ((!setEmail(email)));
    }

    private void addMark(Scanner input) {
        do {
            System.out.println("Enter mark of student:");
            mark =Float.parseFloat(input.nextLine());
        }while (!setMark(mark));
    }

    private void addId(Scanner input) {
        do {
            System.out.println("Enter ID of Student");
            rollNo = input.nextLine();
        }while (!setRollNo(rollNo));
    }
}
