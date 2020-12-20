import java.util.*;

public class StudentTest {

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int ZERO = 0;

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            showMenu();
            System.out.println("Choose: ");
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case ONE:
                    int n;
                    System.out.println("Nhap so sinh vien can them: ");
                    n = Integer.parseInt(sc.nextLine());
                    for (int i = 0 ; i < n ; i++){
                        Student std = new Student();
                        std.inputInfo();
                        studentList.add(std);
                    }
                    break;
                case TWO:
                    displayList(studentList);
                    break;
                case THREE:
                    findMinMaxOfMark(studentList);
                    break;
                case FOUR:
                    System.out.println(" nhap ma rollNo de tim kiem");
                    String rollNoSearch = sc.nextLine();
                    findStudentById(studentList, rollNoSearch);
                    break;
                case FIVE:
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            int cmp = o1.getName().compareTo(o2.getName());
                            if(cmp>=0){
                                return 1;
                            }
                            return -1;
                        }
                    });

                    displayList(studentList);
                    break;
                case SIX:
                    Collections.sort(studentList, new Comparator<Student>() {
                        @Override
                        public int compare(Student o1, Student o2) {
                            return o1.getMark()>o2.getMark()? -1:1;
                        }
                    });
                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).checkScholarship();
                        studentList.get(i).showInfo();
                    }
                    break;
                case ZERO:
                    System.exit(0);
                    System.out.println("Goodbye you!");
                    break;
                default:
                    System.err.println("Nhap sai");
            }

        } while (choose !=ZERO);

    }

    private static void findStudentById(ArrayList<Student> studentList, String rollNoSearch) {
        int  count = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getRollNo().equalsIgnoreCase(rollNoSearch)){
                studentList.get(i).showInfo();
                count ++;
            }
        }
        if(count==0){
            System.out.println("Khong tim thay sinh vien nao");
        }
    }

    private static void findMinMaxOfMark(ArrayList<Student> studentList) {
        int minIndex = 0, maxIndex = 0;
        float minMark,maxMark;
        minMark = studentList.get(0).getMark();
        maxMark = studentList.get(0).getMark();
        for (int i = 1; i < studentList.size(); i++) {
            if(studentList.get(i).getMark()<minMark){
                minIndex = i;
                minMark = studentList.get(i).getMark();
            }
            if(studentList.get(i).getMark()>maxMark){
                maxIndex = i;
                maxMark = studentList.get(i).getMark();
            }
        }
        System.out.println("Sinh vien co diem trung binh cao nhat");
        System.out.println(studentList.get(maxIndex).getName()+ " vơi số điếm: " + studentList.get(maxIndex).getMark());
        System.out.println("sinh vien co diem trung binh thap nhat");
        System.out.println(studentList.get(minIndex).getName()+ " vơi số điếm: " + studentList.get(minIndex).getMark());
    }

    private static void displayList(ArrayList<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).showInfo();
        }
    }

    static void showMenu() {
        System.out.println("1. Nhap vao N sinh vien");
        System.out.println("2. Hien thi thong tin sinh");
        System.out.println("3. Hien thi max min theo diem avg ");
        System.out.println("4. Tim kiem va hien thi theo ma sinh vien ");
        System.out.println("5. sort A=>Z theo ten sv va hien thi");
        System.out.println("6. Hien thi sinh vien duoc hoc bong va sort mark giam dan ");
        System.out.println("0. Exit app");
    }
}
