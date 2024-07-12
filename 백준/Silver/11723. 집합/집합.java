import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int number = 0;
            if (st.hasMoreTokens()) {
                number = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "add" -> {
                    set.add(number);
                }
                case "remove" -> {
                    set.remove(number);
                }
                case "check" -> {
                    sb.append(set.contains(number) ? 1 : 0).append("\n");
                }
                case "toggle" -> {
                    if (set.contains(number))
                        set.remove(number);
                    else
                        set.add(number);
                }
                case "all" -> {
                    set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                }
                case "empty" -> {
                    set.clear();
                }
            };
        }
        System.out.println(sb);
    }
}