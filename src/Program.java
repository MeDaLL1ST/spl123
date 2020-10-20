import java.util.Scanner;


public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][m];


        int value = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 0; j - i >= 0 && i < n; i++) {
                a[i][0] = value;
                value++;
            }
        }
        for (int i = 1;i < n; i++) {
            for (int j = 1; j<n && m - 1 - j >= 0; j++) {
                a[m-1][j-i] = value;
                value++;
            }
        }

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        }
    }

