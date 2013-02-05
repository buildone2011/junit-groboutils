package br.com.alexandre;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

import org.junit.Assert;
import org.junit.Test;

public class MultThreadTest {

	public class TestThreadOne extends TestRunnable {

		@Override
		public void runTest() throws Throwable {
			System.out.println("Test Thread One");
			Thread.sleep(3000);
			Assert.assertFalse(true);			
		}
		
	}
	
	public class TestThreadTwo extends TestRunnable {
		@Override
		public void runTest() throws Throwable {
			System.out.println("Test Thread Two");
			Thread.sleep(2000);
			Assert.assertTrue(true);			
		}
		
	}
	
	@Test
	public void test() throws Throwable {
		final TestRunnable test1 = new TestThreadOne();
		final TestRunnable test2 = new TestThreadTwo();
		
		final MultiThreadedTestRunner multiThreadedTestRunner = new MultiThreadedTestRunner(new TestRunnable[]{test1, test2});
		multiThreadedTestRunner.runTestRunnables();
	}

}
