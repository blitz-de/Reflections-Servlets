package htwb.ai;

//--Import Annotations
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
// -- Import Reflections
import java.lang.reflect.Method;

/**
 * Add meta-annotations to specify the scope and the targe of our custon annotation
 * 
 * a. @Retention (RetentionPolicy.RUNTIME)		// has runtime visibility, and we can apply it to types (classes). It has no methods
 * 												// and thus serves as a simple marker to mark classes that can be serialized into JSON
 * b. @Target(ElementType.Type)  // class Level annotation
 * c. @Target(ElementType.FIELD) // Field Level annotation
 * QUELLE: https://www.baeldung.com/java-custom-annotation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target (ElementType.METHOD)

public @interface RunMe {
	
	String name() default "" ;
}