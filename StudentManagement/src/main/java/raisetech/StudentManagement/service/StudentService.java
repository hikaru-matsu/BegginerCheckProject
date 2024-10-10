package raisetech.StudentManagement.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourse;
import raisetech.StudentManagement.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    //検索処理
    List<Student> studentList = repository.search();
    List<Student> filteredList = new ArrayList<>();
    for (Student student : studentList) {
      if(student.getAge() >= 35) {
        filteredList.add(student);
      }
    }
    return filteredList;
  }

  public List<StudentCourse> searchStudentCouseList() {
    List<StudentCourse> studentCourseList =  repository.searchStudentsCourses();
    List<StudentCourse> filteredCourseList = new ArrayList<>();
    for (StudentCourse studentCourse : studentCourseList) {
      if(studentCourse.getCourseName().equals("YouTube")) {
        filteredCourseList.add(studentCourse);
      }
    }
    System.out.println(filteredCourseList);
    return filteredCourseList;
  }
}
