package ru.vsu.chirkova;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out("Введите количество слагаемых n : ");
        int n = scanner.nextInt();
        out("Введите x (-R; R) R=1 : ");
        double x = scanner.nextDouble();
        out("Введите число e : ");
        double e = scanner.nextDouble();
        double a = 1 / (Math.pow(1 + x, 2));
        outln("");
        outln("Сумма " + n + " членов последовательности = " + SumAll(x, n));
        outln("Сумма тех слагаемых, которые по абсолютной величине больше " + e + " = " + functionE(n, x, e));
        outln("Сумма тех слагаемых, которые по абсолютной величине больше " + e / 10 + " = " + functionE10(n, x, e));
        outln("Значение функции с помощью методов Math = " + a);
    }


    public static double calculateAn(double x, int n) {
        if (n == 1) {
            return 1;
        } else return (n * Math.pow(x, (n - 1)));
    }


    public static double SumAll(double x, int n) {
        double S = 1;
        int j = 2;
        while (j <= n) {
            if (j % 2 == 1) {
                S -= calculateAn(x, j);
            } else {
                S += calculateAn(x, j);
            }
            j++;
        }
        return S;
    }

    public static double functionE(int n, double x, double e) {
        double S = 0;
        for (int i = 1; i <= n; i++) {
            if (Math.abs(calculateAn(x, i)) > e) {
                if (i % 2 == 1) {
                    S -= calculateAn(x, i);
                } else {
                    S += calculateAn(x, i);
                }
            }
        }
        return S;
    }

    public static double functionE10(int n, double x, double e) {
        double S = 0;
        for (int i = 1; i <= n; i++) {
            if (Math.abs(calculateAn(x, i)) > e / 10) {
                if (i % 2 == 1) {
                    S -= calculateAn(x, i);
                } else {
                    S += calculateAn(x, i);
                }
            }
        }
        return S;
    }

    public static void out(String s) {
        System.out.print(s);
    }

    public static void outln(String s) {
        System.out.println(s);
    }
}


