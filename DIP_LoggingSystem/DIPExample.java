package DIP_LoggingSystem;

//✅ DIP Example: High-level module depends on abstraction, not concrete implementation.

interface Logger {
 void log(String message);
}

class ConsoleLogger implements Logger {
 public void log(String message) {
     System.out.println("[Console Log] " + message);
 }
}

class FileLogger implements Logger {
 public void log(String message) {
     System.out.println("[File Log] " + message + " (written to file)");
 }
}

class Application {
 private Logger logger;
 public Application(Logger logger) {
     this.logger = logger;
 }

 public void performTask() {
     logger.log("Task started...");
     System.out.println("Performing some work...");
     logger.log("Task completed successfully!");
 }
}

public class DIPExample {
 public static void main(String[] args) {
     Application app1 = new Application(new ConsoleLogger());
     app1.performTask();

     Application app2 = new Application(new FileLogger());
     app2.performTask();
 }
}


/*OUTPUT:

  	[Console Log] Task started...
	Performing some work...
	[Console Log] Task completed successfully!
	[File Log] Task started... (written to file)
	Performing some work...
	[File Log] Task completed successfully! (written to file)
	
 */