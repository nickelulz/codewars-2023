import java.io.*;
import java.util.*;
import java.util.Collectors;

public class prob26 {
	private static final boolean submit = false;

	public static void solve_test_case(final Scanner in) {
		while (in.hasNextLine()) {
			int number = in.nextInt(); in.nextLine();

			Queue<List<Integer>> combos = new LinkedList<>();
			combos.add(List.of(number));

			Set<List<Integer>> factors = new HashSet();

			while (!combos.isEmpty()) {
				List<Integer> next = combos.remove();
				if (next.size() != 1)
					factors.add(next);

				for (int i = 0; i < next.size(); i++) {
					if (next.get(i) <= 2) continue;
																						

					for (int j = next.get(i) - 1; j >= 2; j--) {

						if (next.get(i) % j == 0) {
							List<Integer> clone = new ArrayList(next);
							clone.add(i + 1, next.get(i) / j);
							clone.set(i, j);
							Collections.sort(clone);
							Collections.reverse(clone);
							combos.add(clone);
						}
					}
				}
			}

			List<List<Integer>> finalFactors = new ArrayList(factors);

			List<Integer> firsts = new ArrayList<>();
			for (List<Integer> items : factors) {
				firsts.add(items.get(0));
			}

			Collections.sort(firsts);
			Collections.reverse(firsts);

			if (finalFactors.size() == 0) continue;
			System.out.print(number + "=");
			System.out.println(finalFactors.stream().map((array) -> 
			{
				String s = "(";
				for (int i  = 0; i < array.size() - 1; i++) s += array.get(i) + "*";
				s += array.get(array.size() - 1) + ")";
				return s;
			}).collect(Collectors.joinToString(",")));
		}
	}

    public static void main(String[] args) {
        final String file_name = "prob26";

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