/*
 * Copyright(c) 2012-2020 optile GmbH. All Rights Reserved.
 * https://www.optile.net
 *
 * This software is the property of optile GmbH. Distribution
 * of this software without agreement in writing is strictly prohibited.
 *
 * This software may not be copied, used or distributed unless agreement
 * has been received in full.
 */
package com.ail.duolingo.xpgainer;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

/**
 * @author Artur Lomsadze
 */
public class XPGainerTest {

	@Test
	public void automateXpGaining() {
		login();
		goToStories();
		for (int i = 0; i < 100; i++) {
			goToSaturdayNight();
			learnLesson();
		}
	}

	private void login() {
		final String login = System.getProperty("duolingo.username");
		final String password = System.getProperty("duolingo.password");

		open("https://www.duolingo.com/");
		element("a[data-test='have-account']").click();
		element("input[type='text'][data-test='email-input']").setValue(login);
		element("input[type='password'][data-test='password-input']").setValue(password);
		element("button[type='submit'][data-test='register-button']").click();
		Wait().until(urlContains("https://www.duolingo.com/learn"));
	}

	private void goToStories() {
		element("a[data-test='stories-nav']").click();
		Wait().until(urlContains("https://stories.duolingo.com/?referrer=web_tab"));
	}

	private void goToSaturdayNight() {
		element("a[class='story'][href='/lessons/de-samstagabend']").click();
		Wait().until(urlContains("https://stories.duolingo.com/lessons/de-samstagabend"));
	}

	private void learnLesson() {
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("Yes, that's true.");
		waitForContinueAndClick();
		waitForContinueAndClick();

		tapCorrectPhrase("Konzertkarten");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("if Viktoria wants to go to a concert on Saturday.");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("Study for a test.");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("Viktoria is the guitar player for the band.");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		tapCorrectPhrase("Lernst");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("He thinks Viktoria is a great guitar player.");
		waitForContinueAndClick();

		tapPairsChallenge();
		waitForContinueAndClick();
		waitForNextContinueAndClick();
		waitForFinalContinueAndClick();
	}

	private void waitForContinueAndClick() {
		waitForContinueAndClick("button[class='continue']");
	}

	private void waitForNextContinueAndClick() {
		waitForContinueAndClick("button[class='continue end-slides-continue-button']");
	}

	private void waitForFinalContinueAndClick() {
		waitForContinueAndClick("button[class='continue finish-button end-slides-continue-button']");
	}

	private void waitForContinueAndClick(final String cssSelector) {
		try {
			final SelenideElement continueButton = element(cssSelector);
			Wait().until(ExpectedConditions.elementToBeClickable(continueButton));
			continueButton.click();
		} catch (final Exception e) {
			//
		}
	}

	private void selectCorrectAnswer(final String correctAnswer) {
		findElementAndClick("li[class='click-to-select']", correctAnswer);
	}

	private void tapCorrectPhrase(final String correctPhrase) {
		findElementAndClick("div[class='phrase tappable-phrase']", correctPhrase);
	}

	private void findElementAndClick(final String cssSelector, final String textToSearch) {
		final ElementsCollection elements = $$(cssSelector);
		for (final SelenideElement element : elements) {
			final String text = element.getText();
			if (StringUtils.containsIgnoreCase(text, textToSearch)) {
				element.click();
			}
		}
	}

	private void tapPairsChallenge() {
		final ElementsCollection selectableTokens = $$("button[class='selectable-token']");
		for (final SelenideElement token : selectableTokens) {
			token.click(); // mark token to change its class to 'selectable-token match-selected'

			final String text = token.getText();
			final List<String> translations = findTranslations(text);

			if (translations == null) {
				token.click(); // revert the class of the token to 'selectable-token'
				continue;
			}

			final SelenideElement translatedToken = findToken(translations);
			if (translatedToken == null) {
				token.click(); // revert the class of the token to 'selectable-token'
				continue;
			}

			translatedToken.click();
		}
	}

	private List<String> findTranslations(final String text) {
		final Map<String, List<String>> pairs = Pairs.readFromFileResource("/pairs.csv");
		return pairs.get(text);
	}

	private SelenideElement findToken(final List<String> textsToSearch) {
		final ElementsCollection selectableTokens = $$("button[class='selectable-token']");
		for (final SelenideElement token : selectableTokens) {
			final String text = token.getText();
			for (final String textToSearch : textsToSearch) {
				if (StringUtils.equalsIgnoreCase(text, textToSearch)) {
					return token;
				}
			}
		}
		return null;
	}
}
