import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //monetary_composition()
        //gold_mine();
        //suger();
        //soldier_placement();
        one_maker();
    }


    private static void monetary_composition() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] d = new int[m + 1];
        Arrays.fill(d, 10001);
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                if (d[j - arr[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j - arr[i]] + 1);
                }
            }
        }
        if (d[m] == 10001) System.out.println(-1);
        else System.out.println(d[m]);
    }

    private static void gold_mine() {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int[] num = new int[testcase];
        int n;
        int m;
        int[][] arr = new int[20][20];
        int[][] dp = new int[20][20];
        for (int tc = 0; tc < testcase; tc++) {
            n = sc.nextInt();
            m = sc.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.println();
                for (int j = 0; j < m; j++) {
                    dp[i][j] = arr[i][j];
                }
            }
            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    int leftUp, left, leftDown;
                    //왼쪽 위에서 오는 경우
                    if (i == 0) leftUp = 0;
                    else leftUp = dp[i - 1][j - 1];
                    //외쪽아래에서 오는 경우
                    if (i == n - 1) leftDown = 0;
                    else leftDown = dp[i + 1][j - 1];
                    //왼쪽에서 오는 경우
                    left = dp[i][j - 1];
                    dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(left, leftDown));
                }
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                result = Math.max(result, dp[i][m - 1]);
            }
            num[tc] = result;
        }
        for (int i = 0; i < testcase; i++) {
            System.out.println(num[i]);
        }
    }



    private static void soldier_placement() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        Collections.reverse(arr);
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) < arr.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }

        System.out.println(n - maxValue);
    }
    private static void suger() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        while(true){
            if (n%5==0){
                System.out.println(n/5+cnt);
                break;
            }else if(n<=0){
                System.out.println(-1);
                break;
            }
            n=n-3;
            cnt++;
        }
    }
    private static void one_maker(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0]=dp[1]=0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+1;
            if(i%2==0) dp[i]=Math.min(dp[i],dp[i/2]+1);
            if(i%3==0) dp[i]=Math.min(dp[i],dp[i/3]+1);
        }
        System.out.println(dp[n]);

    }

}