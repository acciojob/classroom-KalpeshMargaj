package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentDb = new HashMap<>();
    HashMap<String,Teacher> teacherDb = new HashMap<>();
    HashMap<String,List<String>> teacherStudentPair = new HashMap<>();

    HashMap<String,String> studentTeacherPair = new HashMap<>();
        public String addStudent(Student student)
        {
            String key = student.getName();
            studentDb.put(key,student);
            return "New student added successfully";
        }
    public String addTeacher(Teacher teacher)
    {
        String key = teacher.getName();
        teacherDb.put(key,teacher);
        return "New teacher added successfully";
    }
    public String pairStudentTeacher(String student,String teacher)
    {
        List<String> str=teacherStudentPair.get(teacher);
        if(str==null)
            str=new ArrayList<>();
        str.add(student);
        teacherStudentPair.put(teacher,str);
        return "New student-teacher pair added successfully";
    }

    public Student getStudentByName(String studentName)
    {
        Student student = studentDb.get(studentName);
        return student;
    }
    public Teacher getTeacherByName(String teacherName)
    {
        Teacher teacher = teacherDb.get(teacherName);
        return teacher;
    }
    public List<String> getStudentsByTeacherName(String teacherName)
    {
        List<String> str = teacherStudentPair.get(teacherName);
        return str;
    }

    public List<String> getAllStudents()
    {
        List<String> students = new ArrayList<>();
        for(String studentName:studentDb.keySet())
        {
            students.add(studentName);
        }
        return students;
    }
    public String deleteTeacherByName(String teacherName)
    {
        for(String str:teacherStudentPair.get(teacherName))
        {
            studentDb.remove(str);
        }

        teacherDb.remove(teacherName);
        teacherStudentPair.remove(teacherName);
        return teacherName + " removed successfully";
    }
    public String deleteAllTeachers()
    {
        for(String teacherName: teacherDb.keySet())
        {
            for(String str:teacherStudentPair.get(teacherName))
            {
                studentDb.remove(str);
            }

            teacherDb.remove(teacherName);
            teacherStudentPair.remove(teacherName);
        }
        return "All teachers deleted successfully";
    }

}
