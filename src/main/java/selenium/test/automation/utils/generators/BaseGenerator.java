package selenium.test.automation.utils.generators;

import java.util.Random;

public class BaseGenerator {

    private char[] baseChars = "qwertyuiopasdfghjklzxcvbnm ".toCharArray();

    public String generateString (int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = baseChars[random.nextInt(baseChars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public int generateNumber (int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}