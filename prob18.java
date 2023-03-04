import java.io.*;
import java.util.*;

public class prob18 {
	private static final boolean submit = false;

	public static void solve_test_case(final Scanner in) {
		String first = in.nextLine();
		List<String> lst = new ArrayList<String>();
		while (in.hasNextLine()) {
			lst.add(in.nextLine());
		}
		if (lst.size() == 1) {
			System.out.println(lst.get(0));
		}
		else if (lst.size() == 2) {
			System.out.println(lst.get(0) + " " + first.toLowerCase() + " " + lst.get(1));
		}
		else {
			String output = "";
			for (int i = 0; i < lst.size(); i++) {
				if (i == lst.size() - 1) {
					output += first.toLowerCase() + " " + lst.get(i);
				}
				else {
					output += lst.get(i) + ", ";
				}

				
			}
			System.out.println(output);
		}

	}

    public static void main(String[] args) {
        final String file_name = "prob18";

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