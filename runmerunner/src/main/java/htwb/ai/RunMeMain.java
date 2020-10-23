package htwb.ai;

//import java.lang.module.ModuleDescriptor.Exports.Modifier;
import java.lang.reflect.InvocationTargetException;

public class RunMeMain {

	static MeanTestMethoden meanTm;
	
	public static void main (String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException  {
		ReflectedClass reflectedClass = new ReflectedClass(MeanTestMethoden.class);
		
		reflectedClass.alleMethodenAuflisten();

	
	}
}
