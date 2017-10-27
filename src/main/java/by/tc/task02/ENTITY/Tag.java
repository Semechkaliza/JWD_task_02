package by.tc.task02.ENTITY;

import by.tc.task02.SERVICES.FindNextTextPart;
import by.tc.task02.SERVICES.IgnoreText;
import by.tc.task02.SERVICES.SeparationNameAttributes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Tag {
    private String name;
    private List<String> content = new LinkedList<>();
    private List<Tag> childs = new LinkedList<>();
    private HashMap<String, String> attribute = new HashMap<>();


    public Tag(String workText) {
        String workPart = FindNextTextPart.findNextTextPart(workText);
        name = SeparationNameAttributes.getElementName(workPart);
        if(!IgnoreText.getContent(workText).isEmpty()) {
            content.add(FindNextTextPart.findNextContent(workText));
        }
        workText = FindNextTextPart.findNextWorkText(workText);
        workText = workText.substring(0, workText.indexOf("</" + name + '>'));


        workPart = FindNextTextPart.findNextTextPart(workText);
        if (workPart == null) {
            content.add(workText);
        }
        while ((workPart != null)) {
            Tag tmp = new Tag(workText);
            childs.add(tmp);
            if (!workPart.equalsIgnoreCase(tmp.getName())) {
                SeparationNameAttributes.separateAttributes(workPart, tmp);
            }
            workText = workText.substring(workText.indexOf("</" + tmp.getName() + '>') + 3 + tmp.getName().length());

            workPart = FindNextTextPart.findNextTextPart(workText);
            if (workPart == null) {
                content.add(workText);
            }
        }

    }

    public void addAttribute(String key, String value) {
        attribute.put(key, value);
    }

    public String getName() {
        return name;
    }

    public void draw(int deep) {
        for (int i = 0; i < deep; i++) System.out.print(" ");
        for (String value : content)
            System.out.print(value + " ");

        for (String value : attribute.values())
            System.out.print(" " + value);
        System.out.print("\n");
        for (Tag ch : childs) {
            ch.draw(deep + 4);
        }
    }


}