import java.io.*;
import java.util.*;

public class prob25 {
	private static final boolean submit = false;

	private static void recursive_search(final File current, String look_for) {
		if (current.getName().equals(look_for))
	}

	public static void solve_test_case(final Scanner in) throws IOException {
		String root_folder = in.nextLine();
		final root_folder_file = new File(submit ? root_folder : "./CodeWars-XXVI-Student-2023-03-03-UTC-b33/student_datasets/files/" + root_folder);

		Scanner files = new Scanner(root_folder_file);

		ArrayList<String> movies;
		TreeMap<String, String> found = new TreeMap<>();

		while (in.hasNextLine()) {
			String line = in.nextLine();
			if (line.equals("END"))
				break;
			movies.add(line);
		}

		for (String movie: movies)
			recursive_search(root_folder_file, movie);
	}

    public static void main(String[] args) throws IOException {
        final String file_name = "prob25";

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