HelloWorld.class: HelloWorld.java Makefile
	@rm -f Block.class HelloWorld.class
	javac -cp lombok-1.18.10.jar HelloWorld.java
	mv *.class org/demo/
	java org.demo.HelloWorld

clean:
	@rm -f *.class org/demo/*.class

.PHONY: clean
