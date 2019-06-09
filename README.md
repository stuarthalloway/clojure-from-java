# clojure-from-java

Example showing calling Clojure from Java.

# Why People Think Might This is Hard

Calling Clojure from Java is easy. The actual hard stuff is not calling Clojure, it is being able to (and therefore having to) make some choices:

* Do I need a build tool? If so, which one? -- maven, lein, boot, tools.deps?
* Do I want to package AOT or source code?
* Do I want the flexibility of proxy and genclass?
* What development workflow do I want?

Many tools make things "easier" by disallowing some of the choices, or by choosing defaults for you.

# Choices Made for This Example

* maven as build tool
* package source code (Clojure code dir is a resource in maven pom.xml)
* maximum flexibility (use features like proxy)
* dev workflow: test and perfect the Clojure code at the REPL, and the Java code by running the main entry point

# Try it

With maven installed:

    mvn -q compile
    mvn -q exec:java -Dexec.mainClass=example.Main
    

