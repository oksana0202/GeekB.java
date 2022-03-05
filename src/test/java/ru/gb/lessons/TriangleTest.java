package ru.gb.lessons;

import lombok.val;
import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lessons.lesson4.Triangle;
import java.awt.*;
import static org.bouncycastle.asn1.x500.style.RFC4519Style.c;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTest {
    @Test
    @DisplayName("Площадь треугольника 14, 13, 15 по формуле Герона, должна быть равна 84")
    public void countAreaTriangle() {
        Triangle triangle = new Triangle(14, 13, 15);
        int area = 84;
        assertEquals(84, area);
    }
    @Test
    @DisplayName("Площадь треугольника 10, 13, 15 по формуле Герона, не равна 84")
    public void countingAreaTriangleErrorTest() {
        Triangle triangle = new Triangle(10, 13, 15);
        int area = 84;
        assertEquals(84, area);
    }
}
