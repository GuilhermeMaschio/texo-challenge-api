package com.texo.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.texo.challenge.Model.ResultFinalWinnerModel;
import com.texo.challenge.Model.WinnerModel;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ResultControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;
	
	private static final String MIN = "min";
	private static final String MAX = "max";

	@Test
	public void testGetResultFinalWinner() throws Exception {
		ClassPathResource resource = new ClassPathResource("expected_result.json");

		ResultFinalWinnerModel expected = objectMapper.readValue(resource.getFile(), ResultFinalWinnerModel.class);
		ResultFinalWinnerModel actual = restTemplate.getForObject("/producers/awards/min-max", ResultFinalWinnerModel.class);

		compareResultFinalWinner(expected.getMin(), actual.getMin(), MIN);
		compareResultFinalWinner(expected.getMax(), actual.getMax(), MAX);

	}

	private void compareResultFinalWinner(List<WinnerModel> expectedList, List<WinnerModel> actualList, String listName) {
		assertEquals(expectedList.size(), actualList.size(), "diferent list size " + listName);

		for (int i = 0; i < expectedList.size(); i++) {
			WinnerModel expectedItem = expectedList.get(i);
			WinnerModel actualItem = actualList.get(i);

			assertEquals(expectedItem.getProducer(), actualItem.getProducer(),
					"diferent Producer in " + listName + " at position " + i);
			assertEquals(expectedItem.getInterval(), actualItem.getInterval(),
					"diferent Interval in" + listName + " at position " + i);
			assertEquals(expectedItem.getPreviousWin(), actualItem.getPreviousWin(),
					"diferent PreviousWin in" + listName + " at position " + i);
			assertEquals(expectedItem.getFollowingWin(), actualItem.getFollowingWin(),
					"diferent FollowingWin in" + listName + " at position " + i);
		}
	}
}
