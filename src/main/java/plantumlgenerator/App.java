package plantumlgenerator;

import padl.kernel.ICodeLevelModel;
import padl.visitor.IWalker;
import plantumlgenerator.utils.MetaModelCreator;
import plantumlgenerator.visitor.PlantUmlWalker;

public class App {
    public static void main(String[] args) {
        ICodeLevelModel models = MetaModelCreator.createMetaModelsFromCompiledClasses("./src/test/java/plantumlgenerator/padl/");
        
        IWalker myPlantUMLWalker = new PlantUmlWalker();
        
        models.walk(myPlantUMLWalker);
        
        System.out.println(models);
    }
}
