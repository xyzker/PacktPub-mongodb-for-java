Starting WildFly and testing the installation
WildFly start up scripts are located in the bin folder of the root installation. You can
basically start it in two different modes:
¡E Standalone mode, which means that the application server will be a single
Java process, where applications can be executed
¡E Domain mode, in case you want to manage a set of application servers from a
central Java process called the Domain controller
Discussing the domain mode is out of the scope of this book; therefore, we will use
the single process mode (standalone). No changes to your code will be required to
run the application in domain mode.
Hence, you can start the application server by executing the following command
from the bin folder:
/standalone.sh
Windows users should use the equivalent batch script:
standalone.bat

Designing the schema
Our MongoDB documents will be created in the following storage:
¡E Database: ude
¡E Collection: bookstore
The following is the list of keys we will store in our MongoDB document:
¡E Book ID (automatically generated)
¡E Book title (String)
¡E Book author (String)
¡E Book type (String)
¡E Book price (Double)
¡E Book copies (Integer)

Running the application

Whatever is your development environment, you will end up with the web
application deployed on WildFly. So, now, browse over the following URL
in order to test the application:
http://localhost:8080/javaee7-mongodb/index.xhtml