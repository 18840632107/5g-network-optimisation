package hr.fer.tel.hmo.util;

import hr.fer.tel.hmo.solution.Solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Class that provides utility methods for all other classes
 */
public class Util {

	// TODO use System.currentTimeMillis()
	private static final long seed = 420L;
	private static final Random RANDOM = new Random(seed);

	private Util() {
		// can't be created
	}

	/**
	 * Check if matrix dimensions are n rows by m columns.
	 * If n=-1, only columns are checked
	 *
	 * @param matrix matrix to check
	 * @param n      expected number of rows
	 * @param m      expected number of columns
	 * @return true if matrix is n x m
	 */
	public static boolean checkMatrix(List<List<Double>> matrix, int n, int m) {
		if (matrix == null) {
			return false;
		}

		if (n >= 0 && matrix.size() != n) {
			return false;
		}

		for (List<Double> row : matrix) {
			if (row.size() != m) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Check if size of given array is n
	 *
	 * @param array array to check
	 * @param n     expected size
	 * @return true if it is of expected size
	 */
	public static boolean checkArray(List<Double> array, int n) {
		return array != null && array.size() == n;
	}

	/**
	 * Return randomize integer that is bounded by given bound
	 *
	 * @param bound integer bound
	 * @return randomize integer
	 */
	public static int randomInt(int bound) {
		return RANDOM.nextInt(bound);
	}

	/**
	 * @return randomize double with uniform distribution on [0,1]
	 */
	public static double randomDouble() {
		return RANDOM.nextDouble();
	}

	/**
	 * @param lo lower bound
	 * @param hi higher bound
	 * @return randomize double with uniform distribution on [lo,hi]
	 */
	public static double randomDouble(double lo, double hi) {
		return lo + (hi - lo) * Util.randomDouble();
	}

	/**
	 * Shuffle values in an array
	 * Uses Knuth's shuffling shuffle
	 *
	 * @param arr array to shuffle
	 */
	public static void shuffle(int[] arr) {
		int n = arr.length;
		if (n <= 1) {
			return;
		}
		for (int i = n - 1; i > 0; --i) {
			swap(arr, i, randomInt(i));
		}
	}

	/**
	 * swap ints at given positions in array
	 *
	 * @param arr array
	 * @param i   position
	 * @param j   position
	 */
	public static void swap(int[] arr, int i, int j) {
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];
	}

	/**
	 * Write solution to file
	 *
	 * @param s        solution
	 * @param filename filename
	 */
	public static void toFile(Solution s, String filename) throws IOException {
		Files.write(Paths.get("./" + filename), Collections.singletonList(s.toString()));
	}

}
