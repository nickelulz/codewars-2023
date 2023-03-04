import java.io.*;
import java.util.*;

public class prob22 {
	private static final boolean submit = true;

	public static void solve_test_case(final Scanner in) {
		Map<String, Double> components = new HashMap<>();

		for (int i = 0; i < 6; i++) {
			String[] split = in.nextLine().split(" ");

			switch (split[0]) {
			case "NICSRC":
			case "NICDST":
			case "ROUTER":
				components.put(split[0], Double.parseDouble(split[1]) * 1000);
				break;
			case "SWITCH":
				if (Double.parseDouble(split[1]) == 0.0) break;
				components.put(split[0], Double.parseDouble(split[1]) * 1000);
				break;
			case "HDDSRC":
				components.put(split[0], Double.parseDouble(split[1].split("/")[0]) * 8);
				break;
			case "HDDDST":
				components.put(split[0], Double.parseDouble(split[1].split("/")[1]) * 8);
			}
		}

		double min = Double.MAX_VALUE;
		String minComponent = null;

		for (String component : components.keySet()) {
			if (components.get(component) < min)  {
				min = components.get(component);
				minComponent = component;
			}
		}

		System.out.printf("%.1f%n", min / 8.0);
		String fullName = null;
		switch (minComponent) {
		case "NICSRC":
			fullName = "source NIC";
			break;
		case "NICDST":
			fullName = "destination NIC";
			break;
		case "SWITCH":
			fullName = "switch";
			break;
		case "ROUTER":
			fullName = "router";
			break;
		case "HDDSRC":
			fullName = "source drive";
			break;
		case "HDDDST":
			fullName = "destination drive";
		}

		System.out.println(fullName);
	}

    public static void main(String[] args) {
        final String file_name = "prob22";

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