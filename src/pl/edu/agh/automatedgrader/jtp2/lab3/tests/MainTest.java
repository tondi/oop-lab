package pl.edu.agh.automatedgrader.jtp2.lab3.tests;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import pl.edu.agh.automatedgrader.jtp2.lab3.impl.DefaultMain;
import pl.edu.agh.automatedgrader.jtp2.lab3.interfaces.Philosopher;

class MainTest
{
	private MainTest()
	{
		//empty
	}

	@SuppressWarnings("static-method")
	@RepeatedTest(20)
	void test()
	{
		DefaultMain main = new DefaultMain();
		int howMany = 10;
		int numberOfPhilosophers = 3;
		int maxTimeForEating = 100;
		int maxTimeForThinking = 100;
		main.eatingThinking(howMany, numberOfPhilosophers, maxTimeForEating, maxTimeForThinking);
		Assertions.assertEquals(main.getPhilosophers().size(), numberOfPhilosophers);
		Assertions.assertEquals(main.getForks().size(), numberOfPhilosophers);
		Set<Integer> leftIds = new HashSet<>();

		int i = 0;
		for (Philosopher philosopher : main.getPhilosophers())
		{
			System.out.println("philosopher: " + i + " left: " + philosopher.getLeftFork().getId());
			System.out.println(leftIds);
			System.out.println(Integer.valueOf(philosopher.getLeftFork().getId()));
			Assertions.assertTrue(leftIds.add(Integer.valueOf(philosopher.getLeftFork().getId())));
		}
	}
}
