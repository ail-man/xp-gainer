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
import static com.ail.duolingo.xpgainer.Resolver.tapCorrectWord;
import static com.ail.duolingo.xpgainer.Resolver.tapPairsChallenge;
import static com.ail.duolingo.xpgainer.Resolver.waitForContinueAndClick;
import static com.ail.duolingo.xpgainer.Resolver.waitForFinalContinueAndClick;
import static com.ail.duolingo.xpgainer.Resolver.waitForNextContinueAndClick;

/**
 * @author Artur Lomsadze
 */
public class Lesson2 implements ILesson {

	@Override
	public void learn() {
		goTo("de-ein-date");

		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("what Julia wants to eat.");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("Yes, that's true.");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("His father is Italian, and his mother is German.");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		tapCorrectWord("Hast");
		tapCorrectWord("du");
		tapCorrectWord("Hunde");
		tapCorrectWord("oder");
		tapCorrectWord("Katzen");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("Yes, that's true.");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("lied to his real date because he likes Julia.");
		waitForContinueAndClick();

		tapPairsChallenge("/lesson2.csv");

		waitForContinueAndClick();
		waitForNextContinueAndClick();
		waitForFinalContinueAndClick();
	}
}
