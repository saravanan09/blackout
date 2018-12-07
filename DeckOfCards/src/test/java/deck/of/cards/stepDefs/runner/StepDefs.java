package deck.of.cards.stepDefs.runner;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import deck.of.cards.main.Cards;
import static org.junit.Assert.*;

public class StepDefs {

	Cards cards = new Cards();
	String infoMessage;

	@Given("^I have a deck of cards$")
	public void i_have_a_deck_of_cards() throws Throwable {
		cards.createDeck();
	}

	@When("^I shuffle the deck of cards$")
	public void i_shuffle_the_deck_of_cards() throws Throwable {
		cards.shuffleDeck();
	}

	@When("^I provide \"([^\"]*)\" value for number of players$")
	public void i_provide_value_for_number_of_players(String players)
			throws Throwable {
		infoMessage = cards.dealCardToPlayers(players);
	}

	@Then("^I should see the message as \"([^\"]*)\"$")
	public void i_should_see_the_invalid_value_error_message(String errMessage)
			throws Throwable {
		assertEquals(errMessage, infoMessage);
	}

	@Then("^I should see orginal deck of cards should not match after shuffled deck$")
	public void i_should_see_orginal_deck_of_cards_should_not_match_after_shuffled_deck()
			throws Throwable {
		String duplicateCheck = cards.shufflecheck();
		assertEquals("Both are not equal", duplicateCheck);
	}

	@Then("^I should see \"([^\"]*)\" cards dealt to players and \"([^\"]*)\" players should have eleven cards and \"([^\"]*)\" players should have ten cards$")
	public void i_should_see_cards_dealt_to_players_and_players_should_have_eleven_cards_and_players_should_have_ten_cards(
			String card_player_holds, String extraCard_holders,
			String regularCard_holders) throws Throwable {

		int[] cardDeals = cards.cardsDealt();
		assertEquals(Integer.parseInt(card_player_holds), cardDeals[0]);
		assertEquals(Integer.parseInt(extraCard_holders), cardDeals[1]);
		assertEquals(Integer.parseInt(regularCard_holders), cardDeals[2]);
	}

}
