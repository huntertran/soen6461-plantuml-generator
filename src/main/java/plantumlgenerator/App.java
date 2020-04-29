package plantumlgenerator;

import padl.kernel.ICodeLevelModel;
import plantumlgenerator.utils.MetaModelCreator;
import plantumlgenerator.visitor.PlantUmlGenerator;

public class App {
    public static void main(String[] args) {
        ICodeLevelModel models = MetaModelCreator.createMetaModelsFromCompiledClasses("./src/test/java/plantumlgenerator/padl/event/");
        
//        IWalker myPlantUMLWalker = new PlantUmlWalker();
//        
//        Object walked = models.walk(myPlantUMLWalker);
        String generatedString = models.generate(new PlantUmlGenerator());
        
        System.out.println(generatedString);
    }
}
