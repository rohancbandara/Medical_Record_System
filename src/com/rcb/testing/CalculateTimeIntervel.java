package com.rcb.testing;

public class CalculateTimeIntervel {
	public static void interval2(int begin, int end, int interval) {
		for (int time = begin; time <= end; time += interval) {
			System.out.println(String.format("%02d:%02d", time / 60, time % 60));
		}
	}

	public static void main(String args[]) {
		interval2(11 * 60, 14 * 60, 45);
	}
}
