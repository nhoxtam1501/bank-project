package dev.ducku.bankingproject.utils;

import java.time.LocalDateTime;
import java.util.Random;

public class AccountUtils {
    public static String generateAccountNumber() {
        int currentYear = LocalDateTime.now().getYear();
        int min = 100_000;
        int max = 999_999;
        Random random = new Random();
        int randomNumber = random.nextInt(min, max + 1);
        return currentYear + "" + randomNumber;
    }
}
