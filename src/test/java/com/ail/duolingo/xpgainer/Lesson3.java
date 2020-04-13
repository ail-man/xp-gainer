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

import static com.ail.duolingo.xpgainer.Resolver.goTo;
import static com.ail.duolingo.xpgainer.Resolver.selectCorrectAnswer;
import static com.ail.duolingo.xpgainer.Resolver.tapCorrectPhrase;
import static com.ail.duolingo.xpgainer.Resolver.tapCorrectToken;
import static com.ail.duolingo.xpgainer.Resolver.tapCorrectWord;
import static com.ail.duolingo.xpgainer.Resolver.tapPairsChallenge;
import static com.ail.duolingo.xpgainer.Resolver.waitForContinueAndClick;
import static com.ail.duolingo.xpgainer.Resolver.waitForFinalContinueAndClick;
import static com.ail.duolingo.xpgainer.Resolver.waitForNextContinueAndClick;

/**
 * @author Artur Lomsadze
 */
public class Lesson3 implements ILesson {

	@Override
	public void learn() {
		goTo("de-eine-sache");

		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("No, that's not right.");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		tapCorrectPhrase("auch");
		waitForContinueAndClick();

		tapCorrectWord("Was");
		tapCorrectWord("brauchst");
		tapCorrectWord("du");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		tapCorrectToken("und Zucker");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		tapCorrectPhrase("Geld");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("asked Marvin to buy the one thing she wanted: bread.");
		waitForContinueAndClick();

		tapPairsChallenge("/lesson3.csv");

		waitForContinueAndClick();
		waitForNextContinueAndClick();
		waitForFinalContinueAndClick();
	}
}
