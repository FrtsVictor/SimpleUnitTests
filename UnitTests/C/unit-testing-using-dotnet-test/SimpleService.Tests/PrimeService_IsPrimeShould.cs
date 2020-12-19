using System;
using Xunit;
using SimpleService;

namespace SimpleService.Tests
{
    public class PrimeService_IsPrimeShould
    {
        [Fact]
        public void IsPrime_InputIs1_ReturnFalse()
        {
            var primeService = new Services();
            bool result = primeService.IsPrime(1);

            Assert.False(result, "1 should not be prime");
        }


        [Theory]
        [InlineData(-1)]
        [InlineData(0)]
        [InlineData(1)]
        public void IsPrime_ValuesLessThan2_ReturnFalse(int value)
        {
            var _primeService = new Services();
            var result = _primeService.IsPrime(value);

            Assert.False(result, $"{value} should not be prime");
        }
    }
}
