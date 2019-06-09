package example;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.Callable;

public class Main {
    public static Object callClojure(String ns, String fn) throws Exception {
        // load Clojure lib. See https://clojure.github.io/clojure/javadoc/clojure/java/api/Clojure.html
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read(ns));

        return ((Callable) Clojure.var(ns, fn)).call();
    }
    public static void main(String[] args) throws Exception {
        // Clojure fns are callable
        Callable fn = (Callable) callClojure("example.impl", "create-hello-fn");
        System.out.println("fn says " + fn.call());

        // implement interfaces
        FileFilter filter = (FileFilter) callClojure("example.impl", "create-never-filter");
        System.out.println("file filter returns " + filter.accept(new File("canttouchthis")));

        // extend classes
        Object o = callClojure("example.impl", "create-timestamped-object");
        System.out.println("object toString returns " + o);
    }


}
