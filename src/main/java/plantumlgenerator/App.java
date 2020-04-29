package plantumlgenerator;

import java.awt.TextArea;

import javax.swing.JFrame;

import padl.kernel.ICodeLevelModel;
import plantumlgenerator.utils.MetaModelCreator;
import plantumlgenerator.visitor.PlantUmlGenerator;

public class App {
    public static void main(String[] args) {
        ICodeLevelModel models = MetaModelCreator.createMetaModelsFromCompiledClasses("./src/test/java/plantumlgenerator/padl/event/");

        // String walked = (String) models.walk(new PlantUmlWalker());
        String generatedString = models.generate(new PlantUmlGenerator());

        System.out.println(generatedString);
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                creatAndShowUI(generatedString);
            }
        });

    }

    private static void creatAndShowUI(String generatedUmlString) {
        JFrame frame = new JFrame();
        frame.setTitle("Generated Plantuml code");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TextArea(generatedUmlString));

        frame.pack();
        frame.setVisible(true);
    }
}
