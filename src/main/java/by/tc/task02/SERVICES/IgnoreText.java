package by.tc.task02.SERVICES;

public class IgnoreText {
    public static String ignorFirstLine(String fileText) {
        fileText = fileText.substring(fileText.indexOf('<'));
        if (fileText.indexOf('?') == 1) {
            fileText = fileText.substring(fileText.indexOf('>') + 1);
        }
        return fileText;
    }

    public static String ignorComments(String fileText) {
        fileText = fileText.substring(0, fileText.indexOf("<!--")).concat(fileText.substring(fileText.indexOf("-->") + 3));
        return fileText;
    }
}