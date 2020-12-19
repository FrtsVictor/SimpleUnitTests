using System;
using Xunit;

namespace test.Course.Domain.Test.Utils
{
    public static class AssertExtension
    {
        public static void ValidateMessage(this ArgumentException argumentException, string errorMessage)
        {
            if (argumentException.Message == errorMessage)
            {
                Assert.True(true);
            }
            else
            {
                Assert.False(true, $"Expected message {errorMessage}");
            }
        }
    }
}