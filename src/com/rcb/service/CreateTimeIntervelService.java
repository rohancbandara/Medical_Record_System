package com.rcb.service;

public class CreateTimeIntervelService {
	public static void intervals(int begin, int end, int interval) {
		for (int time = begin; time <= end; time += interval) {
			System.out.println(String.format("%02d:%02d", time / 60, time % 60));
		}
	}
}
