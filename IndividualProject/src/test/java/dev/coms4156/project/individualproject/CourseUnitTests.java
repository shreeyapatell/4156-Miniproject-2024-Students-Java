package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * This class contains all unit tests for the Course class.
 */
@SpringBootTest
@ContextConfiguration
public class CourseUnitTests {
  public static Course uiTestCourse;

  @BeforeEach
  public void setupCourseForTesting() {
    uiTestCourse = new Course("Lydia Chilton", "417 IAB", "2:40-3:55", 210);
    uiTestCourse.setEnrolledStudentCount(209);
  }

  @Test
  public void testEnrolledStudentCount() {
    assertEquals(209, uiTestCourse.getEnrolledStudentCount());
  }

  @Test
  public void testToString() {
    String expectedResult = "\nInstructor: Lydia Chilton; Location: 417 IAB; Time: 2:40-3:55";
    assertEquals(expectedResult, uiTestCourse.toString());
  }

  @Test
  public void testGetCourseLocation() {
    assertEquals("417 IAB", uiTestCourse.getCourseLocation());
  }

  @Test
  public void testGetInstructorName() {
    assertEquals("Lydia Chilton", uiTestCourse.getInstructorName());
  }

  @Test
  public void testGetTimeSlot() {
    assertEquals("2:40-3:55", uiTestCourse.getCourseTimeSlot());
  }

  @Test
  public void testEnrollStudentFail() {
    uiTestCourse.setEnrolledStudentCount(210);
    assertEquals(false, uiTestCourse.enrollStudent());
  }

  @Test
  public void testIsCourseFull() {
    uiTestCourse.setEnrolledStudentCount(210);
    assertEquals(true, uiTestCourse.isCourseFull());
  }

  @Test
  public void testDropStudentSuccess() {
    uiTestCourse.setEnrolledStudentCount(210);
    assertEquals(true, uiTestCourse.dropStudent());
  }

  @Test
  public void testDropStudentFail() {
    uiTestCourse.setEnrolledStudentCount(0);
    assertEquals(false, uiTestCourse.dropStudent());
  }

  @Test
  public void testReassignInstructor() {
    uiTestCourse.reassignInstructor("Brian Smith");
    assertEquals("Brian Smith", uiTestCourse.getInstructorName());
  }

  @Test
  public void testEnrollStudentWhenFull() {
    uiTestCourse.setEnrolledStudentCount(210);
    assertEquals(false, uiTestCourse.enrollStudent());
  }

  @Test
  public void testDropStudentWhenNoneEnrolled() {
    uiTestCourse.setEnrolledStudentCount(0);
    assertEquals(false, uiTestCourse.dropStudent());
  }

}
