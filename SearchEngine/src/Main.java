import java.io.*;
import java.util.Iterator;
import java.lang.Math;

public class Main {
	public static void print(String result) {
		if (result == null)
			System.out.println("The value is not found");
		else
			System.out.println("Found value is: " + result);
	}
	
	public static void display(HashedDictionary<Integer, String, Integer[][]> dataBase) {
		Iterator<Integer> keyIterator = dataBase.getKeyIterator();
		Iterator<String> valueIterator = dataBase.getValueIterator();
		Iterator<Integer[][]> ArrayIterator = dataBase.getArrayIterator();
		while (keyIterator.hasNext()) {
			System.out.println("Key: " + keyIterator.next() + " Value: " + valueIterator.next() + "List" + ArrayIterator.next());
		}
	}

	public static int PAFhashcode(String s) {
		int n = s.length();
		int hash = 0;
		s = s.toLowerCase();
		for (int k = 0; k < n; k++) {
			hash = hash + (((int) Math.pow(31, k)) * ((int) s.charAt(k) - 96));
		}

		return hash;

	}
	public static int SSFhashcode(String s) {
		int n = s.length();
		int hash = 0;
		s = s.toLowerCase();
		for (int k = 0; k < n; k++) {
			hash = hash + (int) s.charAt(k);
		}

		return hash;

	}

	public static void main(String[] args) throws IOException {

		HashedDictionary<Integer,String,Integer[][]> dataBase = new HashedDictionary<Integer, String,Integer[][]>();
		File dir = new File("sport");
		File[] list = dir.listFiles();
		String[] words = null;
		
		for (int i = 0; i < 100; i++) {
			Integer[][] counter = new Integer[i][];
			File file = new File((String) list[i].getAbsolutePath());
			// System.out.println();

			FileReader fileReader = new FileReader(file);
			String line;
			BufferedReader br = new BufferedReader(fileReader);
			while ((line = br.readLine()) != null) {
				// System.out.println(line);
				String DELIMITERS = "[-+=" + " " + "\r\n " + "1234567890" + "’'\"" + "(){}<>\\[\\]" + ":" + "," + "‒–—―"
						+ "…" + "!" + "." + "«»" + "-‐" + "?" + "‘’“”" + ";" + "/" + "⁄" + "␠" + "·" + "&" + "@" + "*"
						+ "\\" + "•" + "^" + "¤¢$€£¥₩₪" + "†‡" + "°" + "¡" + "¿" + "¬" + "#" + "№" + "%‰‱" + "¶" + "′"
						+ "§" + "~" + "¨" + "_" + "|¦" + "⁂" + "☞" + "∴" + "‽" + "※" + "]";

				words = line.split(DELIMITERS);

			}
			br.close();
			long startTime = System.currentTimeMillis(); 
			 
			int[] t = new int[words.length];
			for (int j = 0; j < words.length; j++) {
				t[j] = PAFhashcode(words[j]);
				dataBase.addprobe(t[j], words[j],counter);
			}
			 long endTime = System.currentTimeMillis();
			 long estimatedTime = endTime - startTime; 
			 double seconds = (double)estimatedTime/1000; 
			display(dataBase);
		}

		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
	}

}
