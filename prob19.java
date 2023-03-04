import java.io.*;
import java.util.*;

public class prob19 {
	private static final boolean submit = true;

	public static void solve_test_case(final Scanner in) {
		String line = in.nextLine();
		int n = in.nextInt();
		char[][] mat = new char[n][n];
		int index = 0;
		int r = 0;
		int c = 0;
		for (c = 0; c < n; c++) {
			mat[r][c] = line.charAt(index % line.length());
			index++;
		}
		c--;
		for (r = 1; r < n; r++) {
			mat[r][c] = line.charAt(index % line.length());
			index++;
		}
		r--;
		for (c = c - 1; c >= 0; c--) {
			mat[r][c] = line.charAt(index % line.length());
			index++;
		}
		c++;
		for (r = r - 1; r > 0; r--) {
			mat[r][c] = line.charAt(index % line.length());
			index++;
		}
		String res = "";
		for (int row = 0; row < mat.length; row++) {
			for (int col = 0; col < mat.length; col++) {
				if (mat[row][col] == 0) {
					res += " ";
				}
				else {
					res += mat[row][col];
				}
			}
			res += "\n";
		}
		System.out.println(res);

	}

    public static void main(String[] args) {
        final String file_name = "prob19";

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