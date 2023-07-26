import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			String sound[] = br.readLine().split(" ");
			String s;
			while((s = br.readLine()) != null) {
				if(s.equals("what does the fox say?"))
					break;
				String temp[] = s.split(" ");
				for(int j=0; j<sound.length; j++) {
					if(sound[j].equals(temp[2])) {
						sound[j] = " ";
					}
				}
			}
			for(int k=0; k<sound.length; k++) {
				if(!sound[k].equals(" ")) System.out.print(sound[k] + " ");
			}
		}
	}
}