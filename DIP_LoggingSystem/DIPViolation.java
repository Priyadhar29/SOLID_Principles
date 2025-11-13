package DIP_LoggingSystem;


//❌ High-level module (Application) depends directly on low-level modules (ConsoleLogger, FileLogger)
//❌ No abstraction (interface) — tightly coupled design

class ConsoleLogger {
 public void log(String message) {
     System.out.println("[Console Log] " + message);
 }
}

class FileLogger {
 public void log(String message) {
     System.out.println("[File Log] " + message + " (written to file)");
 }
}

//❌ Application directly depends on concrete loggers — violates DIP
class Application {
	
 private ConsoleLogger consoleLogger = new ConsoleLogger();
 private FileLogger fileLogger = new FileLogger();

 public void performTask() {
     consoleLogger.log("Task started...");
     System.out.println("Performing some work...");
     fileLogger.log("Task completed successfully!");
 }
}

public class DIPViolation {
 public static void main(String[] args) {
     Application app = new Application();
     app.performTask();
 }
}

/* 
  Throw an exception 
  
  Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	The constructor Application() is undefined

	at DIP_LoggingSystem.DIPViolation.main(DIPViolation.java:33)

 */