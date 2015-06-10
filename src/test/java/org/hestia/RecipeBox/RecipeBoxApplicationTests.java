package org.hestia.RecipeBox;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RecipeBoxApplication.class)
public class RecipeBoxApplicationTests
{
	@Test
	public void getAllRecipes() {
		String expectedHttpStatus = "200";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Object[]> results = restTemplate
				.getForEntity("http://localhost:9080/recipes/", Object[].class);

		Assert.assertEquals(expectedHttpStatus, results.getStatusCode().toString());
	}
}
