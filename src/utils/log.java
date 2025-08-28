package utils;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class log {
	private static final Logger logger = LogManager.getLogger(log.class);
	
		public static void info (String message) 
		{
			logger.info(message);
		}
		public static void error (String message) 
		{
			logger.error(message);
		}
		public static void warn (String message) 
		{
			logger.warn(message);
		}
		public static void debug (String message) 
		{
			logger.debug(message);
		}
		
	}

