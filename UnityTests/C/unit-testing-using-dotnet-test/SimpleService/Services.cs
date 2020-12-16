using System;

namespace SimpleService
{
    public class Services
    {
         public bool IsPrime(int candidate)
    {
        if (candidate == 1)
        {
            return false;
        }
        throw new NotImplementedException("Not fully implemented.");
    }
    }
}