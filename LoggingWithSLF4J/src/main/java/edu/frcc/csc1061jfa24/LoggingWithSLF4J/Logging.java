package edu.frcc.csc1061jfa24.LoggingWithSLF4J;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
	
	private static Logger logger = LogManager.getLogger(Logging.class);

	public static void main(String[] args) {
		logger.info("Just information");
		logger.error("Idk something broke");
		logger.warn("Something could break");
	}

}
