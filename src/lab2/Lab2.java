package lab2;

public class Lab2 {
    public static void main(String[] args) {
        final int C5 = 1517 % 5;//C=A+B
        System.out.println("C5 = " + C5 + " /C=A+B");
        final int C7 = 1517 % 7;//char
        System.out.println("C7 = " + C7 + " /type: char");
        final int C11 = 1517 % 11;//2 - "%"
        System.out.println("C11 = " + C11 + " /Дія з матрицею С: Знайти середнє значення елементів матриці\n");

        final char[][] m1 = {
                {1, 15, 2},
                {17, 8, 25},
                {17, 10, 5}
        };

        final char[][] m2 = {
                {3, 1, 1},
                {9, 0, 3},
                {1, 4, 5}
        };

        System.out.println("matrix A:");
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                System.out.print(m1[i][j] - '0' + 48 + " ");
            }
            System.out.println();
        }

        System.out.println("matrix B:");
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                System.out.print(m2[i][j] - '0' + 48 + " ");
            }
            System.out.println();
        }

        char[][] m3 = new char[m1.length][m1[0].length];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                m3[i][j] = (char) ((m1[i][j] - '0' + 48 + m2[i][j] - '0' + 48) + '0');
            }
        }

        System.out.println("matrix C:");
        for (int i = 0; i < m3.length; i++) {
            for (int j = 0; j < m3[0].length; j++) {
                System.out.print(m3[i][j] - '0' + " ");
            }
            System.out.println();
        }

        float avg = 0;
        for (int i = 0; i < m3.length; i++) {
            for (int j = 0; j < m3[0].length; j++) {
                avg += m3[i][j] - '0';
            }
        }
        avg /= (m3.length * m3[0].length);
        System.out.println("Average value of matrix C = " + avg);

    }
}
