package plantumlgenerator;

import java.awt.TextArea;
import java.util.Scanner;

import javax.swing.JFrame;

import padl.kernel.ICodeLevelModel;
import plantumlgenerator.utils.MetaModelCreator;
import plantumlgenerator.visitor.PlantUmlGenerator;

/**
 * The main class to run the tool
 */
public class App {
    /**
     * Main method to run the tool
     * @param args[0] the folder contain compiled java classes
     * @param args[1] is show the result in console window. Accept "y" for yes and "n" for no
     */
    public static void main(final String[] args) {

        String compiledClassesFolder = "";
        boolean isShowResultInConsole = false;

        if (args.length != 0) {
            compiledClassesFolder = args[0];
        } else {
            final Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the folder contain compiled java classes: ");
            compiledClassesFolder = scanner.nextLine();

            System.out.print("Show the result in console windows? [y] yes - [n] no: ");
            final String yesNo = scanner.nextLine();

            switch (yesNo.toLowerCase()) {
                case "yes":
                case "y": {
                    isShowResultInConsole = true;
                    break;
                }
                default: {
                    isShowResultInConsole = false;
                    break;
                }
            }

            scanner.close();
        }

        // compiledClassesFolder = "./src/test/java/plantumlgenerator/padl/event/";
        final ICodeLevelModel models = MetaModelCreator.getInstance()
                .createMetaModelsFromCompiledClasses(compiledClassesFolder);

        // String walked = (String) models.walk(new PlantUmlWalker());
        final String generatedString = models.generate(new PlantUmlGenerator());

        if (isShowResultInConsole) {
            System.out.println(generatedString);
        } else {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowUI(generatedString);
                }
            });
        }
    }

    private static void createAndShowUI(final String generatedUmlString) {
        final JFrame frame = new JFrame();
        frame.setTitle("Generated Plantuml code");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TextArea(generatedUmlString));

        frame.pack();
        frame.setVisible(true);
    }
}
