using System;
using src.Course.Domain.Enums;

namespace src.Course.Domain.Model
{
       public class CourseModel
    {
        public string Name { get; private set; }
        public double Hours { get; private set; }
        public Target Target { get; private set; }
        public double Price { get; private set; }   

        public CourseModel(string name, double hours, Target target, double price)
        {

            if(string.IsNullOrEmpty(name))
            {
                throw new ArgumentException("Invalid Params");
            }

            this.Name = name;
            this.Price = price;
            this.Hours = hours;
            this.Price = price;
            this.Target = target;
        }

    }
}