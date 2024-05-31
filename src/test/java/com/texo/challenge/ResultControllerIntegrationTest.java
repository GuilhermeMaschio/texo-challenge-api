package com.texo.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.texo.challenge.dtos.ResultFinalWinnerDTO;
import com.texo.challenge.dtos.WinnerDTO;

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

		ResultFinalWinnerDTO expected = objectMapper.readValue(resource.getFile(), ResultFinalWinnerDTO.class);
		ResultFinalWinnerDTO actual = restTemplate.getForObject("/result", ResultFinalWinnerDTO.class);

		compareResultFinalWinner(expected.getMin(), actual.getMin(), MIN);
		compareResultFinalWinner(expected.getMax(), actual.getMax(), MAX);

	}

	private void compareResultFinalWinner(List<WinnerDTO> expectedList, List<WinnerDTO> actualList, String listName) {
		assertEquals(expectedList.size(), actualList.size(), "diferent list size " + listName);

		for (int i = 0; i < expectedList.size(); i++) {
			WinnerDTO expectedItem = expectedList.get(i);
			WinnerDTO actualItem = actualList.get(i);

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
