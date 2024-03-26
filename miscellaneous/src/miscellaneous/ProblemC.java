package miscellaneous;

import java.util.Scanner;

public class ProblemC {
    static int n, k;
    static char[][] str = new char[10][10];
    static int[] a = new int[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            str[i] = scanner.next().toCharArray();
        }

        for (int i = 0; i < k; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(dfs(0));
        scanner.close();
    }

    static long dfs(int idx) {
        if (idx == k) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (str[i][j] == '0') return 0;
                }
            }
            return 1;
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + a[idx] <= n) {
                    boolean f = true;
                    for (int k = i; k < i + a[idx]; k++) {
                        if (str[k][j] != '0' && str[k][j] != '.') {
                            f = false;
                        }
                    }
                    if (f) {
                        for (int k = i; k < i + a[idx]; k++) {
                            str[k][j] += 5;
                        }
                        ans += dfs(idx + 1);
                        for (int k = i; k < i + a[idx]; k++) {
                            str[k][j] -= 5;
                        }
                    }
                }

                if (j + a[idx] <= n && a[idx] > 1) {
                    boolean f = true;
                    for (int k = j; k < j + a[idx]; k++) {
                        if (str[i][k] != '0' && str[i][k] != '.') {
                            f = false;
                        }
                    }
                    if (f) {
                        for (int k = j; k < j + a[idx]; k++) {
                            str[i][k] += 5;
                        }
                        ans += dfs(idx + 1);
                        for (int k = j; k < j + a[idx]; k++) {
                            str[i][k] -= 5;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
