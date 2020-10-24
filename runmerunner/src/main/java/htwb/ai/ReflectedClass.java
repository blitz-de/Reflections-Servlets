package htwb.ai;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.Collator;
import java.util.ArrayList;
import java. util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ReflectedClass {

	Annotation annotInstance;
	MeanTestMethoden mtm = new MeanTestMethoden();
	Class reflectClass = mtm.getClass();
	Method[] methods = reflectClass.getDeclaredMethods();
	TreeSet<String> treeSet = new TreeSet<String>();
    private Class clazzIn;
    
    public ReflectedClass (Class clazzIn) {
        this.clazzIn = clazzIn;
    }
    
    public Class getClazzIn() {
    	return clazzIn;
    }
	/**
	 * Aufgabe3)
	 * Ausgabe aller deklarierten Methoden der Klasse
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public void alleMethodenAuflisten() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		System.out.println("Analyzed class '"+reflectClass.getName()+"'");
		/* List methods of a class using Java Reflection
		 * Q: <https://www.tutorialspoint.com/list-methods-of-a-class-using-java-reflection>
		*/
//		for (int i = 0; i < methods.length; i++) {
//			System.out.println(methods[i].getName());
//		}
		returnAllMethodsWithoutRM();
		returnAllAnnotatedMethods();
	}
	
	/**
	 * Ruft alle annotierte Methoden auf
	 * Q: <https://stackoverflow.com/questions/16996033/how-to-run-all-methods-with-a-given-annotation>
	 * @param annotation
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws Exception
	 */
	public void returnAllAnnotatedMethods() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Method[] classMethods = reflectClass.getDeclaredMethods();
		System.out.print("Methods with @RunMe: "+"\n");
		
		for (Method method :classMethods) {			
			if (method.isAnnotationPresent(RunMe.class)) {
				try {
				annotInstance = method.getAnnotation(RunMe.class);
				method.invoke(mtm);
				treeSet = new TreeSet<String>();
				treeSet.add(method.getName());
				
				TreeSet<String> res  = (TreeSet<String>)treeSet.descendingSet();
				res.forEach(System.out::println);
				//System.out.println(treeSet);
				} 
				catch (SecurityException
						| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			} 
		}
	}
	public void returnAllMethodsWithoutRM() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Method[] classMethods = reflectClass.getDeclaredMethods();
		System.out.print("Methods without @RunMe:"+"\n");
		for (Method method :classMethods) {			
			if (!method.isAnnotationPresent(RunMe.class)) {
				//Annotation annotInstance = method.getAnnotation(RunMe.class);
				try {
					//method.setAccessible(true);
					method.invoke(mtm);
					treeSet = new TreeSet<String>();
					treeSet.add(method.getName());
					
					TreeSet<String> res  = (TreeSet<String>)treeSet.descendingSet();	
					res.forEach(System.out::println);

				} catch (SecurityException | IllegalAccessException 
						| IllegalArgumentException | InvocationTargetException e) {
						//method.setAccessible(true);
						//method.invoke(mtm);
						//reflectClass.getDeclaredMethods();
						//method.getName();
						System.out.println("not invocable: ");
						System.out.println(method.getName() +": "+ e.toString());
				}
	
			}
		}
	}
	
	public int anzahlAnnotatedMethods() {
		for (Method method: methods) {
			if (method.isAnnotationPresent(RunMe.class)){
				int anzahl=0;
				for(int i=0; i <methods.length; i++) {
					anzahl = i+1;
				}
				return anzahl ;
			}
		}
		return 0;
		

	}
	protected boolean MethodIsPrivate(Method m) {
		boolean isPrivate = Modifier.toString(m.getModifiers()).equals("private");
		m.setAccessible(true);
		
		return isPrivate;
	}

    
}
