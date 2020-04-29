package plantumlgenerator.visitor;

import padl.visitor.IGenerator;

public final class PlantUmlGenerator extends PlantUmlVisitor implements IGenerator {

	@Override
	public String getCode() {
		return this.buffer.toString();
	}

}
