package com.example.jamesrussel.javamadeeasy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by James Russel on 8/28/2016.
 */
public class CustomAdapter extends BaseExpandableListAdapter{


    private Context c;
    private ArrayList<ImportantQuestion> importantQuestion;
    private LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<ImportantQuestion> importantQuestion)
    {
        this.c = c;
        this.importantQuestion = importantQuestion;
        inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getGroupCount() {
        return importantQuestion.size();
    }

    @Override
    public int getChildrenCount(int groupPos) {
        return importantQuestion.get(groupPos).answers.size();
    }

    @Override
    public Object getGroup(int groupPos) {
        return importantQuestion.get(groupPos);
    }

    @Override
    public Object getChild(int groupPos, int childPos) {
        return importantQuestion.get(groupPos).answers.get(childPos);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.parent_layout, null);
        }
        ImportantQuestion q = (ImportantQuestion) getGroup(groupPosition);

        TextView nameTv = (TextView) convertView.findViewById(R.id.parent_text);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView2);

        String name = q.Name;
        nameTv.setText(name);

        if (name == "List any five features of Java?") {
            img.setImageResource(R.drawable.ic_1);
        } else if (name == "Why Java is considered dynamic?") {
            img.setImageResource(R.drawable.ic_2);
        } else if (name == "Why is Java Architechtural Neutral?") {
            img.setImageResource(R.drawable.ic_3);
        } else if (name == "Define Class?") {
            img.setImageResource(R.drawable.ic_4);
        } else if (name == "What kind of variables a class can consists of?") {
            img.setImageResource(R.drawable.ic_5);
        } else if (name == "What is the default value of the local variables?") {
            img.setImageResource(R.drawable.ic_6);
        } else if (name == "What is a constructor?") {
            img.setImageResource(R.drawable.ic_7);
        } else if (name == "What is the purpose of default constructor?") {
            img.setImageResource(R.drawable.ic_8);
        } else if (name == "Does constructor return any value?") {
            img.setImageResource(R.drawable.ic_9);
        }else if (name == "Is constructor inherited?"){
            img.setImageResource(R.drawable.ic_10);
        }else if (name == "What is static variable?"){
            img.setImageResource(R.drawable.ic_11);
        }else if (name == "What is static block?"){
            img.setImageResource(R.drawable.ic_12);
        }else if (name == "Can we execute a program without main() method?"){
            img.setImageResource(R.drawable.ic_13);
        }else if (name == "What if the static modifier is removed from the signature of main method?"){
            img.setImageResource(R.drawable.ic_14);
        }else if (name == "What is the default value of byte datatype in Java?"){
            img.setImageResource(R.drawable.ic_15);
        }else if (name == "When a byte datatype is used?"){
            img.setImageResource(R.drawable.ic_16);
        }else if (name == "When a parseInt() method can be used?"){
            img.setImageResource(R.drawable.ic_17);
        }else if (name == "What is the difference between Stringbuffer and StringBuilder class?"){
            img.setImageResource(R.drawable.ic_18);
        }else if (name == "Which package is used for pattern matching with regular expressions?"){
            img.setImageResource(R.drawable.ic_19);
        }else if (name == "Which class is the superclass for every class?"){
            img.setImageResource(R.drawable.ic_20);
        }else if (name == "What is composition?"){
            img.setImageResource(R.drawable.ic_21);
        }else if (name == "Why Java does not support pointers?"){
            img.setImageResource(R.drawable.ic_22);
        }else if (name == "What is super in Java?"){
            img.setImageResource(R.drawable.ic_23);
        }else if (name == "Can you use this() and super() both in a constructor?"){
            img.setImageResource(R.drawable.ic_24);
        }else if (name == "Why method overloading is not possible by changing the return type in Java?"){
            img.setImageResource(R.drawable.ic_25);
        }else if (name == "Can we overload main()method?"){
            img.setImageResource(R.drawable.ic_26);
        }else if (name == "Which are two subclasses under Exception class?"){
            img.setImageResource(R.drawable.ic_27);
        }else if (name == "When throws keyword is used?"){
            img.setImageResource(R.drawable.ic_28);
        }else if (name == "How finally used under Exception Handling?"){
            img.setImageResource(R.drawable.ic_29);
        }else if (name == "What is abstraction?"){
            img.setImageResource(R.drawable.ic_30);
        }else if (name == "What is abstract class?"){
            img.setImageResource(R.drawable.ic_31);
        }else if (name == "What is an interface?"){
            img.setImageResource(R.drawable.ic_32);
        }else if (name == "Define packages in Java?"){
            img.setImageResource(R.drawable.ic_33);
        }else if (name == "What are the two ways in which Thread can be created?"){
            img.setImageResource(R.drawable.ic_34);
        }else if (name == "Can we overwrite static method?"){
            img.setImageResource(R.drawable.ic_35);
        }else if (name == "Can you have virtual functions in Java?"){
            img.setImageResource(R.drawable.ic_36);
        }else if (name == "Can we overload main() method?"){
            img.setImageResource(R.drawable.ic_37);
        }else if (name == "What is final variable?"){
            img.setImageResource(R.drawable.ic_38);
        }else if (name == "What is blank final variable?"){
            img.setImageResource(R.drawable.ic_39);
        }else if (name == "Can we initialize final variable?"){
            img.setImageResource(R.drawable.ic_40);
        }else if (name == "Explain garbage collection in Java?"){
            img.setImageResource(R.drawable.ic_41);
        }else if (name == "Define Immutable Object?"){
            img.setImageResource(R.drawable.ic_42);
        }else if (name == "Explain the usage of this() with constructors?"){
            img.setImageResource(R.drawable.ic_43);
        }else if (name == "Can you achieve Runtime Polymorphism by data Members?"){
            img.setImageResource(R.drawable.ic_44);
        }else if (name == "Can there by any abstract method abstract class?"){
            img.setImageResource(R.drawable.ic_45);
        }else if (name == "Can you use abstract and final both with a method?"){
            img.setImageResource(R.drawable.ic_46);
        }else if (name == "Is it possible to instantiate the abstract class?"){
            img.setImageResource(R.drawable.ic_47);
        }else if (name == "Can we define private and protected modifiers for variables in interfaces?"){
            img.setImageResource(R.drawable.ic_48);
        }else if (name == "What is the difference between object oriented programming and object based programming language?"){
            img.setImageResource(R.drawable.ic_49);
        }else if (name == "What is function loading?"){
            img.setImageResource(R.drawable.ic_50);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPos, int childPos, boolean isLastChild, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            convertView=inflater.inflate(R.layout.child_layout, null);
        }

        String answers= (String) getChild(groupPos, childPos);

        TextView nameTv = (TextView)convertView.findViewById(R.id.child_text);
        ImageView img = (ImageView)convertView.findViewById(R.id.imageView1);
        nameTv.setText(answers);

        String questions = (String) getGroup(groupPos).toString();

        if (questions=="List any five features of Java?")
        {
            if (answers == "Object Oriented, Platform Independent, Robust, Interpreted, Multi-threaded")
            {
                img.setImageResource(R.drawable.ic_arrow1);
            }
        }else  if (questions == "Why Java is considered dynamic?")
        {
            if(answers == "It is designed to adapt to an evolving environment. Java programs can run carry extensive amount of run-time information that can be used to verify and resolve accesses to objects on run-time.")
            {
                img.setImageResource(R.drawable.ic_arrow2);
            }
        }else if (questions=="Why is Java Architechtural Neutral?")
        {
            if (answers=="It's compiler generates an architecture-neutral object file format, which makes the compiled code to be executable on many processors, with the presence of Java runtime system.")
            {
                img.setImageResource(R.drawable.ic_arrow3);
            }
        }else if (questions=="Define Class?")
        {
            if (answers=="A class is a blueprint from which individual objects are created. A class can contain fields and methods to describe the behavior of an object.")
            {
                img.setImageResource(R.drawable.ic_arrow4);
            }
        }else if (questions=="What kind of variables a class can consists of?")
        {
            if (answers=="A class consists of local variable, instance variables and class variables.")
            {
                img.setImageResource(R.drawable.ic_arrow5);
            }
        }else if (questions=="What is the default value of the local variables?")
        {
            if (answers=="The local variables are not initialized to any default value, neither primitives nor object references.")
            {
                img.setImageResource(R.drawable.ic_arrow6);
            }
        }else if (questions =="What is a constructor?")
        {
            if (answers=="Constructor is just like a method that is used to initialize the state of an object. It is invoked at the time of object creation.")
            {
                img.setImageResource(R.drawable.ic_arrow7);
            }
        }else if (questions=="What is the purpose of default constructor?")
        {
            if (answers=="The java compiler creates a default constructor only if there is no constructor in the class.")
            {
                img.setImageResource(R.drawable.ic_arrow8);
            }
        }else if (questions=="Does constructor return any value?")
        {
            if (answers=="Yes, that is current instance. You cannot use return type yet it returns a value.")
            {
                img.setImageResource(R.drawable.ic_arrow9);
            }
        }else if (questions =="Is constructor inherited?")
        {
            if (answers=="No, constructor is not inherited.")
            {
                img.setImageResource(R.drawable.ic_arrow10);
            }
        }else if (questions =="What is static variable?")
        {
            if (answers=="Static variable is used to refer the common property of all objects that is not unique for each object.")
            {
                img.setImageResource(R.drawable.ic_arrow11);
            }
        }else if (questions =="What is static block?")
        {
            if (answers=="It used to initialize the static data member. Is executed before main method at the time of class loading.")
            {
                img.setImageResource(R.drawable.ic_arrow12);
            }
        }else if (questions =="Can we execute a program without main() method?")
        {
            if (answers=="Yes, one of the way is static block.")
            {
                img.setImageResource(R.drawable.ic_arrow13);
            }
        }else if (questions =="What if the static modifier is removed from the signature of main method?")
        {
            if (answers=="Program compiles. But a runtime throws an error. 'NoSuchMethodError'")
            {
                img.setImageResource(R.drawable.ic_arrow14);
            }
        }else if (questions =="What is the default value of byte datatype in Java?")
        {
            if (answers=="Default value of byte datatype is 0.")
            {
                img.setImageResource(R.drawable.ic_arrow15);
            }
        }else if (questions =="When a byte datatype is used?")
        {
            if (answers=="This datatype is used to save space in large arrays, mainly in place of integers, since a byte is four times smaller than an int.")
            {
                img.setImageResource(R.drawable.ic_arrow16);
            }
        }else if (questions =="When a parseInt() method can be used?")
        {
            if (answers=="This method is used to get the primitive data types of a certain type of a certain String.")
            {
                img.setImageResource(R.drawable.ic_arrow17);
            }
        }else if (questions =="What is the difference between Stringbuffer and StringBuilder class?")
        {
            if (answers=="Use StringBuilder whenever possible because it is faster than StringBuffer. But, if thread safety is necessary then use StringBuffer objects.")
            {
                img.setImageResource(R.drawable.ic_arrow18);
            }
        }else if (questions =="Which package is used for pattern matching with regular expressions?")
        {
            if (answers=="Java.util.regex is used for this purpose.")
            {
                img.setImageResource(R.drawable.ic_arrow19);
            }
        }else if (questions =="Which class is the superclass for every class?")
        {
            if (answers=="Object class.")
            {
                img.setImageResource(R.drawable.ic_arrow20);
            }
        }else if (questions =="What is composition?")
        {
            if (answers=="Holding the reference of the other class within some other class is known as composition.")
            {
                img.setImageResource(R.drawable.ic_arrow21);
            }
        }
        else if (questions =="Why Java does not support pointers?")
        {
            if (answers=="Pointer is a variable that refers to the memory address. They are not used in java because they are unsafe and complex to understand.")
            {
                img.setImageResource(R.drawable.ic_arrow22);
            }
        } else if (questions =="What is super in Java?")
        {
            if (answers=="It is a keyword that refers to the immediate parent class object.")
            {
                img.setImageResource(R.drawable.ic_arrow23);
            }
        }else if (questions =="Can you use this() and super() both in a constructor?")
        {
            if (answers=="No. Because super() or this() must be the first statement.")
            {
                img.setImageResource(R.drawable.ic_arrow24);
            }
        }else if (questions =="Why method overloading is not possible by changing the return type in Java?")
        {
            if (answers=="Because of ambiguity.")
            {
                img.setImageResource(R.drawable.ic_arrow25);
            }
        }else if (questions =="Can we overload main()method?")
        {
            if (answers=="Yes. You can have many main() method in a class by overloading the main method.")
            {
                img.setImageResource(R.drawable.ic_arrow26);
            }
        }else if (questions =="Which are two subclasses under Exception class?")
        {
            if (answers=="The Exception class has two main subclasses. IOException class and RuntimeException Class.")
            {
                img.setImageResource(R.drawable.ic_arrow27);
            }
        }else if (questions =="When throws keyword is used?")
        {
            if (answers=="If a method does not handle a checked exception, the method must declare it using the throws keyword. The throws keyword appears at the end of a method.")
            {
                img.setImageResource(R.drawable.ic_arrow28);
            }
        }else if (questions =="How finally used under Exception Handling?")
        {
            if (answers=="The finally keyword is used to create a block of code that allows a try block. A finally block of code always execute whether or not an exception has occured.")
            {
                img.setImageResource(R.drawable.ic_arrow29);
            }
        }else if (questions =="What is abstraction?")
        {
            if (answers=="It referes to the ability to make a class abstract in OOP. It helps to reduce the complexity and also improves the maintain abiltity of the system.")
            {
                img.setImageResource(R.drawable.ic_arrow30);
            }
        }else if (questions =="What is abstract class?")
        {
            if (answers=="These classes cannot be instantiated and are either partially implemented or not at all implemented. This class contains one or more abstract methods which are simply method declarations without a body.")
            {
                img.setImageResource(R.drawable.ic_arrow31);
            }
        }else if (questions =="What is an interface?")
        {
            if (answers=="An interface is a collection of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface.")
            {
                img.setImageResource(R.drawable.ic_arrow32);
            }
        }else if (questions =="Define packages in Java?")
        {
            if (answers=="A package can be defined as a grouping of related types (classes, interfaces, enumerations and annotations.)")
            {
                img.setImageResource(R.drawable.ic_arrow33);
            }
        }else if (questions =="What are the two ways in which Thread can be created?")
        {
            if (answers=="Thread can be created by; implementing Runnable interface; extending the Thread class.")
            {
                img.setImageResource(R.drawable.ic_arrow34);
            }
        }else if (questions =="Can we overwrite static method?")
        {
            if (answers=="No. We can't override static method because they are the part of class not an object.")
            {
                img.setImageResource(R.drawable.ic_arrow35);
            }
        }else if (questions =="Can you have virtual functions in Java?")
        {
            if (answers=="Yes we can have virtual functions.")
            {
                img.setImageResource(R.drawable.ic_arrow36);
            }
        }else if (questions =="Can we overload main() method?")
        {
            if (answers=="Yes we can overload it.")
            {
                img.setImageResource(R.drawable.ic_arrow37);
            }
        }else if (questions =="What is final variable?")
        {
            if (answers=="If you make any variable as final. You cannot change the value of final variable(constant).")
            {
                img.setImageResource(R.drawable.ic_arrow38);
            }
        }else if (questions =="What is blank final variable?")
        {
            if (answers=="A final variable not initialize at the time of declaration is known as blank final variable.")
            {
                img.setImageResource(R.drawable.ic_arrow39);
            }
        }else if (questions =="Can we initialize final variable?")
        {
            if (answers=="Yes, only if constructor if it is non-static. If it is static blak final variable, it can be initialized only in the static block.")
            {
                img.setImageResource(R.drawable.ic_arrow40);
            }
        }else if (questions =="Explain garbage collection in Java?")
        {
            if (answers=="It uses garbage collection to free the memory. By cleaning those objects that is no longer reference by any of the program.")
            {
                img.setImageResource(R.drawable.ic_arrow41);
            }
        }else if (questions =="Define Immutable Object?")
        {
            if (answers=="An immutable object can't be exchanged once it is created.")
            {
                img.setImageResource(R.drawable.ic_arrow42);
            }
        }else if (questions =="Explain the usage of this() with constructors?")
        {
            if (answers=="It is used with variables or methods and used to call constructor of same class.")
            {
                img.setImageResource(R.drawable.ic_arrow43);
            }
        }else if (questions =="Can you achieve Runtime Polymorphism by data Members?")
        {
            if (answers=="No, you can't achieve it.")
            {
                img.setImageResource(R.drawable.ic_arrow44);
            }
        }else if (questions =="Can there by any abstract method abstract class?")
        {
            if (answers=="No, if there is any abstract method in a class, that class must be abstract.")
            {
                img.setImageResource(R.drawable.ic_arrow45);
            }
        }else if (questions =="Can you use abstract and final both with a method?")
        {
            if (answers=="No, because abstract method don't needs to be overriden whereas you can't override final method.")
            {
                img.setImageResource(R.drawable.ic_arrow46);
            }
        }else if (questions =="Is it possible to instantiate the abstract class?")
        {
            if (answers=="No, abstract class can not be instantiated.")
            {
                img.setImageResource(R.drawable.ic_arrow47);
            }
        }else if (questions =="Can we define private and protected modifiers for variables in interfaces?")
        {
            if (answers=="No, they are implicitly public.")
            {
                img.setImageResource(R.drawable.ic_arrow48);
            }
        }else if (questions =="What is the difference between object oriented programming and object based programming language?")
        {
            if (answers=="Object oriented programming languages follow all the features of OOP's except Inheritance. Javascript is an example of object based programming languages.")
            {
                img.setImageResource(R.drawable.ic_arrow49);
            }
        }else if (questions =="What is function loading?")
        {
            if (answers=="If a class has multiple functions by same name but different parameters. It is known as Method overloading.")
            {
                img.setImageResource(R.drawable.ic_arrow50);
            }
        }






        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
