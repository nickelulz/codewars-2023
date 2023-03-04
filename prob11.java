import java.io.*;
import java.util.*;

public class prob11 {
	private static final boolean submit = true;

	public static void solve_test_case(final Scanner in) {
		final int n = in.nextInt();
		int full = n / 4;
		int partial = 0;
		if (n % 4 != 0)
			partial = 1;
		if (full == 0 && partial == 0)
			return;
		if (full == 0)
			System.out.printf("%d partial car\n", partial);
		else if (partial == 0)
			System.out.printf("%d full car%s", full, full > 1 ? "s" : "");
		else
			System.out.printf("%d full car%s, %d partial car", full, full > 1 ? "s" : "", partial);
	}

    public static void main(String[] args) {
        final String file_name = "prob11";

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