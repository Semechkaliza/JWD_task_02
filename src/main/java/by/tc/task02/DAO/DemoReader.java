package by.tc.task02.DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DemoReader {
    public static String read() {
        try (BufferedReader br = new BufferedReader(new FileReader("d://Обучение/courses/JWD_Task2/src/main/resources/task02.xml"))) {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            return sb.toString();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}