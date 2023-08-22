package src.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOUtils {
    public final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readUserInput() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입력 오류가 발생했습니다.", e);
        }
    }

    public static void closeReader() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
