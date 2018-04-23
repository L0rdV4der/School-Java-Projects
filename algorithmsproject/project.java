package algorithmsproject1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * @author DarthVader
 *
 */
public class project {
	
	
    /**
     * Finds the directory of the program to be checked*
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(project.check("/Users/DarthVader/eclipse-workspace/Heapsort/src/hw5/heap.java"));
    }
   
    
    /**
     * This checks the strings in the file and sets up the compiler
     * @param file
     * This handles the file management and gets the java objects from strings*
     * This checks to see if what's is in the program has errors or not*
     * This handles the output of any errors*
     * This prints out the error messages and Enjoy your output*
     * @return lists of strings
     */
    public static List<String> check(String file) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        
   
        
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> compilationUnits =
                fileManager.getJavaFileObjectsFromStrings(Arrays.asList(file));
        
        
     
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits).call();

        
        List<String> messages = new ArrayList<String>();
        Formatter formatter = new Formatter();
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            messages.add(diagnostic.getKind() + ":\t Line [" + diagnostic.getLineNumber() + "] \t Position [" + diagnostic.getPosition() + "]\t" + diagnostic.getMessage(Locale.ROOT) + "\n");
        }

        System.out.println("Enjoy your output.");
        return messages;
    }
}