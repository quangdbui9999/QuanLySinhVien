package quanlysinhvien;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MyClass {
    private String name;
    private ArrayList<Student> studentList = new ArrayList<Student>();

    public MyClass(){
        
    }

    public MyClass(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    
    public void displayAllStudents(){
        DecimalFormat fmt = new DecimalFormat("0.00");
        System.out.println("\nToan bo thong tin sinh vien.");
        if(studentList.size() == 0){
            System.err.println("Khong co sinh vien trong danh sach");
        }else{
            for(Student element : studentList){
                element.display();
                System.out.println("Điểm trung bình của " + element.getName() + " là: " + fmt.format(element.getAverage()));
                System.out.println("Lệ phí môn học: " + element.calculateFee());
                System.out.println();
            }
        }
        System.out.println();
    }
    
    public void listStudentCreated(){
        Subject mathQuang = new Subject("Calculus 2", 98.6, true);
        Subject phyQuang = new Subject("Physic III", 0, false);
        Subject mathQuan = new Subject("Dai So Tuyen Tinh", 98.6, true);
        Subject phyQuan = new Subject("Dien Tu - Quang - Luong tu", 99.6, true);
        Subject mathThuong = new Subject("Giai Tich B2", 91.4, true);
        Subject phyThuong = new Subject("Dien Tu can ban", 99.8, false);
        Subject mathMinh = new Subject("Giai Tich B1", 92.3, false);
        Subject phyMinh = new Subject("Physic IV", 32.4, true);
        
        Student quang = new Student("1165093", "Quang Bui", 24, mathQuang, phyQuang);
        Student quan = new Student("1165090", "Quan Bui", 25, mathQuan, phyQuan);
        Student thuong = new Student("1165127", "Ngoc Thuong", 20, mathThuong, phyThuong);
        Student minh = new Student("1165065", "Van Minh", 21, mathMinh, phyMinh);
        /*Student quang = new Student("", "", , , );
        Student quang = new Student("", "", , , );
        Student quang = new Student("", "", , , );*/
        studentList.add(quang);
        studentList.add(quan);
        studentList.add(minh);
        studentList.add(thuong);
    }
    
    public void addStudent(Student newStudent){
        //newStudent = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma so sinh vien: ");
        String id = sc.nextLine();
        newStudent.setId(id);

        System.out.print("Nhap ten sinh vien: ");
        String name = sc.nextLine();
        newStudent.setName(name);

        System.out.print("Nhap tuoi sinh vien: ");
        int age = sc.nextInt();
        sc.nextLine();
        newStudent.setAge(age);
        newStudent.inputSubject();
        studentList.add(newStudent);
    }
    
    private int findStudentByID(String id){
        int position = -1;
        
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getId().equalsIgnoreCase(id)){
                position = i;
            }
        }
        
        return position;
    }
    
    public void modifyStudent(String id){
        int index = this.findStudentByID(id);
        if(index == -1){
            System.err.println("Khong tim thay sinh vien co ma so: " + id);
        }else{
            Student who = studentList.get(index);
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap vao ten moi: ");
            String name = sc.nextLine();
            who.setName(name);
            System.out.print("Nhap vao tuoi moi: ");
            int age = sc.nextInt();
            sc.nextLine();
            who.setAge(age);

            studentList.set(index, who);
            System.out.println("Sua thong tin sinh vien thanh cong");
        }
        //studentList.set(index, who);
    }
    
    public void removeStudent(String id){
        int index = this.findStudentByID(id);
        if(index == -1){
            System.err.println("Khong tim thay sinh vien co ma so: " + id);
        }else{
            studentList.remove(index);
            System.out.println("Xoá thành công sinh viên: " + id + " ra khỏi danh sách.");
        }
    }
    
    public double getAverageMark(){
        double total = 0.0;
        for(Student student : studentList){
            total += student.getAverage();
        }
        return total / studentList.size();
    }
    
    public double getAverageMarkMath(){
        double total = 0.0;
        for(Student student : studentList){
            total += student.getMath().getMark();
        }
        return total / studentList.size();
    }
    
    public void searchStudent(String id) {
        Student who = new Student();
        int index = findStudentByID(id);
        if(index == -1){
            System.err.println("Sinh vien " + id + " khong ton tai trong danh sach");
        }else{
            who = studentList.get(index);
            who.display();
            System.out.println();
        }
    }
    
    public ArrayList<Student> getPassStudentList(){
        ArrayList<Student> passStudent = new ArrayList<Student>();
        for(Student student : studentList){
            if(student.getAverage() >= 70){
                passStudent.add(student);
            }
        }
        return passStudent;
    }
    
    public void modifyStudentMark(String id){
        //who.modifyMark(whatSubject, newMark);
        int index = this.findStudentByID(id);
        if(index == -1){
            System.err.println("Khong tim thay sinh vien co ma so: " + id);
        }else{
            Scanner sc = new Scanner(System.in);
            Student who = studentList.get(index);
            System.out.print("Nhap vao bo mon can sua diem: ");
            String subjectName = sc.nextLine();
            who.modifyMark(subjectName);
            studentList.set(index, who);
            System.out.println("Sua diem thanh cong");
        }
    }
    
    public double totalFee(){
        Student firstStudent = studentList.get(0);
        double fee = studentList.size() * firstStudent.calculateFee();
        return fee;
    }
    
    private double getMaxMath(){
        double mathMax = 0.0;
        for(Student student : studentList){
            if(student.getMath().getMark() > mathMax){
                mathMax = student.getMath().getMark();
            }
        }
        return mathMax;
    }
    
    public ArrayList<Student> findBestMathStudent(){
        ArrayList<Student> whoBest = new ArrayList<Student>();
        double mathMax = this.getMaxMath();
        for(Student student : studentList){
            if(student.getMath().getMark() == mathMax){
                whoBest.add(student);
            }
        }
        return whoBest;
    }
}
