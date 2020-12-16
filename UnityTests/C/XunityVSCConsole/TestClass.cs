using Xunit;

namespace XunityVSCConsole
{
    public class TestClass
    {


        [Fact(Skip = "Teste not ready")]
        public void Test()
        {
        }

        [Fact(DisplayName = "Test number 2")]
        [Trait("calc", "sum")] // create test groups
        public void Sum_twoNumvers_ReturnNumber()
        { }

        [Theory] //acept multiple datas and run 1x on each InlineData
        [InlineData(3)]
        [InlineData(5)]
        [InlineData(6)]

        public void MyFirstTheory(int mynumber)
        {
            Assert.True(Program.IsOdd(mynumber));
        }

        [Fact]  //test only one case and return true, without params 
        public void PassingAddTest()
        {
            Assert.Equal(4, Program.Add(2,2));
        }

        [Fact] 
        public void FailingAddTest()
        {
            Assert.NotEqual(5, Program.Add(2,2));
        }


    }
}