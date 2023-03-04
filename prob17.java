import java.io.*;
import java.util.*;

public class prob17 {
	private static final boolean submit = true;

	public static void solve_test_case(final Scanner in) {
		String line = in.nextLine();
		String pattern = "";
		for (int i = 1; i < line.length(); ++i) {
			pattern = line.substring(0, i);
			if (line.substring(0, i).equals(line.substring(0 + i, i + i)))
				break;
		}
		System.out.println(pattern.substring(line.length() % pattern.length()));
		System.out.println(pattern);
	}

    public static void main(String[] args) {
        final String file_name = "prob17";

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