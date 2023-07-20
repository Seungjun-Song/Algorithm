import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double gradeSum = 0;
		double answer = 0;
		
		for(int i=0; i<20; i++) {
			String[] s = br.readLine().split(" ");
			double credit = Double.parseDouble(s[1]);
			String grade = s[2];
			if(grade.equals("P")) continue;
			gradeSum += credit;
			
			if(grade.equals("A+")) credit *= 4.5;
			else if(grade.equals("A0")) credit *= 4.0;
			else if(grade.equals("B+")) credit *= 3.5;
			else if(grade.equals("B0")) credit *= 3.0;
			else if(grade.equals("C+")) credit *= 2.5;
			else if(grade.equals("C0")) credit *= 2.0;
			else if(grade.equals("D+")) credit *= 1.5;
			else if(grade.equals("D0")) credit *= 1.0;
			else if(grade.equals("F")) credit *= 0.0;
			
			
			answer += credit;
		}
		System.out.printf("%.6f", (answer / gradeSum));
	}
}