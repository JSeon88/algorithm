package baekjoon;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NandM {

    static boolean[] visited ;
    static int[] num;

    static void func(int index, int n, int m) {
//        if (index == m) {
//            for (int i = 0; i < m; i++) {
//                System.out.print(num[i] + " ");
//            }
//            System.out.println();
//            return;
//        }
//        for (int i = 1; i <= n; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                num[index] = i;
//                func(index + 1, n, m);
//                visited[i] = false;
//            }
//        }

        List<Integer> numbers1 = IntStream.rangeClosed(1,n).boxed().collect(Collectors.toList());
        List<Integer> numbers2 = IntStream.rangeClosed(1,m).boxed().collect(Collectors.toList());

        List<int[]> paris = numbers2.stream().flatMap(i -> numbers1.stream().map(j -> new int[]{i,j})).collect(Collectors.toList());
        for(int[] t : paris){
            for(int tt : t){
                System.out.print(tt + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        num = new int[m];
        visited = new boolean[n+1];

        func(0, n, m);
    }
}
