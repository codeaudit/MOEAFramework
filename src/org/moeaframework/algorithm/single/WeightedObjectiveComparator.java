package org.moeaframework.algorithm.single;

import java.io.Serializable;

import org.moeaframework.core.Solution;
import org.moeaframework.core.comparator.DominanceComparator;

public class WeightedObjectiveComparator implements DominanceComparator, Serializable {
	
	private static final long serialVersionUID = 5157359855613094380L;
	
	private double[] weights;
	
	public WeightedObjectiveComparator() {
		this(1.0);
	}
	
	public WeightedObjectiveComparator(double... weights) {
		super();
		this.weights = weights;
		
		if ((this.weights == null) || (this.weights.length == 0)) {
			this.weights = new double[] { 1.0 };
		}
	}

	@Override
	public int compare(Solution solution1, Solution solution2) {
		double fitness1 = calculateFitness(solution1);
		double fitness2 = calculateFitness(solution2);
		
		return Double.compare(fitness1, fitness2);
	}
	
	protected double calculateFitness(Solution solution) {
		double fitness = 0.0;
		
		for (int i = 0; i < solution.getNumberOfObjectives(); i++) {
			fitness += weights[i >= weights.length ? weights.length-1 : i] *
					solution.getObjective(i);
		}
		
		return fitness;
	}

}