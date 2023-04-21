package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.HashMap;

public class StudentService
{
    private final HashMap<String, Student> students = new HashMap<>();

    public void registerStudent( Student student )
    {
        //TODO Add new student to the students hashmap
        //1. Check if the student is already in the students hashmap by checking if the student id (key) is already in the students hashmap
        //2. If the student is not in the students hashmap, add the student to the students hashmap with the value of the student object
        //3. If the student is already in the students hashmap, print out a message saying that the student is already registered and do not add the student to the students hashmap

        if ( students.containsKey( student.getId() ) )
        {
            System.out.println( "Student is already registered" );

        }
        else
        {
            students.put( student.getId(), student ); //if the student is not in the hashmap, add the student to the hashmap
        }


    }

    public Student findStudent( String studentId )
    {
        //TODO Find the student from the Hashmap with the student id

        if ( students.containsKey( studentId ) ) //containsKey checks if the key is in the hashmap
        {
            return students.get( studentId ); //get returns the value of the key
        }
        return null; //if the student is not in the hashmap, return null

    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO check if students hashmap contains the studentsId, if have add the course to the student enrolledCourses
        //1. Check if the students hashmap contains the studentId by checking if the studentId (key) is already in the students hashmap
        //2. If the students hashmap contains the studentId, enroll the student to the course
        //3. If the students hashmap does not contain the studentId, print out a message saying that the student is not registered

        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course ); // adding the course to the student enrolledCourses hashmap
        }
        else
        {
            System.out.println( "Student is not registered" );
        }

    }

    public void showSummary()
    {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses

        for ( String key : students.keySet() ) //looping through the students hashmap for each key. keySet() returns a set of all the keys in the hashmap
        {
            System.out.println( students.get( key ) ); //printing out the student details
            System.out.println( students.get( key ).getEnrolledCourses() ); //printing out the student enrolled courses
        }

    }

    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //TODO return a HashMap of all the enrolledCourses
        //1. check if the student has enrolled to any courses in the enrolledCourses hashmap
        //2. if the student has enrolled to any courses, return the enrolledCourses hashmap
        //3. if the student has not enrolled to any courses, return null

        if ( student.getEnrolledCourses().isEmpty() ) //isEmpty() checks if the hashmap is empty
        {
            return null;
        }
        else
        {
            return student.getEnrolledCourses();
        }


    }

    public Course findEnrolledCourse( Student student, String courseId )
    {
        //TODO return the course enrolled by the student from the course Id
        //1. check if the student has enrolled to any courses in the enrolledCourses hashmap
        //2. if the student has enrolled to any courses, loop through the enrolledCourses hashmap and check if the courseId is in the hashmap
        //3. if the courseId is in the hashmap, return the course
        //4. if the courseId is not in the hashmap, return null

        if ( !student.getEnrolledCourses().isEmpty() ) //if the student has enrolled to any courses. isEmpty() checks if the hashmap is empty
        {
            for ( String key : student.getEnrolledCourses().keySet() ) //looping through the enrolledCourses hashmap for each key
            {
                if ( key.equals( courseId ) ) //checking if the courseId is in the hashmap
                {
                    return student.getEnrolledCourses().get( key ); //returning the course object
                }
            }
        }
        return null; //if the courseId is not in the hashmap, return null


    }

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}
