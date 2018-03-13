package com.rcb.service;

public class CreateTimeIntervelService {
	public static boolean intervals(int begin, int end, int interval) {
		if (end > begin) {
			for (int time = begin; time <= end; time += interval) {
				System.out.println(String.format("%02d:%02d", time / 60, time % 60));

			}
			return true;
		} else {
			return false;
		}

	}
}
