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

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

import org.junit.Test;

import com.codeborne.selenide.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Artur Lomsadze
 */
@Slf4j
public class XPGainerTest {

	public XPGainerTest() {
		Configuration.timeout = 6000;
	}

	@Test
	public void automateXpGaining() {
		login();
		goToStories();
		for (int i = 0; i < 30; i++) {
			System.out.printf("Count: %d\n", i);
			new Lesson1().learn();
			new Lesson2().learn();
			new Lesson3().learn();
			new Lesson10().learn();
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
}
