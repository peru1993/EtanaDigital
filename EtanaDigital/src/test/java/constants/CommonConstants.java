package constants;

import java.io.File;

public class CommonConstants {
	
	private final static int IMPLICITWAITTIME = 15;
	
	private final static String projectDirectory = System.getProperty("user.dir");
	
	
	private final static String CONFIG_FILEPATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources"  + File.separator + "properties" + File.separator +  "config.properties";
	
//	public static void main(String[] args) {
//		
//		System.out.println(directory);
//	}
	
		
	
	public static String getConfigFilePath() {
		return CONFIG_FILEPATH;
	}
	
	public static int getImplicitWaitTime() {
		return IMPLICITWAITTIME;
	}
	
}
