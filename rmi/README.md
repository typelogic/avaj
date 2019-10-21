# Manual Compile Server/Client
Ensure presence of the following executables:
- `java`
- `javac`
- `rmic`
- `rmiregistry`
- `make`

If you have installed recent Java JDK then all of the above executables should be present in your system. Otherwise, install
JDK from either closesource `Oracle` or from opensource `OpenJDK`.

The `make` executable for Windows system shall exists if you install `Cygwin`. You can continue without `make` by manually
compiling the steps indicated in the Makefile.

If you have `make`, open shell and do:

```
make all
```

# Run Server
Open shell and do:
```
cd server/
rmiregistry
```

Open another shell and do:
```
cd server/
java -Djava.rmi.server.hostname=127.0.0.1 Server
```

If the server is running in a different computer, replace the ip address.

# Run Client
Open shell and send request to the server to add two numbers `3` and `4`. It should give sum `7`:
```
cd client/
java Client 127.0.0.1 3 4
The sum is is: 7.0
```
If the server is running in a different computer, replace the ip address.
