package plantumlgenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import padl.kernel.ICodeLevelModel;
import plantumlgenerator.utils.MetaModelCreator;
import plantumlgenerator.visitor.PlantUmlGenerator;

/**
 * Test the singleton MetaModelCreator class
 */
public class MetaModelCreatorTest {

    private String readFromFile(String filePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void generatePlantUmlCodeTest()
    {
        // setup
        String pathToClassesFolder = "./src/test/java/plantumlgenerator/padl/event/";
        String expectedResult = this.readFromFile("./src/test/java/plantumlgenerator/GeneratedPlantUmlForPadlEventFolder.puml");
        
        // action
        ICodeLevelModel codeLevelModel = MetaModelCreator.getInstance()
                .createMetaModelsFromCompiledClasses(pathToClassesFolder);
        String generatedPlantUml = codeLevelModel.generate(new PlantUmlGenerator());
        
        // assert
        Assert.assertEquals(expectedResult, generatedPlantUml);
    }
}
