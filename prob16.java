import java.io.*;
import java.util.*;

public class prob16 {
	private static final boolean submit = false;

	public static String replaceTwo(final String text, final char A, final char B) {
		char[] word = text.toCharArray();
		for (int w = 0; w < word.length; ++w) {
			if (word[w] == A)
				word[w] = B;
			if (word[w] == B)
				word[w] = A;
		}
		return new String(word);
	}

	public static void solve_test_case(final Scanner in) {
		final char A = in.next().charAt(0),
			B = in.next().charAt(0);
		in.nextLine();
		ArrayList<String> words = new ArrayList<>();
		while (in.hasNextLine()) {
			String word = in.nextLine();
			if (word.equals("END"))
				break;
			words.add(word);
		}
		for (int i = 0; i < words.size(); ++i) {
			char[] word = words.get(i).toCharArray();
			for (int j = 0; j < word.length; j++) {
				if (word[j] == A) {
					word[j] = B;
				}
				else if (word[j] == B) {
					word[j] = A;
				}

			}
			String put = "";
			for (char ch : word) {
				put += ch;
			}
			System.out.println(put);
			words.set(i, put);
			System.out.println(words);
		}
		Collections.sort(words);
		System.out.println(words);
		for (int i = 0; i < words.size(); ++i) {
			char[] word = words.get(i).toCharArray();
			for (int j = 0; j < words.get(i).toCharArray().length; j++) {
				if (word[j] == A) {
					word[j] = B;
				}
				else if (word[j] == B) {
					word[j] = A;
				}

			}
			String put = "";
			for (char ch : word) {
				put += ch;
			}
			words.set(i, put);
		}
		for (String word : words)
			System.out.println(word);
	}

    public static void main(String[] args) {
        final String file_name = "prob16";

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