using src.Course.Domain.Model;
using Xunit;

namespace test.Course.Domain.Test.Courses
{   
    // Acceptance criteria
    // I need a system that manages online courses, so I need to create and edit these courses before enrollment opens.
    // - Create a course with name, workload, target audience and course value
    // - The options for the target audience are: Student, University Student, Employee and Entrepreneur.
    // - All fields in the Course are mandatory.

    public class CourseTest
    {
        [Fact(DisplayName = "CreatingCourse")]
        public void CreateCourse()
        {
            string name = "Info Course";
            double hours = 40;
            string target = "student";
            double price = 50;
           
            var course = new CourseModel(name, hours, target, price);
            Assert.Equal(name, course.Name);
            Assert.Equal(hours, course.Hours);
            Assert.Equal(target, course.Target);
            Assert.Equal(price, course.Price);
         
        }
    }
}