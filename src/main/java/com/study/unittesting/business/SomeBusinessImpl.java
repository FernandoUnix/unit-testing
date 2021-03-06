package com.study.unittesting.business;

import java.util.Arrays;
import com.study.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

	private SomeDataService someDataService;

	public SomeDataService getSomeDataService() {
		return someDataService;
	}

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {

		int sum = Arrays.stream(data).reduce(Integer::sum).orElse(0);
		return sum;

//		int sum = 0;
//		for (int value : data) {
//			sum += value;
//		}
//
//		return sum;
	}

	public int calculateSumUsingDataService() {

		int[] data = someDataService.retrieveAllData();
		int sum = 0;

		for (int value : data) {
			sum += value;
		}

		return sum;
	}
}