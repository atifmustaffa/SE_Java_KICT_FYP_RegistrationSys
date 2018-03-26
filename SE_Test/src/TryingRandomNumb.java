import java.io.*;
import java.util.*;

/**
 * 'Atif Mustaffa
 * 1429619
 * 7 Dec 2016
 * SE_Test
 *
 */

public class TryingRandomNumb {
	public static void main(String[] args) {
	    String test;
	    int dolzina = 0;
	    String outputFile = "./src/productsSQLqueries_randomStock.txt";

	    ArrayList<String> list = new ArrayList();


	    try {

	        File file = new File("./src/productsSQLqueries.txt");
	        FileReader fileReader = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String vrstica = bufferedReader.readLine();
	        while (vrstica != null) {

	            list.add(vrstica);
	            vrstica = bufferedReader.readLine();
	            // dolzina=list.size();
	            // System.out.println(dolzina);

	        }

	        FileWriter fileWriter = new FileWriter(outputFile);
	        PrintWriter out = new PrintWriter(fileWriter);
	        System.out.println("Replaced");

            int count = 0;
	        for (int idx = 0; idx < list.size(); ++idx) {
	            test = list.get(idx);
	            dolzina = test.length();

	            Random rGenerator = new Random();
	            String beseda = test;

	            for (int i = 0; i < dolzina; i++) {
	                int randomInt = rGenerator.nextInt(6) + 3;
	                if (beseda.equals("**,")) {
	                	count++;
	                	System.out.println("random" +randomInt);
	                	beseda = ""+randomInt+",";
	                	break;
	                }
	            }
	            out.println(beseda);

	        }out.close();
	        System.out.println(count);
	    } catch (IOException e) {
	        e.printStackTrace();

	    }
	}
}
