import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // 현재 날짜를 가져옵니다.
                LocalDate today = LocalDate.now();

        // 날짜를 "YYYY-MM-DD" 형식으로 포맷합니다.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(formatter);

        // 결과를 출력합니다.
        System.out.println(formattedDate);
    }
}