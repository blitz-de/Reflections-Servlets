package htwb.ai;
import org.junit.Assert;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppTest {
    private static MeanTestMethoden mtm = new MeanTestMethoden();
    private static ReflectedClass reflectClass;
    static Method[] alleMethoden;
    
    static Class clazz = mtm.getClass();
    @BeforeAll
    public static void runnerSetup() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        reflectClass = new ReflectedClass(MeanTestMethoden.class);
        
        alleMethoden = clazz.getDeclaredMethods();
    }

    @Test
    public void testAnzahlDelariertenAlleMethoden() {
    	assertEquals(7, alleMethoden.length);
    }
    
    @Test
    public void testAnzahlAnnotierteMethoden() {
    	
    	assertEquals(7,reflectClass.anzahlAnnotatedMethods());
    	
    }
    
    @Test
    public void weitereTestMethode () {
    	// ...
    }

}
