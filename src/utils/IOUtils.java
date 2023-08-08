package src.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class IOUtils {
    public static String readUserInput(BufferedReader reader) {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입력 오류가 발생했습니다.", e);
        }
    }

    public static void closeReader(BufferedReader reader) {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
