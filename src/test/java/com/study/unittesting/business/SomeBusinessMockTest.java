package com.study.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.study.unittesting.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl someBusinessImpl;

	@Mock
	SomeDataService dataServiceMock;

	@Test
	public void calculateSumUsingDataService_basic() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, someBusinessImpl.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_empty() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, someBusinessImpl.calculateSumUsingDataService());
	}

	@Test
	public void calculateSumUsingDataService_oneValue() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });
		assertEquals(5, someBusinessImpl.calculateSumUsingDataService());
	}
}
