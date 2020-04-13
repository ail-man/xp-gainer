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
import static com.ail.duolingo.xpgainer.Resolver.tapPairsChallenge;
import static com.ail.duolingo.xpgainer.Resolver.waitForContinueAndClick;
import static com.ail.duolingo.xpgainer.Resolver.waitForFinalContinueAndClick;
import static com.ail.duolingo.xpgainer.Resolver.waitForNextContinueAndClick;

/**
 * @author Artur Lomsadze
 */
public class Lesson1 implements ILesson {

	@Override
	public void learn() {
		goTo("de-guten-morgen");

		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("Yes, that's true.");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("where her English book is.");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("wants some coffee.");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("She is putting sugar in her coffee.");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("What?");
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();
		waitForContinueAndClick();

		selectCorrectAnswer("she put salt in her coffee.");
		waitForContinueAndClick();

		tapPairsChallenge("/lesson1.csv");

		waitForContinueAndClick();
		waitForNextContinueAndClick();
		waitForFinalContinueAndClick();
	}
}
