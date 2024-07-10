import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            Deque<Integer> q = new LinkedList<>();
            for (String number : s.substring(1, s.length() - 1).split(",")) {
                if (number.isEmpty()) break;
                q.addLast(Integer.parseInt(number));
            }

            boolean flag = false;
            boolean isError = false;
            for (int j = 0; j < p.length(); j++) {
                char command = p.charAt(j);
                if (command == 'R') {
                    flag = !flag;
                } else {
                    if (q.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (flag) q.removeLast();
                        else q.removeFirst();
                    }
                }
            }

            if (isError) {
                answer.append("error").append("\n");
            } else {
                answer.append("[");
                while (!q.isEmpty()) {
                    if (!flag) answer.append(q.removeFirst()).append(",");
                    else answer.append(q.removeLast()).append(",");
                }

                if (answer.charAt(answer.length() - 1) == ',') {
                    answer.deleteCharAt(answer.length() - 1);
                }
                answer.append("]").append("\n");
            }
        }

        System.out.println(answer);
    }
}