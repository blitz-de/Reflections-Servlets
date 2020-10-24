package htwb.ai;

//import java.lang.module.ModuleDescriptor.Exports.Modifier;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class RunMeMain {

	static MeanTestMethoden meanTm = new MeanTestMethoden();
	static Class reflectClass = meanTm.getClass();
	public static void main (String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException  {
		ReflectedClass reflectedClass = new ReflectedClass(MeanTestMethoden.class);
		
		boolean again =true;
		/**
		 * Eingabe der Klasse, wenn falsch
		 */

		String classNameArgument = "";
		String className;

		
		Scanner input = new Scanner(System.in).useDelimiter("\r\n");
		while(again) {
		try {
			classNameArgument = args[0];
			className = classNameArgument;
			
			//className = input.next();
			
			Class<?> clazz = Class.forName(classNameArgument);
			
			//methodenAuflisten();
			reflectedClass.alleMethodenAuflisten();
			again = false;
	}
		 catch (ArrayIndexOutOfBoundsException e) {
	            System.out.println("Please enter the class name");
	            again = false;
	            input.next();
	        } 
		catch (ClassNotFoundException e) {
            System.out.println("Error: Could not find class "+ classNameArgument);
            System.out.println("Usage: java -jar runmerunner-SAKDER.jar "+reflectClass);
           //input.close();
			//classNameArgument = input.next();
            input.next();
            input.close();
        }
		}
		reflectedClass.alleMethodenAuflisten();

	
	}
}
