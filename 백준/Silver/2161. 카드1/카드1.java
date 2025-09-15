import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    Queue<Integer> q = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= N; i++)
      q.add(i);

    while (!q.isEmpty()) {
      sb.append(q.remove());
      if (!q.isEmpty()) {
        sb.append(' ');
        q.add(q.remove());
      }
    }

    bw.write(sb.toString());

    bw.flush();
    br.close();
    bw.close();
  }
}