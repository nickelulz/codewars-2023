import java.io.*;
import java.util.*;

public class prob14 {
	private static final boolean submit = false;

	public static void solve_test_case(final Scanner in) {
		long[] lookup = new long[36];
		lookup[0] = 0;
		lookup[1] = 1;
		lookup[2] = 1;
		for (int i = 3; i < 36; ++i)
			lookup[i] = lookup[i-1] + lookup[i-2] + lookup[i-3];
		while (in.hasNextLine()) {
			long a = lookup[in.nextInt()],
				b = lookup[in.nextInt()];
			if (a == 0 && b == 0)
				break;
			System.out.println(a-b);
		}
	}

    public static void main(String[] args) {
        final String file_name = "prob14";

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