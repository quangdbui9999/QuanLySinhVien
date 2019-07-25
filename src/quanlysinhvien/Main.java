package quanlysinhvien;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private static MyClass myClass;
    private static Scanner sc = new Scanner(System.in);
    
    private static void getAverageClassMark(){
        DecimalFormat fmt = new DecimalFormat("0.00");
        System.out.println("Diem trung binh cua lop: " + fmt.format(myClass.getAverageMark()));
    }
    
    private static void getAverageClassMarkMath(){
        DecimalFormat fmt = new DecimalFormat("0.00");
        System.out.println("Diem trung binh mon Toan cua lop: " + fmt.format(myClass.getAverageMarkMath()));
    }
    
    private static void displayAllStudentClass(){
        myClass.displayAllStudents();
    }
    
    private static void insertStudent(){
        System.out.println("\nChuc nang them sinh vien:");
        System.out.print("Nhap so luong sinh vien can them: ");
        int num = sc.nextInt();
        sc.nextLine();
        System.out.println("Ban dong y them " + num + " sinh vien.");
        
        for(int i = 0; i < num; i++){
            System.out.println("Them sinh vien thu " + (i + 1) + ":");
            Student student = new Student();
            myClass.addStudent(student);
        }
    }
    
    private static void editStudent(){
        System.out.println("Chuc nang sua thong tin sinh vien");
        System.out.print("Nhap ma so sinh vien can sua");
        String id = sc.nextLine();
        myClass.modifyStudent(id);
    }
    
    private static void deleteStudent(){
        String id = "";
        System.out.print("Nhap ma so sinh vien can xoa: ");
        id = sc.nextLine();
        myClass.removeStudent(id);
    }
    
    private static void modifyMarkClass(){
        String id = "";
        System.out.print("Nhap ma so sinh vien can sua diem: ");
        id = sc.nextLine();
        myClass.modifyStudentMark(id);
    }
    
    private static void searchStudentClass(){
        String id = "";
        System.out.print("Nhap ma so sinh vien can tim kiem: ");
        id = sc.nextLine();
        myClass.searchStudent(id);
    }
    
    private static void listStudentPass(){
        ArrayList<Student> passStudent = myClass.getPassStudentList();
        for(Student whoPass : passStudent){
            whoPass.display();
            System.out.println();
        }
    }
    
    private static void bestStudentMathClass(){
        ArrayList<Student> whoBest = myClass.findBestMathStudent();
        for(int i = 0; i < whoBest.size(); i++){
            whoBest.get(i).display();
            System.out.println();
        }
        System.out.println();
    }
    
    private static void sortAverage(){
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getAverage() < o2.getAverage()){
                    return 1;
                } else if(o1.getAverage() == o2.getAverage()){
                    return 0;
                } else {
                    return -1;
                }
            }
        };
        Collections.sort(myClass.getStudentList(), comparator);
    }
    
    private static void printMenuChoice() {
        System.out.println("Vui long chon 1 trong cac chuc nang");
        System.out.println("1. Them sinh vien");
        System.out.println("2. Sua sinh vien");
        System.out.println("3. Xoa sinh vien");
        System.out.println("4. In ra danh sach toan bo sinh vien");
        System.out.println("5. Tim kiem sinh vien");
        System.out.println("6. Sua diem sinh vien theo mon hoc");
        System.out.println("7. Diem trung binh cua lop (mon Toan).");
        System.out.println("8. Diem trung binh cua lop.");
        System.out.println("9. Danh sach sinh vien dau.");
        System.out.println("10. Sinh vien gioi Toan.");
        System.out.println("11. Sap xep theo diem trung binh.");
        System.out.println("0. Thoat chuong trinh");
    }
    
    public static void main(String[] args) {
        myClass = new MyClass("Computer Science");
        myClass.listStudentCreated();
        System.out.println("Chuong trinh quan ly sinh vien lop " + myClass.getName());
        boolean flag = true;
        while (flag) {
            printMenuChoice();
            System.out.print("Nhap su lua chon: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
            case 1:
                insertStudent();
                break;
            case 2:
                editStudent();
                break;
            case 3:
                deleteStudent();
                break;
            case 4:
                displayAllStudentClass();
                break;
            case 5:
                searchStudentClass();
                break;
            case 6:
                modifyMarkClass();
                break;
            case 7:
                getAverageClassMarkMath();
                break;
            case 8:
                getAverageClassMark();
                break;
            case 9:
                listStudentPass();
                break;
            case 10:
                bestStudentMathClass();
                break;
            case 11:
                sortAverage();
                break;
            case 0:
                System.out.println("Thoat chuong trinh");
                flag = false;
                break;

            }
        }
        System.out.println("Chuong trinh ket thuc");
    }
}
