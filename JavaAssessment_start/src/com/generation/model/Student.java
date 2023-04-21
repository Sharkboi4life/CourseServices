package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student extends Person
{
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();


    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public boolean enrollToCourse( Course course )
    {
        //TODO Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap
        //1. Check if the student has already enrolled to the course by checking if the course code (key) is already in the enrolledCourses hashmap (return false)
        //2. If the student has not enrolled to the course, add the course to the enrolledCourses hashmap with the value of a new EnrolledCourse object (return true)


        if ( enrolledCourses.containsKey( course.getCode() ) ) //containsKey checks if the key is in the hashmap
        {
            return false;
        }
        else
        {
            enrolledCourses.put( course.getCode(), new EnrolledCourse( course ) ); //put adds a new key-value pair to the EnrolledCourse hashmap
            return true;
        }
    }

    public HashMap<String, EnrolledCourse> getEnrolledCourses()
    {
        //TODO return a Hashmap of all the enrolledCourses
        //1. check if the student has enrolled to any courses in the enrolledCourses hashmap
        //2. if the student has enrolled to any courses, return the enrolledCourses hashmap
        //3. if the student has not enrolled to any courses, return null

        if ( enrolledCourses.isEmpty() ) //isEmpty checks if the hashmap is empty
        {
            System.out.println("Student has not enrolled to any courses");
            return null;
        }
        else
        {
            return enrolledCourses;
        }

    }

    public void gradeCourse( String courseCode, double grade )
    {
        //TODO set the grade for the enrolled Course
        //1. check if the student has enrolled to any courses in the enrolledCourses hashmap
        //2. if the student has enrolled to any courses, set the grade for the enrolled course
        //3. if the student has not enrolled to any courses, print out a message saying that the student has not enrolled to any courses

        if ( enrolledCourses.containsKey( courseCode ) )
        {
            enrolledCourses.get( courseCode ).setGrade( grade ); //get returns the value of the key which is the EnrolledCourse object
        }
        else
        {
            System.out.println("Student has not enrolled to any courses");
        }


    }

    public Course findCourseById( String courseId )
    {
        //TODO return a Course from the course Id
        //1. check if the student has enrolled to any courses in the enrolledCourses hashmap
        //2. if the student has enrolled to any courses, return the course(value) from the enrolledCourses hashmap
        //3. if the student has not enrolled to any courses, return null

        if ( enrolledCourses.containsKey( courseId ) )
        {
            return enrolledCourses.get( courseId ); //get returns the value of the key which is the Course object
        }
        else
        {
            return null;
        }

    }

    public HashMap<String, EnrolledCourse> findPassedCourses()
    {
        //TODO Check the enrolled courses grade and compare to the passing grade
        //1. check if the student has enrolled to any courses in the enrolledCourses hashmap
        //2. if the student has enrolled to any courses, check the enrolled courses grade and compare to the passing grade
        //3. if the student has not enrolled to any courses, return null
        //4. if student passed the course, add the course to a new hashmap and return the hashmap
        //5. if student did not pass the course, do not add the course to the hashmap


        HashMap<String, EnrolledCourse> passedCourses = new HashMap<>();

        if ( enrolledCourses.isEmpty() ) //isEmpty checks if the hashmap is empty
        {
            System.out.println("Student has not enrolled to any courses");
            return null;
        }
        else
        {
            // for each course in the enrolledCourses hashmap, check if the grade is greater than or equal to the PASS_MIN_GRADE(3.0)
            for ( String courseCode : enrolledCourses.keySet() ) //keySet returns all the keys in the hashmap
            {
                if ( enrolledCourses.get( courseCode ).getGrade() >= PASS_MIN_GRADE ) //get returns the value of the key which is the EnrolledCourse object. getGrade returns the grade of the EnrolledCourse object. if the grade is greater than or equal to the PASS_MIN_GRADE(3.0), add the course to the passedCourses hashmap
                {
                    passedCourses.put( courseCode, enrolledCourses.get( courseCode ) ); //put adds a new key-value pair to the passedCourses hashmap
                }
            }
            return passedCourses;
        }


    }

    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
