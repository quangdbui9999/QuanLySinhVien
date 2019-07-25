package quanlysinhvien;

import java.util.Scanner;


public class Student {
    private String id;
    private String name;
    private int age;
    private Subject math;
    private Subject physics;

    private int findSubject(String subjectName){
        int index = 0;
        
        if(subjectName.equalsIgnoreCase(math.getName())){
            index = 1;
        }else if(subjectName.equalsIgnoreCase(physics.getName())){
            index = 2;
        }else{
            index = 0;
        }
        return index;
    }
    public void modifyMark(String subjectName){
        Scanner sc = new Scanner(System.in);
        
        int index = this.findSubject(subjectName);
        
        if(index == 0){
            System.err.println("Bộ môn " + subjectName + " không tồn tại.");
        }else if(index == 1){
            System.out.print("Nhập điểm mới: ");
            double newMark = sc.nextDouble();
            sc.nextLine();
            math.setMark(newMark);
        }else if(index == 2){
            System.out.print("Nhập điểm mới: ");
            double newMark = sc.nextDouble();
            sc.nextLine();
            physics.setMark(newMark);
        }
    }
    
    // nhap thong tin mon hoc
    public void inputSubject(){
        math = new Subject("Math", 3, false);
        math.inputMark();
        physics = new Subject("Physics", 2, true);
        physics.inputMark();
    }
    
    public void display(){
        System.out.print("Mã: " + this.id);
        System.out.print(" - Tên: " + this.name);
        System.out.println(" - Tuổi: " + this.age);
        math.display();
        physics.display();
    }
    
    // tinh Diem trung binh
    public double getAverage(){
        double average = (math.getMark() * StudentUtils.MATH_RATIO + physics.getMark() * StudentUtils.PHY_RATIO) /
                (StudentUtils.MATH_RATIO + StudentUtils.PHY_RATIO); 
        return average;
    }
    
    // Tinh học phí
    // BASE_FEE* (hoc phi mon toan*ratio*2+hocphimon ly*heso mon ly*co the thuc hanh)
    public double calculateFee(){
        return StudentUtils.BASE_FEE *
                (StudentUtils.MATH_RATIO * math.getPracticeFeetRatio() +
                StudentUtils.PHY_RATIO * physics.getPracticeFeetRatio());
    }
    
    public Student(String id, String name, int age, Subject math, Subject physics) {
        //super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.math = math;
        this.physics = physics;
    }

    public Student(String id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Subject getMath() {
        return math;
    }

    public void setMath(Subject math) {
        this.math = math;
    }

    public Subject getPhysics() {
        return physics;
    }

    public void setPhysics(Subject physics) {
        this.physics = physics;
    }
}
