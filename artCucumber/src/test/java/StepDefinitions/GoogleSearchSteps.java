package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	@Given("browser is open")
	public void browser_is_open() {
	    System.out.println("inside steps - browser is open");
	}

	@Given("user is on google search")
	public void user_is_on_google_search() {
		 System.out.println("inside steps - user  is on google search");
	}

	@When("user enters a search text")
	public void user_enters_a_search_text() {
		 System.out.println("inside steps - users enters a search is open");
	}

	@When("hits enter")
	public void hits_enter() {
		 System.out.println("inside steps - users hits enter is open");
	}

	@Then("use is navigated to search results")
	public void use_is_navigated_to_search_results() {
		 System.out.println("inside steps - search result displayed");
	}


}
