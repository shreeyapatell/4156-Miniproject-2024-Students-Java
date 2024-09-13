## Course File
* Missing Conditional checks for enrollStudent() and dropStudent methods. Incorrectly returned true regardless if the full capacity was reached or if there were students to be dropped. (lines 42, 54)
* enrolledStudentCount was originally set to 500 when it should be set to 0 when a course is created. (line 34)
* instructorName and courseLocation were switched around and returned the wrong thing. (lines 68, 77)
* Updated isCourseFull() method to use >= in `enrolledStudentCount >= enrollmentCapacity` since that correctly checks if the course is full. (line 152)

## Department File
* Found and removed the - sign in `this.numberOfMajors` since this should be a positive number (line 36)
* `this.departmentChair` was wrapped in string quotes making it return that literal string rather than the name of the department chair in the variable. (line 46)
* Found and removed the quotations around result.toString() in line 110 since that is going to return return that literal string rather than the actual stored result. (line 110)