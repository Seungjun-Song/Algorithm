public class Main {
	public static void main(String[] args) throws Exception {
		int arr[] = new int[10100];
		for(int i=0; i<10000; i++) {
			int sum = i;
			String s = Integer.toString(i);
			for(char c : s.toCharArray()) {
				sum += (int)c - 48; 
			}
			arr[sum] = 1;
		}
		
		for(int i=0; i<10000; i++) {
			if(arr[i]==0) System.out.println(i);
		}
	}
}