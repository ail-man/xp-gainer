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
import static com.ail.duolingo.xpgainer.Resolver.tapPairsChallenge;
import static com.ail.duolingo.xpgainer.Resolver.waitForContinueAndClick;
import static com.ail.duolingo.xpgainer.Resolver.waitForFinalContinueAndClick;
import static com.ail.duolingo.xpgainer.Resolver.waitForNextContinueAndClick;

/**
 * @author Artur Lomsadze
 */
public class Lesson10 implements ILesson {

	@Override
	public void learn() {
		goTo("de-samstagabend");

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

		tapPairsChallenge("/lesson10.csv");

		waitForContinueAndClick();
		waitForNextContinueAndClick();
		waitForFinalContinueAndClick();
	}
}
