package uz.bakhromjon;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FizzBuzz {
    public void execute(int n) {
        for (int i = 1; i <= n; i++) {
            String result = "";
            System.out.println(i);
            if (i % 3 == 0) {
                result = "Fizz";
            }
            if (i % 5 == 0) {
                result = "Buzz";
            }
            System.out.println(result.isEmpty() ? i : result);
        }
    }
}
