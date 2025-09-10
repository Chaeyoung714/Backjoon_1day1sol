import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("");

        List<String> format = new ArrayList<>();

        String temp = "";
        for (String s : input) {
            if (s.equals("-") || s.equals("+")) {
                format.add(temp);
                format.add(s);
                temp = "";
                continue;
            }

            temp = temp.concat(s);
        }
        format.add(temp);

        int sum = 0;
        boolean isGualhoOpened = false;
        for (int i = 0; i < format.size(); i += 2) { //숫자부분만 조회
            int num = Integer.parseInt(format.get(i)); //num은 양수
            if (i == 0) {
                sum += num;
                continue;
            }

            if (format.get(i - 1).equals("-")) {
                isGualhoOpened = true; // -(... - num -> - (...) - (num... )
            }

            if (isGualhoOpened) { // - num 은 무조건 -를 한다.
                sum -= num;
            } else { // + num은 앞에 -가 나온 적 있으면 -를 하고, 그렇지 않으면 +를 한다.
                sum += num;
            }
        }

        System.out.println(sum);
    }
}
