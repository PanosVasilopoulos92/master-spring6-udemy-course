package org.viators.practice_project16.eazyschool.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.viators.practice_project16.eazyschool.model.Course;
import org.viators.practice_project16.eazyschool.model.EazySchoolClass;
import org.viators.practice_project16.eazyschool.model.Person;
import org.viators.practice_project16.eazyschool.repository.CourseRepository;
import org.viators.practice_project16.eazyschool.repository.EazySchoolClassRepository;
import org.viators.practice_project16.eazyschool.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private EazySchoolClassRepository eazySchoolClassRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping("/displayClasses")
    public ModelAndView displayClasses(Model model) {
        List<EazySchoolClass> eazySchoolClasses = eazySchoolClassRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("classes.html");
        modelAndView.addObject("eazySchoolClasses", eazySchoolClasses);
        modelAndView.addObject("eazySchoolClass", new EazySchoolClass());
        return modelAndView;
    }

    @PostMapping("/addNewClass")
    public ModelAndView addNewClass(Model model, @ModelAttribute("eazySchoolClass") EazySchoolClass eazySchoolClass) {
        eazySchoolClassRepository.save(eazySchoolClass);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }

    @RequestMapping("/deleteClass")
    public ModelAndView deleteClass(Model model, @RequestParam int id) {
        Optional<EazySchoolClass> eazySchoolClass = eazySchoolClassRepository.findById(id);
        for (Person person : eazySchoolClass.get().getPersons()) {
            person.setEazySchoolClass(null);
            personRepository.save(person);
        }

        eazySchoolClassRepository.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }

    @GetMapping("/displayStudents")
    public ModelAndView displayStudents(Model model, @RequestParam int classId, HttpSession session,
                                        @RequestParam(value = "error", required = false) String error) {
        String errorMessage = null;
        ModelAndView modelAndView = new ModelAndView("students.html");
        Optional<EazySchoolClass> eazySchoolClass = eazySchoolClassRepository.findById(classId);
        modelAndView.addObject("eazySchoolClass", eazySchoolClass.get());
        modelAndView.addObject("person", new Person());
        session.setAttribute("eazySchoolClass", eazySchoolClass.get());
        if (error != null) {
            errorMessage = "Invalid Email entered!!";
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }

    @PostMapping("/addStudent")
    public ModelAndView addStudent(Model model, @ModelAttribute("person") Person person, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        EazySchoolClass eazySchoolClass = (EazySchoolClass) session.getAttribute("eazySchoolClass");
        Person personEntity = personRepository.readByEmail(person.getEmail());
        if (personEntity == null || !(personEntity.getPersonId() > 0)) {
            modelAndView.setViewName("redirect:/admin/displayStudents?classId=" + eazySchoolClass.getClassId()
                    + "&error=true");
            return modelAndView;
        }
        personEntity.setEazySchoolClass(eazySchoolClass);
        personRepository.save(personEntity);
        eazySchoolClass.getPersons().add(personEntity);
        eazySchoolClassRepository.save(eazySchoolClass);
        modelAndView.setViewName("redirect:/admin/displayStudents?classId=" + eazySchoolClass.getClassId());
        return modelAndView;
    }

    @GetMapping("/deleteStudent")
    public ModelAndView deleteStudent(Model model, @RequestParam int personId, HttpSession session) {
        EazySchoolClass eazySchoolClass = (EazySchoolClass) session.getAttribute("eazySchoolClass");
        Optional<Person> person = personRepository.findById(personId);
        person.get().setEazySchoolClass(null);
        eazySchoolClass.getPersons().remove(person.get());
        EazySchoolClass eazyClassSaved = eazySchoolClassRepository.save(eazySchoolClass);
        session.setAttribute("eazySchoolClass", eazyClassSaved);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayStudents?classId=" + eazyClassSaved.getClassId());
        return modelAndView;
    }

    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(Model model) {
        List<Course> courses = courseRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("courses_secure.html");
        modelAndView.addObject("courses", courses);
        modelAndView.addObject("course", new Course());
        return modelAndView;
    }

    @PostMapping("/addNewCourse")
    public ModelAndView addNewCourse(Model model, @ModelAttribute("course") Course course) {
        ModelAndView modelAndView = new ModelAndView();
        courseRepository.save(course);
        modelAndView.setViewName("redirect:/admin/displayCourses");
        return modelAndView;
    }

    @GetMapping("/viewStudents")
    public ModelAndView viewStudents(Model model, @RequestParam int id
            , HttpSession session, @RequestParam(value = "error", required = false) String error) {
        String errorMessage = null;
        ModelAndView modelAndView = new ModelAndView("course_students.html");
        Optional<Course> courses = courseRepository.findById(id);
        modelAndView.addObject("courses", courses.get());
        modelAndView.addObject("person", new Person());
        session.setAttribute("courses", courses.get());
        if (error != null) {
            errorMessage = "Invalid Email entered!!";
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }

    @PostMapping("/addStudentToCourse")
    public ModelAndView addStudentToCourse(Model model, @ModelAttribute("person") Person person,
                                           HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Course course = (Course) session.getAttribute("courses");
        Person personEntity = personRepository.readByEmail(person.getEmail());
        if (personEntity == null || !(personEntity.getPersonId() > 0)) {
            modelAndView.setViewName("redirect:/admin/viewStudents?id=" + course.getCourseId()
                    + "&error=true");
            return modelAndView;
        }
        personEntity.getCourses().add(course);
        course.getPersons().add(personEntity);
        personRepository.save(personEntity);
        session.setAttribute("courses", course);
        modelAndView.setViewName("redirect:/admin/viewStudents?id=" + course.getCourseId());
        return modelAndView;
    }

    @GetMapping("/deleteStudentFromCourse")
    public ModelAndView deleteStudentFromCourse(Model model, @RequestParam int personId,
                                                HttpSession session) {
        Course course = (Course) session.getAttribute("courses");
        Optional<Person> person = personRepository.findById(personId);
        person.get().getCourses().remove(course);
        course.getPersons().remove(person);
        personRepository.save(person.get());
        session.setAttribute("courses", course);
        return new ModelAndView("redirect:/admin/viewStudents?id=" + course.getCourseId());
    }

}
