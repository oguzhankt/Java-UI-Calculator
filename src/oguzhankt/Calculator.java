package oguzhankt;

/**
 * Created by Oğuzhan on 5.5.2017.
 */
public class Calculator {

    public static String operate(double first, double second, String operation){
        Double result = 0.0;
        switch (operation){
            case("X"):
                result = first * second;
                break;
            case("/"):
                result = first / second;
                break;
            case("-"):
                result = first - second;
                break;
            case("+"):
                result = first + second;
                break;
        }

        return result.toString();
    }

}