package ru.vsu.chirkova;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество слагаемых n : ");
        int n = scanner.nextInt();
        System.out.print("Введите x (-R; R) R=1 : ");
        double x = scanner.nextDouble();
        System.out.print("Введите число e : ");
        double e = scanner.nextDouble();
        double a = (Math.pow(1 + x, 2));
        a = 1/a;
        System.out.println("Сумма " + n + " членов последовательности = " + SumAll(x, n));
        System.out.println("Сумма тех слагаемых, которые по абсолютной величине больше " + e + " = " + functionE(n, x, e));
        System.out.println("Сумма тех слагаемых, которые по абсолютной величине больше " + e / 10 + " = " + functionE10(n, x, e));
        System.out.println("Значение функции с помощью методов Math = " + a);
    }


    public static double calculateAn(double x, int n) {
        double v = n * Math.pow(x, (n - 1));
        if (n % 2 == 1) {
            return v;
        } else return -v;
    }

    public static double SumAll(double x, int n) {
        double S = 1;
        int j = 2;
        while (j <= n) {
            S += calculateAn(x, j);
            j++;
        }
        return S;
    }


    public static double functionE(int n, double x, double e) {
        double S = 0;
        for (int i = 1; i <= n; i++) {
            if (Math.abs(calculateAn(x, i)) > e) {
                S += calculateAn(x, i);
            }
        }
        return S;
    }


    public static double functionE10(int n, double x, double e) {
        double S = 0;
        for (int i = 1; i <= n; i++) {
            if (Math.abs(calculateAn(x, i)) > e / 10) {
                    S += calculateAn(x, i);
                }
            }
        return S;
    }
}


