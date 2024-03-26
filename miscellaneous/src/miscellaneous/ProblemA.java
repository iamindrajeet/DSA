package miscellaneous;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        while (i-- > 0) {
            long[] a = new long[3];
            for (int j = 0; j < 3; j++) {
                a[j] = scanner.nextLong();
            }

            long k = a[1] - a[2];

            if (a[0] < k)
                System.out.println("advertise");
            else if (a[0] == k)
                System.out.println("does not matter");
            else
                System.out.println("do not advertise");
        }
        scanner.close();
    }
}
