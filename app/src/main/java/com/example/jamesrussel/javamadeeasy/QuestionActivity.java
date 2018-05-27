package com.example.jamesrussel.javamadeeasy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    HashMap<String, List<String>> Question_category;
    List<String> Question_list;
    ExpandableListView Exp_list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.question_title2);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ExpandableListView elv = (ExpandableListView)findViewById(R.id.exp_list);
        ArrayList<ImportantQuestion> importantQuestions =getData();
        CustomAdapter adapter= new CustomAdapter(this, importantQuestions);
        elv.setAdapter(adapter);
    }
    private  ArrayList<ImportantQuestion> getData()
    {
        ImportantQuestion q1 = new ImportantQuestion("List any five features of Java?");
        q1.answers.add("Object Oriented, Platform Independent, Robust, Interpreted, Multi-threaded");

        ImportantQuestion q2 = new ImportantQuestion("Why Java is considered dynamic?");
        q2.answers.add("It is designed to adapt to an evolving environment. Java programs can run carry extensive amount of run-time information that can be used to verify and resolve accesses to objects on run-time.");

        ImportantQuestion q3 = new ImportantQuestion("Why is Java Architechtural Neutral?");
        q3.answers.add("It's compiler generates an architecture-neutral object file format, which makes the compiled code to be executable on many processors, with the presence of Java runtime system.");

        ImportantQuestion q4 = new ImportantQuestion("Define Class?");
        q4.answers.add("A class is a blueprint from which individual objects are created. A class can contain fields and methods to describe the behavior of an object.");

        ImportantQuestion q5 = new ImportantQuestion("What kind of variables a class can consists of?");
        q5.answers.add("A class consists of local variable, instance variables and class variables.");

        ImportantQuestion q6 = new ImportantQuestion("What is the default value of the local variables?");
        q6.answers.add("The local variables are not initialized to any default value, neither primitives nor object references.");

        ImportantQuestion q7 = new ImportantQuestion("What is a constructor?");
        q7.answers.add("Constructor is just like a method that is used to initialize the state of an object. It is invoked at the time of object creation.");

        ImportantQuestion q8 = new ImportantQuestion("What is the purpose of default constructor?");
        q8.answers.add("The java compiler creates a default constructor only if there is no constructor in the class.");

        ImportantQuestion q9 = new ImportantQuestion("Does constructor return any value?");
        q9.answers.add("Yes, that is current instance. You cannot use return type yet it returns a value.");

        ImportantQuestion q10 = new ImportantQuestion("Is constructor inherited?");
        q10.answers.add("No, constructor is not inherited.");

        ImportantQuestion q11 = new ImportantQuestion("What is static variable?");
        q11.answers.add("Static variable is used to refer the common property of all objects that is not unique for each object.");

        ImportantQuestion q12 = new ImportantQuestion("What is static block?");
        q12.answers.add("It used to initialize the static data member. Is executed before main method at the time of class loading.");

        ImportantQuestion q13 = new ImportantQuestion("Can we execute a program without main() method?");
        q13.answers.add("Yes, one of the way is static block.");


        ImportantQuestion q14 = new ImportantQuestion("What if the static modifier is removed from the signature of main method?");
        q14.answers.add("Program compiles. But a runtime throws an error. 'NoSuchMethodError'");


        ImportantQuestion q15 = new ImportantQuestion("What is the default value of byte datatype in Java?");
        q15.answers.add("Default value of byte datatype is 0.");

        ImportantQuestion q16 = new ImportantQuestion("When a byte datatype is used?");
        q16.answers.add("This datatype is used to save space in large arrays, mainly in place of integers, since a byte is four times smaller than an int.");

        ImportantQuestion q17 = new ImportantQuestion("When a parseInt() method can be used?");
        q17.answers.add("This method is used to get the primitive data types of a certain type of a certain String.");


        ImportantQuestion q18 = new ImportantQuestion("What is the difference between Stringbuffer and StringBuilder class?");
        q18.answers.add("Use StringBuilder whenever possible because it is faster than StringBuffer. But, if thread safety is necessary then use StringBuffer objects.");

        ImportantQuestion q19 = new ImportantQuestion("Which package is used for pattern matching with regular expressions?");
        q19.answers.add("Java.util.regex is used for this purpose.");


        ImportantQuestion q20 = new ImportantQuestion("Which class is the superclass for every class?");
        q20.answers.add("Object class.");

        ImportantQuestion q21 = new ImportantQuestion("What is composition?");
        q21.answers.add("Holding the reference of the other class within some other class is known as composition.");


        ImportantQuestion q22 = new ImportantQuestion("Why Java does not support pointers?");
        q22.answers.add("Pointer is a variable that refers to the memory address. They are not used in java because they are unsafe and complex to understand.");

        ImportantQuestion q23 = new ImportantQuestion("What is super in Java?");
        q23.answers.add("It is a keyword that refers to the immediate parent class object.");

        ImportantQuestion q24 = new ImportantQuestion("Can you use this() and super() both in a constructor?");
        q24.answers.add("No. Because super() or this() must be the first statement.");

        ImportantQuestion q25 = new ImportantQuestion("Why method overloading is not possible by changing the return type in Java?");
        q25.answers.add("Because of ambiguity.");

        ImportantQuestion q26 = new ImportantQuestion("Can we overload main()method?");
        q26.answers.add("Yes. You can have many main() method in a class by overloading the main method.");

        ImportantQuestion q27 = new ImportantQuestion("Which are two subclasses under Exception class?");
        q27.answers.add("The Exception class has two main subclasses. IOException class and RuntimeException Class.");

        ImportantQuestion q28 = new ImportantQuestion("When throws keyword is used?");
        q28.answers.add("If a method does not handle a checked exception, the method must declare it using the throws keyword. The throws keyword appears at the end of a method.");

        ImportantQuestion q29 = new ImportantQuestion("How finally used under Exception Handling?");
        q29.answers.add("The finally keyword is used to create a block of code that allows a try block. A finally block of code always execute whether or not an exception has occured.");

        ImportantQuestion q30 = new ImportantQuestion("What is abstraction?");
        q30.answers.add("It referes to the ability to make a class abstract in OOP. It helps to reduce the complexity and also improves the maintain abiltity of the system.");

        ImportantQuestion q31 = new ImportantQuestion("What is abstract class?");
        q31.answers.add("These classes cannot be instantiated and are either partially implemented or not at all implemented. This class contains one or more abstract methods which are simply method declarations without a body.");

        ImportantQuestion q32 = new ImportantQuestion("What is an interface?");
        q32.answers.add("An interface is a collection of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface.");

        ImportantQuestion q33 = new ImportantQuestion("Define packages in Java?");
        q33.answers.add("A package can be defined as a grouping of related types (classes, interfaces, enumerations and annotations.)");

        ImportantQuestion q34 = new ImportantQuestion("What are the two ways in which Thread can be created?");
        q34.answers.add("Thread can be created by; implementing Runnable interface; extending the Thread class.");


        ImportantQuestion q35 = new ImportantQuestion("Can we overwrite static method?");
        q35.answers.add("No. We can't override static method because they are the part of class not an object.");

        ImportantQuestion q36 = new ImportantQuestion("Can you have virtual functions in Java?");
        q36.answers.add("Yes we can have virtual functions.");

        ImportantQuestion q37 = new ImportantQuestion("Can we overload main() method?");
        q37.answers.add("Yes we can overload it.");

        ImportantQuestion q38 = new ImportantQuestion("What is final variable?");
        q38.answers.add("If you make any variable as final. You cannot change the value of final variable(constant).");

        ImportantQuestion q39 = new ImportantQuestion("What is blank final variable?");
        q39.answers.add("A final variable not initialize at the time of declaration is known as blank final variable.");

        ImportantQuestion q40 = new ImportantQuestion("Can we initialize final variable?");
        q40.answers.add("Yes, only if constructor if it is non-static. If it is static blak final variable, it can be initialized only in the static block.");


        ImportantQuestion q41 = new ImportantQuestion("Explain garbage collection in Java?");
        q41.answers.add("It uses garbage collection to free the memory. By cleaning those objects that is no longer reference by any of the program.");

        ImportantQuestion q42 = new ImportantQuestion("Define Immutable Object?");
        q42.answers.add("An immutable object can't be exchanged once it is created.");


        ImportantQuestion q43 = new ImportantQuestion("Explain the usage of this() with constructors?");
        q43.answers.add("It is used with variables or methods and used to call constructor of same class.");

        ImportantQuestion q44 = new ImportantQuestion("Can you achieve Runtime Polymorphism by data Members?");
        q44.answers.add("No, you can't achieve it.");

        ImportantQuestion q45 = new ImportantQuestion("Can there by any abstract method abstract class?");
        q45.answers.add("No, if there is any abstract method in a class, that class must be abstract.");

        ImportantQuestion q46 = new ImportantQuestion("Can you use abstract and final both with a method?");
        q46.answers.add("No, because abstract method don't needs to be overriden whereas you can't override final method.");

        ImportantQuestion q47 = new ImportantQuestion("Is it possible to instantiate the abstract class?");
        q47.answers.add("No, abstract class can not be instantiated.");

        ImportantQuestion q48 = new ImportantQuestion("Can we define private and protected modifiers for variables in interfaces?");
        q48.answers.add("No, they are implicitly public.");

        ImportantQuestion q49 = new ImportantQuestion("What is the difference between object oriented programming and object based programming language?");
        q49.answers.add("Object oriented programming languages follow all the features of OOP's except Inheritance. Javascript is an example of object based programming languages.");

        ImportantQuestion q50 = new ImportantQuestion("What is function loading?");
        q50.answers.add("If a class has multiple functions by same name but different parameters. It is known as Method overloading.");



        ArrayList<ImportantQuestion> allquestion = new ArrayList<ImportantQuestion>();
        allquestion.add(q1);
        allquestion.add(q2);
        allquestion.add(q3);
        allquestion.add(q4);
        allquestion.add(q5);
        allquestion.add(q6);
        allquestion.add(q7);
        allquestion.add(q8);
        allquestion.add(q9);
        allquestion.add(q10);
        allquestion.add(q11);
        allquestion.add(q12);
        allquestion.add(q13);
        allquestion.add(q14);
        allquestion.add(q15);
        allquestion.add(q16);
        allquestion.add(q17);
        allquestion.add(q18);
        allquestion.add(q19);
        allquestion.add(q20);
        allquestion.add(q21);
        allquestion.add(q22);
        allquestion.add(q23);
        allquestion.add(q24);
        allquestion.add(q25);
        allquestion.add(q26);
        allquestion.add(q27);
        allquestion.add(q28);
        allquestion.add(q29);
        allquestion.add(q30);
        allquestion.add(q31);
        allquestion.add(q32);
        allquestion.add(q33);
        allquestion.add(q34);
        allquestion.add(q35);
        allquestion.add(q36);
        allquestion.add(q37);
        allquestion.add(q38);
        allquestion.add(q39);
        allquestion.add(q40);
        allquestion.add(q41);
        allquestion.add(q42);
        allquestion.add(q43);
        allquestion.add(q44);
        allquestion.add(q45);
        allquestion.add(q46);
        allquestion.add(q47);
        allquestion.add(q48);
        allquestion.add(q49);
        allquestion.add(q50);

        return allquestion;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return super.onOptionsItemSelected(item);

    }
}
