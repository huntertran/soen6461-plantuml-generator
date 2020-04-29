package plantumlgenerator.utils;

public class StringUtils {
	public static void addTabs(final int tab, final StringBuffer buffer) {
		for (int i = 0; i < tab; i++) {
			buffer.append("    ");
		}
	}
	
	public static void addNewLine(final StringBuffer buffer) {
		buffer.append(System.getProperty("line.separator"));
	}
}
