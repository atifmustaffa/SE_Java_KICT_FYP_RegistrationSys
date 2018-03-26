import java.io.*;
import java.util.*;

/**
 * 'Atif Mustaffa
 * 1429619
 * 7 Dec 2016
 * SE_Test
 *
 */

public class TryingImagesLink {
	public static void main(String[] args) {
	    String test;
	    int dolzina = 0;
	    String outputFile = "./src/productsSQLqueries_randomStock_and_images.txt";

	    ArrayList<String> list = new ArrayList();


	    try {

	        File file = new File("./src/productsSQLqueries_randomStock.txt");
	        FileReader fileReader = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String vrstica = bufferedReader.readLine();
	        while (vrstica != null) {

	            list.add(vrstica);
	            vrstica = bufferedReader.readLine();

	        }

	        FileWriter fileWriter = new FileWriter(outputFile);
	        PrintWriter out = new PrintWriter(fileWriter);
	        System.out.println("Inserted");

            int count = 0;
	        for (int idx = 0; idx < list.size(); ++idx) {
	            test = list.get(idx);
	            dolzina = test.length();
	            String beseda = test;

	            for (int i = 0; i < dolzina; i++) {
	                
	                if (beseda.equals("'#',")) {
	                	count++;
	                	System.out.println("images link: ./images/products/" + list.get(idx+1).toLowerCase().replace("'", "") + "/" + list.get(idx-4).replace("'", "").replace(",", "") + ".jpg");
	                	beseda = "'" + "./images/products/" + list.get(idx+1).toLowerCase().replace("'", "") + "/" + list.get(idx-4).replace("'", "").replace(",", "") + ".jpg" + "',";
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
