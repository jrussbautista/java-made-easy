package com.example.jamesrussel.javamadeeasy;

import android.annotation.TargetApi;
import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;


public class GlossaryActivity extends AppCompatActivity {

    private GlossaryAdapter glossaryAdapter;
    ListView listView;
    Cursor cursor;
    GlossaryRepo glossaryRepo;
    private final static String TAG= MainActivity.class.getName().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glossary);
        Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.glossary_title);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        glossaryRepo = new GlossaryRepo(this);
        cursor= glossaryRepo.getStudentList();
         glossaryAdapter = new GlossaryAdapter(GlossaryActivity.this,  cursor, 0);
        listView = (ListView) findViewById(R.id.lstStudent);
        listView.setAdapter(glossaryAdapter);
        if(cursor==null)insertDummy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId())
        {
            case android.R.id.home:
                super.onBackPressed();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
        return super.onOptionsItemSelected(item);

    }

    @Override public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void insertDummy(){
        GlossaryDescription glossaryDescription = new GlossaryDescription();


        glossaryDescription.email="A class that cannot be used to create objects, and that exists only for the purpose of creating subclasses. Abstract classes in Java are defined using the modifier abstract.";
        glossaryDescription.name="Abstract Class";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A data type for which the possible values of the type and the permissible operations on those values are specified, without specifying how the values and operations are to be implemented.";
        glossaryDescription.name="Abstract Data Type (ADT)";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A modifier used on a method definition or variable specification that determines what classes can use that method or variable. The access specifiers in Java are public, protected, and private. A method or variable that has no access specifier is said to have \"package\" visibility.";
        glossaryDescription.name="Access Specifier";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A data structure that contains all the information necessary to implement a subroutine call, including the values of parameters and local variables of the subroutine and the return address to which the computer will return when the subroutine ends. Activation records are stored on a stack, which makes it possible for several subroutine calls to be active at the same time. ";
        glossaryDescription.name="Activation Record";
        glossaryRepo.insert(glossaryDescription);


        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="In a recursive algorithm, a simple case that is handled directly rather than by applying the algorithm recursively.";
        glossaryDescription.name="Base Case";
        glossaryRepo.insert(glossaryDescription);


        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A number encoded as a sequence of zeros and ones. A binary number is represented in the \"base 2\" in the same way that ordinary numbers are represented in the \"base 10.\"";
        glossaryDescription.name="Binary Number";
        glossaryRepo.insert(glossaryDescription);


        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A linked data structure that is either empty or consists of a root node that contains pointers to two smaller (possibly empty) binary trees. The two smaller binary trees are called the left subtree and the right subtree.";
        glossaryDescription.name="Binary Tree";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A single-digit binary number, which can be either 0 or 1.";
        glossaryDescription.name="Bit";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A system or component of a system that can be used without understanding what goes on inside the box. A black box has an interface and an implementation. A black box that is meant to be used as a component in a system is called a module.";
        glossaryDescription.name="Black Box";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="In Java programming, a sequence of statements enclosed between a pair of braces, { and }. Blocks are used to group several statements into a single statement. A block can also be empty, meaning that it contains no statements at all and consists of just an empty pair of braces.";
        glossaryDescription.name="Block";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A queue in which the dequeue operation will block if the queue is empty, until an item is added to the queue. If the blocking queue has a limited capacity, the enqueue operation can also block, if the queue is full.";
        glossaryDescription.name="Blocking queque";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An approach to software design in which you start by designing basic components of the system, then combine them into more complex components, and so on.";
        glossaryDescription.name="Bottom-up Design";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A class representing \"off-screen canvases,\" that is, images that are stored in the computer's memory and that can be used for drawing images off-screen.";
        glossaryDescription.name="Buffered Image";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A control structure that allows the computer to choose among two or more different courses of action. Java has two branch statements: if statements and switch statements.";
        glossaryDescription.name="Branch";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A unit of memory that consists of eight bits. One byte of memory can hold an eight-bit binary number.";
        glossaryDescription.name="Byte";
        glossaryRepo.insert(glossaryDescription);


        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="\"Java bytecode\" is the usual name for the machine language of the Java Virtual Machine. Java programs are compiled into Java bytecode, which can then be executed by the JVM.";
        glossaryDescription.name="Bytecode";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A particular encoding of character data into binary form. Examples include UTF-8 and ISO-8859-1.";
        glossaryDescription.name="Charset";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An exception in Java that must be handled, either by a try..catch statement or by a throws clause on the method that can throw he exception. Failure to handle a checked exception in one way or the other is a syntax error.";
        glossaryDescription.name="Checked Exception";
        glossaryRepo.insert(glossaryDescription);


        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The basic unit of programming in Java. A class is a collection of static and non-static methods and variables. Static members of a class are part of the class itself; non-static, or \"instance,\" members constitute a blueprint for creating objects, which are then said to \"belong\" to the class.";
        glossaryDescription.name="Class";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A model of network communication in which a \"server\" waits at a known address on the network for connection requests that are sent to the server by \"clients.\" This is the basic model for communication using the TCP/IP protocol.";
        glossaryDescription.name="Client/ Server";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A way of interacting with the computer in which the user types in commands to the computer and the computer responds to each command.";
        glossaryDescription.name="Command-Line Interface";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="In a computer program, text that is ignored by the computer. Comments are for human readers, to help them understand the program.";
        glossaryDescription.name="Comment";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A computer program that translates programs written in some computer language (generally a high-level language) into programs written in machine language.";
        glossaryDescription.name="Compiler";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="General term for a visual element of a GUI, such as a window, button, or menu. A component is represented in Java by an object belonging to a subclass of the class java.awt.Component.";
        glossaryDescription.name="Component";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A special kind of subroutine in a class whose purpose is to construct objects belonging to that class. A constructor is called using the new operator, and is not considered to be a \"method.\"";
        glossaryDescription.name="Constructor";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A component, such as a JPanel, that can contain other GUI components. Containers have add() methods that can be used to add components.";
        glossaryDescription.name="Container";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The semantic component of the method's interface. The contract specifies the responsibilities of the method and of the caller of the method. It says how to use the method correctly and specifies the task that the method will perform when it is used correctly. The contract of a method should be fully specified by its Javadoc comment.";
        glossaryDescription.name="Contract of Method";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A program structure such as an if statement or a while loop that affects the flow of control in a program (that is, the order in which the instructions in the program are executed)..";
        glossaryDescription.name="Control Structure";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Central Processing Unit. The CPU is the part of the program that actually performs calculations and carries out programs.";
        glossaryDescription.name="CPU";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An organized collection of data, that can be treated as a unit in a program.";
        glossaryDescription.name="Data Structure";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A situation in which several threads hang indefinitely, for example because each of them is waiting for some resource that is locked by one of the other threads.";
        glossaryDescription.name="Deadlock";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The unnamed package. A class that does not declare itself to be in a named package is considered to be in the default package.";
        glossaryDescription.name="Default package";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Considered to be obsolete, but still available for backwards compatibility. A deprecated Java class or method is still part of the Java language, but it is not advisable to use it in new code. Deprecated items might be removed in future versions of Java.";
        glossaryDescription.name="Deprecated";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A window that is dependent on another window, called its parent. Dialog boxes are usually popped up to get information from the user or to display a message to the user. ";
        glossaryDescription.name="Dialog box";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A kind of parallel processing in which several computers, connected by a network, work together to solve a problem.";
        glossaryDescription.name="Distributed Computing";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Identifier that is used in a subroutine definition to stand for the value of an actual parameter that will be passed to the subroutine when the subroutine is called. Dummy parameters are also called \"formal parameters\" (or sometimes just \"parameters,\" when the term \"argument\" is used instead of actual parameter).";
        glossaryDescription.name="Dummy Parameter";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Enumerated type. A type that is defined by listing every possible value of that type. An enum type in Java is a class, and the possible values of the type are objects.";
        glossaryDescription.name="Enum";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="In GUI programming, something that happens outside the control of the program, such as a mouse click, and that the program must respond to when it occurs.";
        glossaryDescription.name="Event";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An error or exceptional condition that is outside the normal flow of control of a program. In Java, an exception can be represented by an object of type Throwable that can be caught and handled in a try..catch statement.";
        glossaryDescription.name="Exception";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The process by which the CPU executes machine language programs. It fetches (that is, reads) an instruction from memory and carries out (that is, executes) the instruction, and it repeats this over and over in a continuous cycle.";
        glossaryDescription.name="Fetch-and-execute cycle";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A boolean value that is set to true to indicate that some condition or event is true. A single bit in a binary number can also be used as a flag.";
        glossaryDescription.name="Flag";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Another term for \"dummy parameter.\"";
        glossaryDescription.name="Formal parameter";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="One of the images that make up an animation. Also used as another name for activation record.";
        glossaryDescription.name="Frame";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A subroutine that returns a value.";
        glossaryDescription.name="Function";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The automatic process of reclaiming memory that is occupied by objects that can no longer be accessed.";
        glossaryDescription.name="Garbage Collection";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Writing code that will work with various types of data, rather than with just a single type of data. The Java Collection Framework, and classes that use similar techniques, are examples of generic programming in Java.";
        glossaryDescription.name="Generic Programming";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An instance method in a class that is used to read the value of some property of that class. Usually the property is just the value of some instance variable. By convention, a getter is named getXyz() where xyz is the name of the property.";
        glossaryDescription.name="Getter";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Another name for member variable, emphasizing the fact that a member variable in a class exists outside the methods of that class.";
        glossaryDescription.name="Global Variable";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The data and methods necessary for drawing to some particular destination. A graphics context in Java is an object belonging to the Graphics class.";
        glossaryDescription.name="Graphics Context";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Graphical User Interface. The modern way of interacting with a computer, in which the computer displays interface components such as buttons and menus on a screen and the user interacts with them -- for example by clicking on them with a mouse.";
        glossaryDescription.name="GUI";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A data structure optimized for efficient search, insertion, and deletion of objects. A hash table consists of an array of locations, and the location in which an object is stored is determined by that object's \"hash code,\" an integer that can be efficiently computed from the contents of the object.";
        glossaryDescription.name="Hash Table";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The section of the computer's memory in which objects are stored.";
        glossaryDescription.name="Heap";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A programming language, such as Java, that is convenient for human programmers but that has to be translated into machine language before it can be executed.";
        glossaryDescription.name="High Level Language";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A color system in which colors are specified by three numbers (in Java, real numbers in the range 0.0 to 1.0) giving the hue, saturation, and brightness.";
        glossaryDescription.name="HSB";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Integrated Development Environment. A programming environment with a graphical user interface that integrates tools for creating, compiling, and executing programs.";
        glossaryDescription.name="IDE";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A sequence of characters that can be used as a name in a program. Identifiers are used as names of variables, methods, and classes.";
        glossaryDescription.name="Identifier";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The position number of one item in an array.";
        glossaryDescription.name="Index";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The inside of a black box, such as the code that defines a subroutine.";
        glossaryDescription.name="Implementation";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A loop that never ends, because its continuation condition always evaluates to true.";
        glossaryDescription.name="Infinite Loop";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The fact that one class can extend another. It then inherits the data and behavior of the class that it extends.";
        glossaryDescription.name="Inheritance";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An object that belongs to that class (or a subclass of that class). An object belongs to a class in this sense when the class is used as a template for the object when the object is created by a constructor defined in that class.";
        glossaryDescription.name="Instance of a class";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A non-static method in a class and hence a method in any object that is an instance of that class.";
        glossaryDescription.name="Instance Method";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A non-static variable in a class and hence a variable in any object that is an instance of that class.";
        glossaryDescription.name="Instance variable";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="As a general term, how to use a black box such as a subroutine. Knowing the interface tells you nothing about what goes on inside the box. \"Interface\" is also a reserved word in Java; in this sense, an interface is a type that specifies one or more abstract methods. An object that implements the interface must provide definitions for those methods.";
        glossaryDescription.name="Interface";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A computer program that executes program written in some computer language by reading instructions from the program, one-by-one, and carrying each one out (by translating it into equivalent machine language instructions).";
        glossaryDescription.name="Interpreter";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Input/Output, the way a computer program communicates with the rest of the world, such as by displaying data to the user, getting information from the user, reading and writing files, and sending and receiving data over a network.";
        glossaryDescription.name="I/O";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An object associated with a collection, such a list or a set, that can be used to traverse that collection. The iterator will visit each member of the collection in turn.";
        glossaryDescription.name="Iterator";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A set of standard classed that implement generic data structures, including ArrayList and TreeSet, for example.";
        glossaryDescription.name="Java Collection Framework (JCF)";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Java Development Kit. Basic software that supports both compiling and running Java programs. A JDK includes a command-line programming environment as well as a JRE. You need a JDK if you want to compile Java source code, as well as executing pre-compiled programs.";
        glossaryDescription.name="JDK";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Java Runtime Environment. Basic software that supports running standard Java programs that have already been compiled. A JRE includes a Java Virtual Machine and all the standard Java classes.";
        glossaryDescription.name="JRE)";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A kind of combination interpreter/compiler that compiles parts of a program as it interprets them. This allows subsequent executions of the same parts of the program to be executed more quickly than they were the first time. This can result is greatly increased speed of execution. Modern JVMs use a just-in-time compiler.";
        glossaryDescription.name="Just-in-time-compiler";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Java Virtual Machine. The imaginary computer whose machine language is Java bytecode. Also used to refer to computer programs that act as interpreters for programs written in bytecode; to run Java programs on your computer, you need a JVM.";
        glossaryDescription.name="JVM)";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An object whose to function is to lay out the components in a container, that is, to set their sizes and locations. Different types of layout managers implement different policies for laying out components.";
        glossaryDescription.name="Layout Manager";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A collection of data consisting of a number of objects that are linked together by pointers which are stored in instance variables of the objects. Examples include linked lists and binary trees.";
        glossaryDescription.name="Linked Data Structure";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A linked data structure in which nodes are linked together by pointers into a linear chain.";
        glossaryDescription.name="Linked List";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="In GUI programming, an object that can be registered to be notified when events of some given type occur. The object is said to \"listen\" for the events.";
        glossaryDescription.name="Listener";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A sequence of characters that is typed in a program to represent a constant value. For example, 'A' is a literal that represents the constant char value, A, when it appears in a Java program.";
        glossaryDescription.name="Literal";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The computer's memory is made up of a sequence of locations. These locations are sequentially numbered, and the number that identifies a particular location is called the address of that location.";
        glossaryDescription.name="Location (in memory)";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A variable declared within a method, for use only inside that method. A variable declared inside a block is valid from the point where it is declared until the end of block in which the declaration occurs.";
        glossaryDescription.name="Local Variable";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A control structure that allows a sequence of instructions to be executed repeatedly. Java has three kinds of loops: for loops, while loops, and do loops";
        glossaryDescription.name="Loop";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A variable in a for loop whose value is modified as the loop is executed and is checked to determine whether or not to end the loop.";
        glossaryDescription.name="Loop Control Variable";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A programming language consisting of instructions that can be executed directed by a computer. Instructions in machine language are encoded as binary numbers. Each type of computer has its own machine language. Programs written in other languages must be translated into a computer's machine language before they can be executed by that computer.";
        glossaryDescription.name="Main Memory";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An associative array; a data structure that associates an object from some collection to each object in some set. In Java, maps are represented by the generic interface Map<T,S>";
        glossaryDescription.name="Map";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A variable defined in a class but not inside a method, as opposed to a local variable, which is defined inside some method.";
        glossaryDescription.name="Member Variable)";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Memory in a computer is used to hold programs and data.";
        glossaryDescription.name="Memory";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Another term for subroutine, used in the context of object-oriented programming. A method is a subroutine that is contained in a class or in an object.";
        glossaryDescription.name="Method";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A component of a larger system that interacts with the rest of the system in a simple, well-defined, straightforward manner.";
        glossaryDescription.name="Module";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Performing multiple tasks at once, either by switching rapidly back and forth from one task to another or by literally working on multiple tasks at the same time.";
        glossaryDescription.name="Multitasking";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Multitasking in which more than one processor is used, so that multiple tasks can literally be worked on at the same time.";
        glossaryDescription.name="Multiprocessing";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Prevents two threads from accessing the same resource at the same time. In Java, this only applies to threads that access the resource in synchronized methods or synchronized statements. Mutual exclusion can prevent race conditions but introduces the possibility of deadlock.";
        glossaryDescription.name="MultiExclusion";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Not a Number. Double.NaN is a special value of type double that represents an undefined or illegal value.";
        glossaryDescription.name="NaN";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Common term for one of the objects in a linked data structure.";
        glossaryDescription.name="Node";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A special pointer value that means \"not pointing to anything.\"";
        glossaryDescription.name="Null";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The field that studies algorithms that use approximations, such as real numbers, and the errors that can result from such approximation.";
        glossaryDescription.name="Numerical Analysis";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="";
        glossaryDescription.name="";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An entity in a computer program that can have data (variables) and behaviors (methods). An object in Java must be created using some class as a template. The class of an object determines what variables and methods it contains.";
        glossaryDescription.name="Object";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A type whose values are objects, as opposed to primitive types. Classes and interfaces are object types.";
        glossaryDescription.name="Object Type";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Object-Oriented Programming. An approach to the design and implementation of computer programs in which classes and objects are created to represent concepts and entities and their interactions.";
        glossaryDescription.name="OOP";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The basic software that is always running on a computer, without which it would not be able to function. Examples include Linux, Mac OS, and Windows Vista.";
        glossaryDescription.name="Operating System";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A symbol such as \"+\", \"<=\", or \"++\" that represents an operation that can be applied to one or more values in an expression.";
        glossaryDescription.name="Operator";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The fact that the same operator can be used with different types of data. For example, the \"+\" operator can be applied to both numbers and strings.";
        glossaryDescription.name="Overloading (of operators)";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The fact that several methods that are defined in the same class can have the same name, as long as they have different signatures.";
        glossaryDescription.name="Overloading(of method names)";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Redefining in a subclass. When a subclass provides a new definition of a method that is inherited from a superclass, the new definition is said to override the original definition.";
        glossaryDescription.name="Overriding";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="In Java, a named collection of related classes and sub-packages, such as java.awt and javax.swing.";
        glossaryDescription.name="Package";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Used to provide information to a subroutine when that subroutine is called. Values of \"actual parameters\" in the subroutine call statement are assigned to the \"dummy parameters\" in the subroutine definition before the code in the subroutine is executed.";
        glossaryDescription.name="Parameter";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Determining the syntactical structure of a string in some language. To parse a string is to determine whether the string is legal according to the grammar of the language, and if so, how it can be created using the rules of the grammar.";
        glossaryDescription.name="Parsing";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A \"picture element\" on the screen or in an image. A picture consists of rows and columns of pixels. The color of each pixel can be individually set.";
        glossaryDescription.name="Pixel";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="he fact that the meaning of a call to an instance method can depend on the actual type of the object that is used to make the call at run time. That is, if var is a variable of object type, then the method that is called by a statement such as var.action() depends on the type of the object to which var refers when the statement is executed at run time, not on the type of variable var.";
        glossaryDescription.name="Parameter";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A value that represents an address in the computer's memory, and hence can be thought of as \"pointing\" to the location that has that address. A variable in Java can never hold an object; it can only hold a pointer to the location where the object is stored. A pointer is also called a \"reference.\"";
        glossaryDescription.name="Pointer";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The precedence of operators determines the order in which they are applied, when several operators occur in an expression, in the absence of parentheses.";
        glossaryDescription.name="Precedence";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A condition that must be true at some point in the execution of a program, in order for the program to proceed correctly from that point. A precondition of a subroutine is something that must be true when the subroutine is called, in order for the subroutine to function properly. Subroutine preconditions are often restrictions on the values of the actual parameters that can be passed into the subroutine.";
        glossaryDescription.name="Precondition";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A condition that is known to be true at some point in the execution of a program, as a result of the computation that has come before that point. A postcondition of a subroutine is something that must be true after the subroutine finishes its execution. A postcondition of a function often describe the return value of the function.";
        glossaryDescription.name="PostCondition";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="One of the eight basic built-in data types in Java, double, float, long, int, short, byte, boolean, and char. A variable of primitive type holds an actual value, as opposed to a pointer to that value.";
        glossaryDescription.name="Primitive Type";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A set of instructions to be carried out by a computer, written in an appropriate programming language. Used as a verb, it means to create such a set of instructions.";
        glossaryDescription.name="Program";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A language that can be used to write programs for a computer. Programming languages range in complexity from machine language to high-level languages such as Java.";
        glossaryDescription.name="Programming Language";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A specification of what constitutes legal communication in a give context. A protocol specifies the format of legal messages, when they can be sent, what kind of reply is expected, and so on.";
        glossaryDescription.name="Pseudocode";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A data structure consisting of a list of items, where items can only be added at one end and removed at the opposite end of the list.";
        glossaryDescription.name="Queue";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Random Access Memory. This term is often used as a synonym for the main memory of a computer. Technically, however, it means memory in which all locations are equally accessible at any given time. The term also implies that data can be written to the memory as well as read from it.";
        glossaryDescription.name="RAM";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Defining something in terms of itself. In particular, a recursive subroutine is one that calls itself, either directly, or indirectly through a chain of other subroutines. Recursive algorithms work by reducing a complex problem into smaller problems which can solved either directly or by applying the same algorithm \"recursively.\"";
        glossaryDescription.name="Recursion";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A color system in which colors are specified by three numbers (in Java, integers in the range 0 to 255) giving the red, green, and blue components of the color.";
        glossaryDescription.name="RGB";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Another term for \"pointer.\"";
        glossaryDescription.name="Reference";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The type of value that is returned by that function.";
        glossaryDescription.name="Return type of function";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A sequence of characters that looks like an identifier but can't be used as an identifier because it has a special meaning in the language. For example, class, public, and if are reserved words in Java.";
        glossaryDescription.name="Reserved Word";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An image, sound, text, or other data file that is part of a program. Resource files for Java programs are stored on the same class path where the compiled class files for the program are stored.";
        glossaryDescription.name="Resource";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A program is robust if it is not only correct, but also is capable of handling errors such as a non-existent file or a failed network connection in a reasonable way.";
        glossaryDescription.name="Robust Program";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A collection of objects which contains no duplicates. In Java, sets are represented by the generic interface Set<T>";
        glossaryDescription.name="Set";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="The region in a program where the declaration of an identifier is valid.";
        glossaryDescription.name="Scope";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Meaning. The semantics rules of a language determine the meaning of strings of symbols (such as sentences or statements) in that language.";
        glossaryDescription.name="Semantics";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A special value that marks the end of a sequence of data values, to indicate the end of the data.";
        glossaryDescription.name="Sentinel Value";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An instance method in a class that is used to set the value of some property of that class. Usually the property is just the value of some instance variable. By convention, a setter is named setXyz() where xyz is the name of the property.";
        glossaryDescription.name="Setter";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An abstraction representing one end of a connection between two computers on a network. A socket represents a logical connection between computer programs, not a physical connection between computers.";
        glossaryDescription.name="Socket";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A data structure consisting of a list of items where items can only be added and removed at one end of the list, which is known as the \"top\" of the stack. Adding an item to a stack is called \"pushing,\" and removing an item is called \"popping.\" The term stack also refers to the stack of activation records that is used to implement subroutine calls.";
        glossaryDescription.name="Stack";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Text written in a high-level programming language, which must be translated into a machine language such as Java bytecode before it can be executed by a computer.";
        glossaryDescription.name="Source Code";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A class that extends another class, directly or indirectly, and therefore inherits its data and behaviors. The first class is said to be a subclass of the second.";
        glossaryDescription.name="Subclass";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A sequence of program instructions that have been grouped together and given a name. The name can then be used to \"call\" the subroutine. Subroutines are also called methods in the context of object-oriented programming.";
        glossaryDescription.name="Subroutine";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A statement in a program that calls a subroutine. When a subroutine call statement is executed, the computer executes the code that is inside the subroutine.";
        glossaryDescription.name="Subroutine Call Statement";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A special variable, automatically defined in any instance method, that refers to the object that contains the method, but considered as belonging to the superclass of the class in which the method definition occurs. super gives access to members of the superclass that are hidden by members of the same name in the subclass.";
        glossaryDescription.name="Super";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Grammar. The syntax rules of a language determine what strings of symbols are legal -- that is, grammatical -- in that language.";
        glossaryDescription.name="Super";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Protocols that are used for network communication on the Internet.";
        glossaryDescription.name="TCP/IP";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A special variable, automatically defined in any instance method, that refers to the object that contains the method.";
        glossaryDescription.name="This";
        glossaryRepo.insert(glossaryDescription);


        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="An abstraction representing a sequence of instructions to be executed one after the other. It is possible for a computer to execute several threads in parallel.";
        glossaryDescription.name="Thread";
        glossaryRepo.insert(glossaryDescription);


        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A collection of \"worker threads\" that are available to perform tasks. As tasks become available, they are assigned to threads in the pool. A thread pool is often used with a blocking queue that holds the tasks.";
        glossaryDescription.name="Thread pool";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Specifies some specific kind of data values. For example, the type int specifies integer data values that can be represented as 32-bit binary numbers. In Java, a type can be a primitive type, a class names, or an interface name. Type names are used to specify the types of variables, of dummy parameters in subroutines, and of return values of subroutines.";
        glossaryDescription.name="Type";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Forces the conversion of a value of one type into another type. For example, in (int)(6*Math.random()), the (int) is a type-cast operation that converts the double value (6*Math.random()) into an integer by discarding the fractional part of the real number.";
        glossaryDescription.name="Type Cast";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A way of encoding characters as binary numbers. The Unicode character set includes characters used in many languages, not just English. Unicode is the character set that is used internally by Java.";
        glossaryDescription.name="Unicode";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Universal Resource Locator; an address for a resource on the Internet, such as a web page.";
        glossaryDescription.name="URL";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A named memory location (or sequence of locations) that can be used to store data. A variable is created in a program, and a name is assigned to the variable, in a variable declaration statement. The name can then be used in that program to refer to the memory location, or to the data stored in that memory location, depending on context. In Java, a variable has a type, which specifies what kind of data it can hold.";
        glossaryDescription.name="Variable";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="A class such as Double or Integer that makes it possible to \"wrap\" a primitive type value in an object belonging to the wrapper class. This allows primitive type values to be used in contexts were objects are required, such as with the Java Collection Framework.";
        glossaryDescription.name="Wrapper Class";
        glossaryRepo.insert(glossaryDescription);

        glossaryRepo = new GlossaryRepo(this);
        glossaryDescription.email="Extensible Markup Language. A very common and well-supported standard syntax for creating text-based data-representation languages.";
        glossaryDescription.name="XML";
        glossaryRepo.insert(glossaryDescription);

    }

    @Override
    public void onResume(){
        super.onResume();

    }

    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView search = (SearchView) menu.findItem(R.id.search).getActionView();
            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                @Override
                public boolean onQueryTextSubmit(String s) {
                    Log.d(TAG, "onQueryTextSubmit ");
                    cursor= glossaryRepo.getStudentListByKeyword(s);
                    if (cursor==null){
                        Toast.makeText(GlossaryActivity.this,"No words found!",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(GlossaryActivity.this, cursor.getCount() + " words found!", Toast.LENGTH_LONG).show();
                    }
                   glossaryAdapter.swapCursor(cursor);

                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    Log.d(TAG, "onQueryTextChange ");
                    cursor= glossaryRepo.getStudentListByKeyword(s);
                    if (cursor!=null){
                       glossaryAdapter.swapCursor(cursor);
                    }
                    return false;
                }

            });

        }

        return true;

    }

}
