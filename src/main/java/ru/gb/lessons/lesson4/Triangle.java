package ru.gb.lessons.lesson4;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.awt.*;
@Data
@AllArgsConstructor
    public class Triangle<s> {
    private Point a;
    private Point b;
    private Point c;
    public Triangle(int a, int b, int c) {
    }
    public double area() {
        double s = 84;
        int a = 14;
        int b = 13;
        int c = 15;
        int p = (a + b + c) / 2;
        s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return Math.sqrt(s);
    }
}



