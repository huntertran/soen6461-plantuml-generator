package plantumlgenerator;

import padl.kernel.ICodeLevelModel;
import plantumlgenerator.utils.MetaModelCreator;
import plantumlgenerator.visitor.PlantUmlGenerator;
import plantumlgenerator.visitor.PlantUmlWalker;

public class App {
    public static void main(String[] args) {
        ICodeLevelModel models = MetaModelCreator.createMetaModelsFromCompiledClasses("./src/test/java/plantumlgenerator/padl/event/");
        
//        String walked = (String) models.walk(new PlantUmlWalker());
        String generatedString = models.generate(new PlantUmlGenerator());
        
        System.out.println(generatedString);
    }
}
