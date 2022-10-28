import java.util.*;
import java.io.*;

public class Jumbles
{
	public static void main(String[] args) throws IOException
	{
		if (args.length < 1)
		{
			System.out.println("Must put input file on command line like this: java Jumbles dictionary.txt jumbles.txt");
			System.exit(0);
		}

		//read the dictionary into an arrayList
		BufferedReader infile = new BufferedReader(new FileReader(args[0]));
		ArrayList<String> dictionary = new ArrayList<String>();

		while (infile.ready())
		{
			dictionary.add(infile.readLine());
		}

		Collections.sort(dictionary);

		//create a copy of the dictionary arraylist, where all words will already be canonical
		ArrayList<String> canDictionary = new ArrayList<String>();
		for (int i = 0; i < dictionary.size(); i++)
		{
			canDictionary.add(canonical(dictionary.get(i)));
		}

		//read the jumbles into an arraylist
		BufferedReader in2file = new BufferedReader(new FileReader(args[1]));
		ArrayList<String> jumbles = new ArrayList<String>();

		while (in2file.ready())
		{
			jumbles.add(in2file.readLine());
		}

		Collections.sort(jumbles);

		for (String jumbledWord : jumbles)
		{
			String canonJumbled = canonical(jumbledWord);
			System.out.print(jumbledWord + " ");

			for (int i = 0; i < canDictionary.size(); ++i)
			{
				if (canonJumbled.equals(canDictionary.get(i)))
				{
					System.out.print(dictionary.get(i) + " ");
				}
			}

			System.out.println();
		}
	}

	static String canonical(String word)
	{
		char[] letters = word.toCharArray();
		Arrays.sort(letters);
		return new String(letters);
	}

}