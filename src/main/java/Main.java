import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author www.epam.com
 */
public class Main {

    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        Collection<Integer> uniqueNumbers = new LinkedList<Integer>();
        for(Integer number : numbers) {
            if (uniqueNumbers.contains(number)) {
                uniqueNumbers.remove(number);
            } else {
                uniqueNumbers.add(number);
            }
        }
        return uniqueNumbers;
    }


    public static void main(String[] args) {
        Collection<Integer> numbers = Arrays.asList(1);
        for (int number : findUniqueNumbers(numbers))
            System.out.println(number);
    }
}
