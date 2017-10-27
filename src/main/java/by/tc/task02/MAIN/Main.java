package by.tc.task02.MAIN;


import by.tc.task02.DAO.DemoReader;
import by.tc.task02.ENTITY.Tag;
import by.tc.task02.SERVICES.FindNextTextPart;
import by.tc.task02.SERVICES.IgnoreText;
import by.tc.task02.SERVICES.SeparationNameAttributes;

public class Main {
    public static void main(String[] args) {

        String fileText = DemoReader.read();
        fileText = IgnoreText.ignorFirstLine(fileText);
        while (fileText.contains("<!--")) {
            fileText = IgnoreText.ignorComments(fileText);
        }
        Tag tree = new Tag(fileText);
        String workPart = FindNextTextPart.findNextTextPart(fileText);
        if (!workPart.equalsIgnoreCase(tree.getName())) {
            SeparationNameAttributes.separateAttributes(workPart, tree);
        }
        tree.draw(0);
    }
}
