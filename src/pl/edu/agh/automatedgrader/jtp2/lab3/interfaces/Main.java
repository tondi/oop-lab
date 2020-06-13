package pl.edu.agh.automatedgrader.jtp2.lab3.interfaces;

import java.util.List;

import pl.edu.agh.automatedgrader.jtp2.lab3.impl.DefaultFork;
import pl.edu.agh.automatedgrader.jtp2.lab3.impl.DefaultPhilosopher;
import pl.edu.agh.automatedgrader.jtp2.lab3.impl.DefaultWaiter;

public interface Main
{
	//times are integer in milliseconds
	void eatingThinking(int howMany, int numberOfPhilosophers, int maxTimeForEating, int maxTimeForThinking);

	List<DefaultFork> getForks();

	List<DefaultPhilosopher> getPhilosophers();

	DefaultWaiter getDefaultWaiter();
}
