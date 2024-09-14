package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains all unit tests for the Department class.
 */
public class DepartmentUnitTests {
  public static Department computerScience;
  public static HashMap<String, Course> allCourses;

  /** Testing data for department. */
  @BeforeEach
  public void setupDepartmentForTesting() {
    allCourses = new HashMap<>();
    Course uiDesign = new Course("Lydia Chilton", "417 IAB", "2:40-3:55", 210);
    uiDesign.setEnrolledStudentCount(205);
    Course python = new Course("Daniel Bauer", "CSC 451", "10:10-11:25", 300);
    python.setEnrolledStudentCount(225);
    Course ai = new Course("Ansaf Salleb-aouissi", "URIS 331", "1:10-2:25", 300);
    ai.setEnrolledStudentCount(295);

    allCourses.put("4170", uiDesign);
    allCourses.put("1006", python);
    allCourses.put("4701", ai);

    computerScience = new Department("COMS", allCourses, "Josh Alman", 1200);
  }

  @Test
  public void testGetNumberOfMajors() {
    assertEquals(1200, computerScience.getNumberOfMajors());
  }

  @Test
  public void testGetDepartmentChair() {
    assertEquals("Josh Alman", computerScience.getDepartmentChair());
  }

  @Test
  public void testGetCourseSelection() {
    assertEquals(3, computerScience.getCourseSelection().size());
    assertEquals(true, computerScience.getCourseSelection().containsKey("4170"));
  }

  @Test
  public void testAddPersonToMajor() {
    computerScience.addPersonToMajor();
    assertEquals(1201, computerScience.getNumberOfMajors());
  }

  @Test
  public void testDropPersonFromMajor() {
    computerScience.dropPersonFromMajor();
    assertEquals(1199, computerScience.getNumberOfMajors());
  }

  @Test
  public void testAddCourse() {
    Course dataStructures = new Course("Paul Blaer", "432 Pupin", "2:40-3:55", 200);
    computerScience.addCourse("3134", dataStructures);
    assertEquals(true, computerScience.getCourseSelection().containsKey("3134"));
  }

  @Test
  public void testCreateCourse() {
    computerScience.createCourse("3157", "Brian Borowski", "501 Schermerhorn", "4:10-5:25", 200);
    assertEquals(true, computerScience.getCourseSelection().containsKey("3157"));
  }

}
