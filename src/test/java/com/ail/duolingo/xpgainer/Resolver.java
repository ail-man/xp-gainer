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
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

/**
 * @author Artur Lomsadze
 */
public final class Resolver {

	private Resolver() {
	}

	public static void goTo(final String path) {
		element("a[class='story'][href='/lessons/" + path + "']").click();
		Wait().until(urlContains("https://stories.duolingo.com/lessons/" + path));
	}

	public static void waitForContinueAndClick() {
		waitForContinueAndClick("button[class='continue']");
	}

	public static void waitForNextContinueAndClick() {
		waitForContinueAndClick("button[class='continue end-slides-continue-button']");
	}

	public static void waitForFinalContinueAndClick() {
		waitForContinueAndClick("button[class='continue finish-button end-slides-continue-button']");
	}

	public static void waitForContinueAndClick(final String cssSelector) {
		try {
			final SelenideElement continueButton = element(cssSelector);
			Wait().until(ExpectedConditions.elementToBeClickable(continueButton));
			continueButton.click();
		} catch (final Exception e) {
			//
		}
	}

	public static void selectCorrectAnswer(final String correctAnswer) {
		findElementAndClick("li[class='click-to-select']", correctAnswer);
	}

	public static void tapCorrectPhrase(final String correctPhrase) {
		findElementAndClick("div[class='phrase tappable-phrase']", correctPhrase);
	}

	public static void findElementAndClick(final String cssSelector, final String textToSearch) {
		final ElementsCollection elements = $$(cssSelector);
		for (final SelenideElement element : elements) {
			final String text = element.getText();
			if (StringUtils.containsIgnoreCase(text, textToSearch)) {
				element.click();
			}
		}
	}

	public static void tapCorrectWord(final String correctWord) {
		findElementByXpathAndClick("//div[@class='phrase-bank']/span[@class='phrase'][text()='" + correctWord + "']");
	}

	public static void tapCorrectToken(final String correctText) {
		findElementByXpathAndClick("//button[@class='selectable-token'][text()='" + correctText + "']");
	}

	private static void findElementByXpathAndClick(final String xpath) {
		final By locator = By.xpath(xpath);
		Wait().withTimeout(Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		final SelenideElement element = element(locator);
		element.click();
	}

	public static void tapPairsChallenge(final String pairsFile) {
		final ElementsCollection selectableTokens = $$("button[class='selectable-token']");
		for (final SelenideElement token : selectableTokens) {
			token.click(); // mark token to change its class to 'selectable-token match-selected'

			final String text = token.getText();
			final List<String> translations = getPairs(text, pairsFile);

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

		System.out.println("Pairs done");
	}

	private static List<String> getPairs(final String text, final String pairsFile) {
		final Map<String, List<String>> pairs = Pairs.readFromFile(pairsFile);
		return pairs.get(text);
	}

	private static SelenideElement findToken(final List<String> textsToSearch) {
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
