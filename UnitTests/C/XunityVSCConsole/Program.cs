using System;

namespace XunityVSCConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            int yy = Add(4,5);

            Console.WriteLine(yy);
            Console.WriteLine(IsOdd(5));

        }


        public static int Add(int x, int y)
        {
            return x + y;
        }

        public static bool IsOdd(int value)
        {
            return value % 2 == 1;
        }

    }
}
