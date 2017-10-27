package by.tc.task02.SERVICES;

import by.tc.task02.ENTITY.Tag;

public class SeparationNameAttributes {
    public static String getElementName(String workPart) {
        String name = workPart;
        if (workPart.contains(" ")) {
            name = name.substring(0, name.indexOf(' '));
        }
        return name;
    }

    public static void separateAttributes(String workPart, Tag currentEl) {
        while (!workPart.isEmpty()) {
            if (workPart.contains(" ")) {
                workPart = workPart.substring(workPart.indexOf(' ') + 1);
            }
            String key = workPart.substring(0, workPart.indexOf('='));
            workPart = workPart.substring(workPart.indexOf('"') + 1);
            String value = workPart.substring(0, workPart.indexOf('"'));
            workPart = workPart.substring(workPart.indexOf('"') + 1);
            currentEl.addAttribute(key, value);
        }
    }
}