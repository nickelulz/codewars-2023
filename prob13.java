import java.io.*;
import java.util.*;

public class prob13 {
	private static final boolean submit = true;

	public static void solve_test_case(final Scanner in) {
		while (in.hasNextLine()) {
			String line = in.nextLine();
			if (line.equals("0"))
				break;
			System.out.println(line.substring(0, line.length()-5).replaceAll("\\d", "x") + 
				line.substring(line.length()-5));
		}
	}

    public static void main(String[] args) {
        final String file_name = "prob13";

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