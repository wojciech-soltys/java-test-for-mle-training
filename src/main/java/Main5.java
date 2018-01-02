import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author www.epam.com
 */
public class Main5 {

    public static void main(String [] args) {

        // The name of the file to open.
        String filename = "temp.txt";

        // This will reference one line at a time
        String line = null;
        Map<String,Integer> requestsPerHost = new TreeMap<String, Integer>();
        BufferedReader bufferedReader = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                new FileReader(filename);

            // Always wrap FileReader in BufferedReader.
            bufferedReader =
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");
                String host = parts[0];
                if(!requestsPerHost.containsKey(host)) {
                    requestsPerHost.put(host, 1);
                } else {
                    requestsPerHost.put(host, requestsPerHost.get(host) + 1);
                }
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" +
                filename + "'");
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '"
                + filename + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // The name of the file to open.
        filename = "records_" + filename;
        BufferedWriter bufferedWriter = null;
        try {
            // Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(filename);

            // Always wrap FileWriter in BufferedWriter.
            bufferedWriter =
                new BufferedWriter(fileWriter);

            for (Map.Entry<String, Integer> entry : requestsPerHost.entrySet()) {
                bufferedWriter.write(entry.getKey() + " " + entry.getValue());
                bufferedWriter.newLine();
            }

        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + filename + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
