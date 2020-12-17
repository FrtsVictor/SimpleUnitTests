namespace src.Course.Domain.Model
{
       public class CourseModel
    {
        public string Name { get; set; }
        public double Hours { get; set; }
        public string Target { get; set; }
        public double Price { get; set; }   

        public CourseModel(string name, double hours, string target, double price)
        {
            this.Name = name;
            this.Price = price;
            this.Hours = hours;
            this.Price = price;
        }

    }
}