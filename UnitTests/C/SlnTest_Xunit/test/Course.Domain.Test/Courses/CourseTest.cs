using src.Course.Domain.Model;
using src.Course.Domain.Enums;
using Xunit;
using ExpectedObjects;
using System;
using test.Course.Domain.Test.Utils;

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

            var expectedCourse = new {
                name = "Info Course",
                hours = 40,
                target = Target.Student,
                price = 50
            };

            var course = new CourseModel(
                expectedCourse.name,
                expectedCourse.hours,
                expectedCourse.target, 
                expectedCourse.price);

        expectedCourse.ToExpectedObject().ShouldMatch(course);
        }


        [Theory]
        [InlineData("")]
        [InlineData(null)]
        public void Course_EmptyOrNull_ReturnArgumentException(string invalidName)
        {
            var expectedCourse = new {
                name = "Info Course",
                hours = (double)90,
                target = Target.Student,
                price = (double)100
            };

            Assert.Throws<ArgumentException>(()=> new CourseModel(
                invalidName, 
                expectedCourse.hours, 
                expectedCourse.target, 
                expectedCourse.price));
        }

        [Theory]
        [InlineData(0)]
        [InlineData(-25)]
        public void Course_HoursLessThan1_ReturnArgumentException(double invalidHours)
        {

            string errorMessage = "Invalid hours";

            var expectedCourse = new {
                name = "Info Course",
                hours = (double)90,
                target = Target.Student,
                price = (double)100
            };

            Assert.Throws<ArgumentException>(()=>new CourseModel(  
                                        expectedCourse.name, 
                                        invalidHours, 
                                        expectedCourse.target, 
                                        expectedCourse.price)).ValidateMessage(errorMessage);
        }


        [Theory]
        [InlineData(0)]
        [InlineData(-15)]
        public void Course_PriceLessThan1_ReturnArgumentException(double invalidPrice)
        {

            string errorMessage = "Invalid price";
            
            var expectedCourse = new {
                name = "Info Course",
                hours = (double)90,
                target = Target.Student,
                price = (double)100
            };

            var errorMessageDomain = Assert.Throws<ArgumentException>(()=>new CourseModel(  
                                        expectedCourse.name, 
                                        invalidPrice, 
                                        expectedCourse.target, 
                                        expectedCourse.hours)).Message;
            Assert.Equal(errorMessageDomain, errorMessage);
        }

    }



}