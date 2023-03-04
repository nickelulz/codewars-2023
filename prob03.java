import java.io.*;
import java.util.*;

public class prob03 {
	private static final boolean submit = true;

	public static void solve_test_case(final Scanner in) {
		int current = in.nextInt();
		int max = in.nextInt();
		double rate = in.nextDouble();
		int years = in.nextInt();

		int calculation = (int) (current * (1 + rate) * years);
		int gap = calculation - max;

		System.out.printf("At the current rate of growth there will be %d ponies in %d years.\n",
			calculation, years);
		if (gap > 0)
			System.out.printf("Cecilia will need to add space for at least %d ponies!\n", gap);
		else
			System.out.println("Cecilia won't need to add space yet!");
	}

    public static void main(String[] args) {
        final String file_name = "prob03";

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