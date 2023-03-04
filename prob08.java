import java.io.*;
import java.util.*;

public class prob08 {
	private static final boolean submit = true;

	public static void solve_test_case(final Scanner in) {
		long n = in.nextLong();
		long res = in.nextLong();
		long act = 1;
		for (long i = 1; i < res; i++) {
			for (int j = 0; j < i; j++) {
				act *= n;
			}
			if (act == res) {
				System.out.println(n + "^" + i + " = " + res);
				break;
			}
			else {
				act = 1;
			}
		}

	}

    public static void main(String[] args) {
        final String file_name = "prob08";

        if (submit)
        	solve_test_case(new Scanner(System.in));
        else {
        	Arrays.stream(new File("./CodeWars-XXVI-Student-2023-03-03-UTC-b33/student_datasets/").listFiles())
        		.filter(File::isFile)
        		.filter(f -> f.getName().startsWith(file_name))
        		.filter(f -> f.getName().endsWith("-in.txt"))
        		.forEach(f -> {
        			System.out.println(f.getName()); 
        			try {
        				solve_test_case(new Scanner(f));
        			}
        			catch (IOException e) {
        				e.printStackTrace();
        			} 
        			System.out.println();
        		});
        }
    }
}