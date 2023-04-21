package com.generation.java;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.*;

public class Main
{

    public static void main( String[] args )
        throws ParseException
    {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        Scanner scanner = new Scanner( System.in );
        int option;
        do
        {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch ( option )
            {
                case 1:
                    registerStudent( studentService, scanner );
                    break;
                case 2:
                    findStudent( studentService, scanner );
                    break;
                case 3:
                    gradeStudent( studentService, scanner );
                    break;
                case 4:
                    enrollStudentToCourse( studentService, courseService, scanner );
                    break;
                case 5:
                    showStudentsSummary( studentService, scanner );
                    break;
                case 6:
                    showCoursesSummary( courseService, scanner );
                    break;
                case 7:
                    showPassedCourses( studentService, scanner );
                    break;
            }
        }
        while ( option != 8 );
    }

    private static void enrollStudentToCourse( StudentService studentService, CourseService courseService,
                                               Scanner scanner )
    {
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        }
        System.out.println( student );
        System.out.println( "Insert course ID" );
        String courseId = scanner.next();
        Course course = courseService.getCourse( courseId );
        if ( course == null )
        {
            System.out.println( "Invalid Course ID" );
            return;
        }
        System.out.println( course );
        studentService.enrollToCourse( studentId, course );
        System.out.println( "Student with ID: " + studentId + " enrolled successfully to " + courseId );

    }

    private static void showCoursesSummary( CourseService courseService, Scanner scanner )
    {
       courseService.showSummary();
    }

    private static void showStudentsSummary( StudentService studentService, Scanner scanner )
    {
        studentService.showSummary();
    }

    private static void gradeStudent( StudentService studentService, Scanner scanner )
    {
        Student student = getStudentInformation( studentService, scanner );
        System.out.println( "Enrolled course:" );

        //TODO Loop through the student enrolled courses, and use the scanner object to get the course ID to insert
        // the course grade
        //1. Get the course ID from the scanner
        //2.loop through the student enrolled courses from the studentService
        //3. If the course ID from the enrolledCourses hashMap is equal to the course ID from the scanner, then get the grade from the scanner
        //4. Use the studentService to grade the student


        String courseId = scanner.next();
        //loop through the student enrolled courses hashmap from the studentService to get the matching course ID
        // map.entrySet() returns a set view of the mappings/entries contained in this hashmap
        for (Map.Entry<String, EnrolledCourse> entry : student.getEnrolledCourses().entrySet()) {
            if (entry.getKey().equals(courseId)) {  //if the course ID from the enrolledCourses hashMap is equal to the course ID from the scanner
                System.out.println("Insert grade: ");
                double grade = scanner.nextDouble();
                //use the studentService to grade the student
                studentService.gradeStudent(student, student.getEnrolledCourses().get(courseId), grade);

            }
        }



    }

    private static Student getStudentInformation( StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Student not found" );
        }
        return student;
    }

    private static void findStudent( StudentService studentService, Scanner scanner )
    {
        Student student = getStudentInformation( studentService, scanner );
        if ( student != null )
        {
            System.out.println( "Student Found: " );
            System.out.println( student );
        }
    }

    private static void registerStudent( StudentService studentService, Scanner scanner ) throws ParseException
    {
        Student student = PrinterHelper.createStudentMenu( scanner );
        studentService.registerStudent( student );
    }

    private static void showPassedCourses(StudentService studentService, Scanner scanner )
    {
        //TODO Loop through the student enrolled courses, and show all the passed courses
        //1. Get the student ID from the scanner
        //2. Use the studentService to get the student
        //3. Loop through the student getPassedCourses hashmap entries from the studentService
        //4. prints the getPassedCourses() method from StudentService which returns a hashmap

        System.out.println("Insert student ID: ");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found");
        } else {
            System.out.println("Student found: ");
            System.out.println(student);
            System.out.println("Passed courses: ");
            //loop through every entry from the getPassedCourses() method from StudentService

            for (int i = 0; i < studentService.getPassedCourses(student).size(); i++) {
                System.out.println(studentService.getPassedCourses(student).get(i));
            }

        }


    }
}
