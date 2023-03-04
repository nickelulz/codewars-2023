import java.io.*;
import java.util.*;

public class prob24 {
	private static final boolean submit = false;

	private static String reverse_diag(final char[][] mat, int r, int c) {
		String out = "";
		while (r >= 0 && c >= 0 && r < mat.length && c < mat[r].length) {
			out += mat[r][c];

			++r;
			--c;
		}
		return out;
	}

	private static String diag(final char[][] mat, int r, int c) {
		String out = "";
		while (r >= 0 && c >= 0 && r < mat.length && c < mat[r].length) {
			out += mat[r][c];

			++r;
			++c;
		}
		return out;
	}

	public static void solve_test_case(final Scanner in) {
		final int rows = in.nextInt(),
			cols = in.nextInt();

		final TreeSet<String> words = new TreeSet<>();

		while (in.hasNextLine()) {
			String next = in.nextLine();
			if (next.equals("END"))
				break;
			words.add(next);
		}

		final char[][] mat = new char[rows][cols];
		final ArrayList<String> lines = new ArrayList<>(); 

		for (int i = 0; i < rows; ++i)
			mat[i] = in.nextLine().toCharArray();

		for (char[] line: mat)
			lines.add(new String(line));

		for (int c = 0; c < cols; ++c) {
			String col = "";
			for (int r = 0; r < rows; ++r)
				col += mat[r][c];
			lines.add(col);
		}

		for (int r = 0; r < rows; ++r) {
			lines.add(diag(mat, r, 0));
			lines.add(reverse_diag(mat, r, 0));
		}

		for (int c = 0; c < cols; ++c) {
			lines.add(diag(mat, 0, c));
			lines.add(reverse_diag(mat, 0, c));
		}

		TreeSet<String> found = new TreeSet<>();

		System.out.println(lines);

		for (String word: words)
			for (String line: lines)
				if (line.contains(word) || line.contains(new StringBuilder(word).reverse().toString()))
					found.add(word);

		words.removeAll(found);
		System.out.println("FOUND: " + found.toString());
		System.out.println("MISSING: " + words.toString());
	}

    public static void main(String[] args) {
        final String file_name = "prob24";

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