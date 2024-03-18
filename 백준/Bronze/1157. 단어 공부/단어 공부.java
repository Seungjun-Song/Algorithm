import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        int[] alpha = new int[26];
        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i) - 'A']++;
        }

        int maxValue = -1;
        char result = '?';
        for (int i = 0; i < 26; i++) {
            if (maxValue < alpha[i]) {
                maxValue = alpha[i];
                result = (char) (i + 'A');
            } else if (alpha[i] == maxValue) {
                result = '?';
            }
        }

        System.out.println(maxValue == -1 ? "?" : result);
    }
}