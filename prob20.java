import java.io.*;
import java.util.*;

public class prob20 {
	private static final boolean submit = true;

	public static void solve_test_case(final Scanner in) {
		int number = in.nextInt();
		int original = number;
		in.nextLine();

		StringBuilder result = new StringBuilder();
		for (int i = 9; i >= 0; i--) {
			if (number >= Math.pow(2, i)) {
				result.append("1");
				number -= Math.pow(2, i);
				System.out.println((int) Math.pow(2, i) + "=1");

			} else {
				result.append("0");
				System.out.println((int) Math.pow(2, i) + "=0");
			}
		}

		int sum = 0;
		for (int i = 9; i >= 0; i--) {
			if (result.charAt(result.length() - i - 1) == '1')
			 {
				int amount = (int) Math.pow(2, i);
				if (sum == 0) {
					sum = amount;
					continue;
				} else {
					System.out.println(sum + "+" + amount + "=" + (sum + amount));
					sum += amount;
				}
			}
		}

		System.out.println(original + " = " + Integer.parseInt(result.toString()));
	}

    public static void main(String[] args) {
        final String file_name = "prob20";

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