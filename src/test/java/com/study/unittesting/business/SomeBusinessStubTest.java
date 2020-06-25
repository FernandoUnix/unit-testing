package com.study.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.study.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 1, 2, 3 };
	}
}

class SomeDataServiceEmptyStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}

class SomeDataServiceOneElementStub implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] { 5 };
	}
}

public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {

		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
		someBusinessImpl.setSomeDataService(new SomeDataServiceStub());

		int actualResult = someBusinessImpl.calculateSumUsingDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void calculateSumUsingDataService_empty() {

		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
		someBusinessImpl.setSomeDataService(new SomeDataServiceEmptyStub());
		
		int actualResult = someBusinessImpl.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void calculateSumUsingDataService_oneValue() {

		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
		someBusinessImpl.setSomeDataService(new SomeDataServiceOneElementStub());
		
		int actualResult = someBusinessImpl.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);

	}

}
