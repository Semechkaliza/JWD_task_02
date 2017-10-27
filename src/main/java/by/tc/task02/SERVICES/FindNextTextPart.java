package by.tc.task02.SERVICES;

public class FindNextTextPart {
    public static String findNextContent(String workText) {
        String content = workText.substring(0, workText.indexOf('<'));
        return content;
    }

    public static String findNextTextPart(String workText) {
        if (!(workText.contains("<") && workText.contains(">"))) return null;
        String workPart = workText.substring(workText.indexOf('<') + 1, workText.indexOf('>'));
        return workPart;
    }

    public static String findNextWorkText(String workText) {
        workText = workText.substring(workText.indexOf('>') + 1);
        return workText;
    }
}

