import java.util.Scanner;

public class Main {
    static long[][] DP;
    static String a = "a";
    static String z = "z";
    static int totalLength;
    static int aCount;
    static int zCount;
    static final long LIMIT = 1_000_000_001L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        aCount = scanner.nextInt();
        zCount = scanner.nextInt();
        long k = scanner.nextLong();
        totalLength = aCount + zCount;
        DP = new long[aCount + 1][zCount + 1];

        fillDPUntil(aCount, zCount);

        if (DP[aCount][zCount] < k) {
            System.out.println(-1);
        } else {

            String kthString = findKthString(new StringBuilder(), aCount, zCount, k);

            System.out.println(kthString);
        }

    }

    private static void fillDPUntil(int aTotal, int zTotal) {
        /**
         * 초기화
         * aCount나 zCount 중 하나가 0이라면 한가지 방법으로만 만들수 있다
         */
        for (int aCount = 0; aCount <= aTotal; aCount++) {
            DP[aCount][0] = 1;
        }
        for (int zCount = 0; zCount <= zTotal; zCount++) {
            DP[0][zCount] = 1;
        }

        /**
         * DP 채우기
         */
        for (int aCount = 1; aCount <= aTotal; aCount++) {
            for (int zCount = 1; zCount <= zTotal; zCount++) {
                DP[aCount][zCount] = Math.min(LIMIT, DP[aCount - 1][zCount] + DP[aCount][zCount - 1]);
            }
        }
    }

    private static String findKthString(StringBuilder currentString, int aCount, int zCount, long k) {
        /**
         * 첫문자부터, a로 시작할 때와 b로 시작할 때를 확인한 후 가능한 경우의 수가 k번째를 포함하는 문자로 선택을 한다.
         * ex. 현재 위치가 a면 3~5번째를 커버, 현재 위치가 z면 6~8번째를 커버
         * k = 4라면 a를 선택, k = 7이라면 z를 선택
         * 이후 재귀로 나아감
         */
        if (aCount == 0 && zCount == 0) {
            return currentString.toString();
        }
        if (aCount == 0) {
            return currentString.append(z.repeat(totalLength - currentString.length())).toString();
        }
        if (zCount == 0) {
            return currentString.append(a.repeat(totalLength - currentString.length())).toString();
        }

        // 1. 현재 위치에 a가 붙는다면
        long leftCount = DP[aCount - 1][zCount];
        if (leftCount >= k) {
            return findKthString(currentString.append(a), aCount - 1, zCount, k);
        }
        // 2. 현재 위치에 z가 붙는다면
        return findKthString(currentString.append(z), aCount, zCount - 1, k - leftCount);
    }
}
