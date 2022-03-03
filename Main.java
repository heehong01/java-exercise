package com.example.optum.javaexercise;

public class Main {
    public static void main(String[] args){
        Student student = new Student();
        Student englishMajor = new EnglishMajor();
        Student msthMajor = new MathMajor();

        MathMajor mathMajor1 = (MathMajor) student;
        mathMajor1.getInfo();
    }
}
