package quanlysinhvien;

import java.util.Scanner;

public class Subject {
    private String name;
    private double mark;
    private boolean isPractice;

    public Subject(String name, double mark) {
        this.name = name;
        this.mark = mark;
    }
    
    public Subject(String name, boolean isPractice) {
        this.name = name;
        this.isPractice = isPractice;
    }
    
    public Subject(String name, double mark, boolean isPractice) {
        this.name = name;
        this.mark = mark;
        this.isPractice = isPractice;
    }
    
    public double getPracticeFeetRatio(){
        if(this.isPractice){
            return 2.0;
        }else{
            return 1.0;
        }
    }
    
    public void display(){
        System.out.println("Tên: " + this.name + " - Điểm: " + this.mark + ".");
    }
    
    public void inputMark(){
        System.out.print("Nhập điểm môn học: " + this.getName() + ": ");
        Scanner sc = new Scanner(System.in);
        this.mark = sc.nextDouble();
        sc.nextLine();
        this.setMark(this.mark);
    }
    
    public String toString(){
        return "Subject: [name: " + this.name 
                + ", mark: " + this.mark
                + ", isPractice: " + this.isPractice + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public boolean getIsPractice() {
        return isPractice;
    }

    public void setIsPractice(boolean isPractice) {
        this.isPractice = isPractice;
    }
}
