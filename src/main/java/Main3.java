import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author www.epam.com
 */
public class Main3 {


    static String findNumber(int[] arr, int k) {
        for(int i =0; i< arr.length; i++){
            if(arr[i] == k){
                return "YES";
            }
        }
        return "NO";
    }

    static int[] oddNumbers(int l, int r) {
        List<Integer> oddNumbers = new ArrayList<Integer>();
        for(int i = l; i<=r; i++){
            if(i%2 == 1) {
                oddNumbers.add(i);
            }
        }
        int[] ints = new int[oddNumbers.size()];
        int i = 0;
        for (Integer n : oddNumbers) {
            ints[i++] = n;
        }
        return ints;
    }

    public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));
        NodeList nodeList = document.getElementsByTagName("entry");
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Element entry = (Element) nodeList.item(i);
            NodeList childrenList = entry.getChildNodes();
            for(int j=0; i<childrenList.getLength(); j++) {
                Node childNode =  childrenList.item(j);
                if(childNode.getNodeName().equals("message")) {
                    if(childNode.getTextContent().equals(message)) {
                        System.out.println(entry.getAttribute("id"));
                    }
                }
            }
        }
        return new ArrayList<Integer>();
    }

    public static void main(String[] args) throws Exception {
        String xml =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<log>\n" +
            "    <entry id=\"1\">\n" +
            "        <message>Application started</message>\n" +
            "    </entry>\n" +
            "    <entry id=\"2\">\n" +
            "        <message>Application ended</message>\n" +
            "    </entry>\n" +
            "</log>";

        Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
        for(int id: ids)
            System.out.println(id);
    }

}
