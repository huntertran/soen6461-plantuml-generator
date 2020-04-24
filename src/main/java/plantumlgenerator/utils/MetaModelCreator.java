package plantumlgenerator.utils;

import padl.analysis.UnsupportedSourceModelException;
import padl.creator.classfile.CompleteClassFileCreator;
import padl.kernel.ICodeLevelModel;
import padl.kernel.exception.CreationException;
import padl.kernel.impl.Factory;
import padl.statement.creator.classfiles.ConditionalModelAnnotator;
import padl.statement.creator.classfiles.LOCModelAnnotator;
import padl.util.ModelStatistics;

public class MetaModelCreator {
    public static class UniqueMetaModelCreatorHolder {
        private static final MetaModelCreator UNIQUE_META_MODEL_CREATOR = new MetaModelCreator();
    }

    public static MetaModelCreator getInstance() {
        return UniqueMetaModelCreatorHolder.UNIQUE_META_MODEL_CREATOR;
    }

    public static ICodeLevelModel createMetaModelsFromJar(final String aBinPath) {
        ICodeLevelModel codeLevelModel = Factory.getInstance().createCodeLevelModel("");
        final ModelStatistics statisticModelListener = new ModelStatistics();
        codeLevelModel.addModelListener(statisticModelListener);

        try {
            codeLevelModel.create(new CompleteClassFileCreator(new String[] { aBinPath }, true));

            final ConditionalModelAnnotator annotator = new ConditionalModelAnnotator(new String[] { aBinPath });
            final ICodeLevelModel annotatedCodeLevelModel = (ICodeLevelModel) annotator.invoke(codeLevelModel);

            final LOCModelAnnotator annotator2 = new LOCModelAnnotator(new String[] { aBinPath });

            codeLevelModel = (ICodeLevelModel) annotator2.invoke(annotatedCodeLevelModel);

            return codeLevelModel;

        } catch (final CreationException e) {
            e.printStackTrace();
        } catch (final UnsupportedSourceModelException e) {
            e.printStackTrace();
        }

        return null;
    }

}