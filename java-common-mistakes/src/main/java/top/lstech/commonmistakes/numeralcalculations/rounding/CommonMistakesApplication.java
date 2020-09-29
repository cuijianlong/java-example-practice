package top.lstech.commonmistakes.numeralcalculations.rounding;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@SpringBootApplication
public class CommonMistakesApplication {

    public static void main(String[] args) {

        System.out.println("wrong1");
        wrong1();
        System.out.println("wrong2");
        wrong2();
        System.out.println("right");
        right();
    }

    private static void wrong1() {

        double num1 = 3.35;
        float num2 = 3.35f;
        // 3.4 ,四舍五入
        System.out.println(String.format("%.1f", num1));
        // 3.3
        System.out.println(String.format("%.1f", num2));
    }

    private static void wrong2() {
        double num1 = 3.35;
        float num2 = 3.35f;
        DecimalFormat format = new DecimalFormat("#.##");
        format.setRoundingMode(RoundingMode.DOWN);
        // 3.35
        System.out.println(format.format(num1));
        format.setRoundingMode(RoundingMode.DOWN);
        // 3.34
        System.out.println(format.format(num2));
    }

    private static void right() {
        BigDecimal num1 = new BigDecimal("3.35");
        // 3.3
        BigDecimal num2 = num1.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println(num2);
        // 3.4
        BigDecimal num3 = num1.setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(num3);
    }
}

