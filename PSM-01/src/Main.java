/*
Obliczanie sin(x) za pomocą szeregu Taylora
x - kąt podany w radianach LUB w stopniach
Porównanie wbudowanej funkcji sin(x) i własnego obliczenia sin(x)
*/

/*
cos(x) = cos(0) - x * sin(0) + -x^2 * cos(0) / 2! + x^3 * sin(0) / 3! + x^4 * cos(0) / 4!
cos(x)' = -sin(x)
cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6!

cos(pi/2 - x) = sin(x)
cos(pi/2 + x) = -sin(x)
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bool = false;
        int choice = 0, components;
        double angle;
        System.out.println("Wybierz w jakich jednostkach chcesz podawać ką† sinusa:");
        System.out.println("Radiany - wybierz 1");
        System.out.println("Stopnie - wybierz 2");

        while (!bool) {
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Wybrano radiany");
                bool = true;
            } else if (choice == 2) {
                System.out.println("Wybrano stopnie");
                bool = true;
            } else {
                System.out.println("Niewłąściwa odpowiedź, proszę wybrać 1 lub 2");

            }
        }

        System.out.println("Podaj kąt sinusa: ");
        angle = sc.nextDouble();

        if (choice == 2) {
            angle = Math.toRadians(angle);
            System.out.println("Przeliczono ze stopni na radiany: " + angle);
        }

        System.out.println("Podaj ile wyrazów ma mieć szereg Taylora: ");
        components = sc.nextInt();

        double wynik;
        wynik = taylor(angle, components);

        System.out.println("===============================================================");

        System.out.println("Wynik sinusa za pomocą funkcji \"taylor\": " + wynik);
        System.out.println("Wynik sinusa za pomocą wbudowanej funkcji: " + Math.sin(angle));
    }

    public static double taylor (double kat, int wyrazy) {
        double wynik = kat, znak = 1, potega = kat, silnia = 1, tmp = 1;

        for (int i = 1; i < wyrazy; i++) {
            znak++;
            potega = potega * kat * kat; // żeby nie liczyć za każdym razem dużej potęgi, biorę sobię poprzedni wynik obliczonej potęgi
            silnia = silnia * (++tmp) * (++tmp); // analogicznie do tego co powyżej
            if(znak%2 == 0) {
                wynik = wynik - potega/silnia;
            }
            else {
                wynik = wynik + potega/silnia;
            }
        }

        return wynik;
    }
}
