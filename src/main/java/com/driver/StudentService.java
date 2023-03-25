package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student)
    {
        String ans = studentRepository.addStudent(student);
        return ans;
    }
    public String addTeacher(Teacher teacher)
    {
        String ans = studentRepository.addTeacher(teacher);
        return ans;
    }
    public String pairStudentTeacher(String student,String teacher)
    {
        return  studentRepository.pairStudentTeacher(student,teacher);
    }
    public List<String> getStudentsByTeacherName(String teacherName)
    {
        return studentRepository.getStudentsByTeacherName(teacherName);
    }
    public Student getStudentByName(String studentName)
    {
        return studentRepository.getStudentByName(studentName);
    }
    public Teacher getTeacherByName(String teacherName)
    {
        return studentRepository.getTeacherByName(teacherName);
    }
    public List<String> getAllStudents()
    {
        return studentRepository.getAllStudents();
    }
    public String deleteTeacherByName(String teacherName)
    {
        return studentRepository.deleteTeacherByName(teacherName);
    }
    public String deleteAllTeachers()
    {
        return studentRepository.deleteAllTeachers();
    }
}
