import java.io.*;
import java.util.*;

public class prob02 {
	private static final boolean submit = true;

	public static void solve_test_case(final Scanner in) {
		while (in.hasNextInt()) {
			final int n = in.nextInt();
			if (n == 0)
				return;
			if (n % 4 == 0)
				System.out.printf("%d/4 = %d\n", n, n/4);
		}
	}

    public static void main(String[] args) {
        final String file_name = "prob02";

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
        				System.out.println();
        			}
        			catch (IOException e) {
        				e.printStackTrace();
        			} 
        		});
        }
    }
}