all: client server

server: Server.class IArithmetic.class IArithmeticImpl.class IArithmeticImpl_Stub.class 
	#@rm -rf server/ *.class # dxerror1
	mkdir -p server/
	cp Server.class IArithmetic.class IArithmeticImpl.class IArithmeticImpl_Stub.class server/

client: Client.class IArithmetic.class IArithmeticImpl_Stub.class
	mkdir -p client/
	cp Client.class IArithmetic.class IArithmeticImpl.class IArithmeticImpl_Stub.class client/

%.class: %.java
	javac $<

IArithmeticImpl_Stub.class: IArithmeticImpl.class
	rmic IArithmeticImpl

clean:
	@rm -rf *.class server/ client/

.PHONY: clean
