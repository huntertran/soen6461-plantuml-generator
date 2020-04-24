package plantumlgenerator;

import padl.kernel.ICodeLevelModel;
import plantumlgenerator.utils.MetaModelCreator;

public class App {
    public static void main(String[] args) {
        ICodeLevelModel models = MetaModelCreator.createMetaModelsFromJar("/src/test/java/plantumlgenerator/padl/");
        System.out.println(models);
    }
}
