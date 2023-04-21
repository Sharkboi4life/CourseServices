package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseService
{
    private final HashMap<String, Course> courses = new HashMap<>();

    public CourseService()
    {
        Module module = new Module( "INTRO-CS", "Introduction to Computer Science",
                                    "Introductory module for the generation technical programs" );

        registerCourse( new Course( "INTRO-CS-1", "Introduction to Computer Science", 9, module ) );
        registerCourse( new Course( "INTRO-CS-2", "Introduction to Algorithms", 9, module ) );
        registerCourse( new Course( "INTRO-CS-3", "Algorithm Design and Problem Solving - Introduction ", 9, module ) );
        registerCourse( new Course( "INTRO-CS-4", "Algorithm Design and Problem Solving - Advanced", 9, module ) );
        registerCourse( new Course( "INTRO-CS-5", "Terminal Fundamentals", 9, module ) );
        registerCourse( new Course( "INTRO-CS-6", "Source Control Using Git and Github", 9, module ) );
        registerCourse( new Course( "INTRO-CS-7", "Agile Software Development with SCRUM", 9, module ) );


        Module moduleWebFundamentals = new Module( "INTRO-WEB", "Web Development Fundamentals",
                                                   "Introduction to fundamentals of web development" );

        registerCourse( new Course( "INTRO-WEB-1", "Introduction to Web Applications", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-2", "Introduction to HTML", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-3", "Introduction to CSS", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-4", "Advanced HTML", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-5", "Advanced CSS", 9, moduleWebFundamentals ) );
        registerCourse( new Course( "INTRO-WEB-6", "Introduction to Bootstrap Framework", 9, moduleWebFundamentals ) );
        registerCourse(
            new Course( "INTRO-WEB-7", "Introduction to JavaScript for Web Development", 9, moduleWebFundamentals ) );

    }

    public void registerCourse( Course course )
    {
        courses.put( course.getCode(), course ); // key, value
    }

    public Course getCourse( String code )
    {
        if ( courses.containsKey( code ) ) //containsKey checks if the key is in the hashmap
        {
            return courses.get( code ); //get returns the value of the key
        }
        return null;
    }

    public void showSummary()
    {
        System.out.println( "Available Courses:" );
        //for each key in the hashmap, print out the value of the courses hashmap
        for ( String key : courses.keySet() )
            // returns a set of all the keys in the hashmap
        {
            Course course = courses.get( key );
            System.out.println( course );
        }
    }
}
