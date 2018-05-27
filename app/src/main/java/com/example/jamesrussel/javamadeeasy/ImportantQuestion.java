package com.example.jamesrussel.javamadeeasy;

import java.util.ArrayList;

/**
 * Created by James Russel on 8/28/2016.
 */
public class ImportantQuestion {
    public String Name;
    public String Image;
    public ArrayList<String> answers = new ArrayList<String>();

    public ImportantQuestion(String Name)
    {
        this.Name = Name;
    }

    @Override
    public String toString() {
        return Name;
    }
}
