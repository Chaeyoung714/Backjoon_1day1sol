import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int value, index;
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = new Pair(num, i); // 값 + 원래 인덱스 저장
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a.value)); // 값 기준 정렬

        int maxMove = 0;
        for (int i = 0; i < n; i++) {
            int move = arr[i].index - i;
            maxMove = Math.max(maxMove, move);
        }

        System.out.println(maxMove + 1); // 패스 수 = 최대 이동 거리 + 1
    }
}