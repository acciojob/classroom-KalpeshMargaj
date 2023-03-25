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
        studentTeacherPair.put(student,teacher);
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
        List<String> students = new ArrayList<>();
        for(Map.Entry<String,String> entry:studentTeacherPair.entrySet())
        {
            if(entry.getValue().equals(teacherName))
            {
                String studentName = entry.getKey();
                Student student=studentDb.get(studentName);
                students.add(student.getName());
            }
        }
        return students;
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
        teacherDb.remove(teacherName);
        for(Map.Entry<String,String> entry : studentTeacherPair.entrySet())
        {
            if(entry.getValue().equals(teacherName))
            {
                String studentName = entry.getKey();

                studentDb.remove(studentName);
                studentTeacherPair.remove(studentName);
            }
        }
        return teacherName + " removed successfully";
    }
    public String deleteAllTeachers()
    {
        for(String teacherName: teacherDb.keySet())
        {
            teacherDb.remove(teacherName);
            for(Map.Entry<String,String> entry : studentTeacherPair.entrySet())
            {
                if(entry.getValue().equals(teacherName))
                {
                    String studentName = entry.getKey();

                    studentDb.remove(studentName);
                    studentTeacherPair.remove(studentName);
                }
            }
        }
        return "All teachers deleted successfully";
    }

}
