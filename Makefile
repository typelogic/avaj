HelloWorld.class: HelloWorld.java Makefile
	@rm -f Block.class HelloWorld.class
	javac -cp lombok-1.18.10.jar HelloWorld.java
	mv *.class org/demo/
	java org.demo.HelloWorld

StoringIntoKeyStore.class: StoringIntoKeyStore.java keystore
	javac StoringIntoKeyStore.java
	java StoringIntoKeyStore

keystore:
	@rm -f keystore
	keytool -genseckey -alias 256bitkey -keyalg aes -keysize 256 \
		-keystore keystore -storetype jceks -storepass changeit

clean:
	@rm -f *.class org/demo/*.class keystore*

.PHONY: clean
