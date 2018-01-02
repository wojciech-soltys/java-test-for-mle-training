import java.util.regex.Pattern;

/**
 * @author www.epam.com
 */
public class Main2 {

    public static boolean validate(String password) {
        //Pattern pattern = Pattern.compile("^(?=.*[a-zA-Z0-9])*?-?(?=\\S+$).{6,16}$");
        //Pattern pattern = Pattern.compile("(?=^.{6,16})[a-zA-Z0-9]*?-[a-zA-Z0-9]+");

        Pattern pattern = Pattern.compile("(?=^.{6,16})[a-zA-Z0-9]*?-[a-zA-Z0-9]+");

       // [a-z]{1,6}?_?[0-9]{0,4}@[hackerrank.com]+
        return pattern.matcher(password).matches();
    }

    public static void main(String[] args) {
        //System.out.println(validate("Mike-Standish")); // Valid username
        //.out.println(validate("Mike Standish")); // Invalid username

        System.out.println(validate("Mike-Standish"));
        System.out.println(validate("Mike-Standish"));
        System.out.println(validate("Mike-Standish"));
        System.out.println(validate("Mike-Standish"));
        System.out.println(validate("Mike-Standish"));

    }

}
