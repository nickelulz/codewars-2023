import java.io.*;
import java.util.*;

public class prob06 {
	private static final boolean submit = true;

	public static void solve_test_case(final Scanner in) {
		while (in.hasNextLine()) {
			final int l = in.nextInt(),
				w = in.nextInt();
			final boolean is_square = in.nextLine().trim().equals("S");

			if (l == 0 && w == 0)
				break;

			int perim = 2 * l + 2 * w;
			perim += is_square ? 80 : 320;
			System.out.printf("%s %d\n", is_square ? "Square" : "Diagonal", perim);
		}
	}

    public static void main(String[] args) {
        final String file_name = "prob06";

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