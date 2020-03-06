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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Artur Lomsadze
 */
public final class Pairs {

	public static Map<String, List<String>> readFromFile(final String file) {
		try {
			final BufferedReader br = new BufferedReader(new FileReader(file));
			return getMap(br);
		} catch (final IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	public static Map<String, List<String>> readFromFileResource(final String file) {
		try {
			final BufferedReader br = new BufferedReader(new InputStreamReader(Pairs.class.getResourceAsStream(file)));
			return getMap(br);
		} catch (final IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	private static Map<String, List<String>> getMap(final BufferedReader br) throws IOException {
		final HashMap<String, List<String>> map = new HashMap<>();
		String line;
		while ((line = br.readLine()) != null) {
			final String[] str = line.split(",");
			final String key = str[0];
			final List<String> value = Arrays.asList(str[1].split(":"));
			map.put(key, value);
		}
		return map;
	}

	@Test
	@Ignore
	public void testReadFromFile() {
		final Map<String, List<String>> map = readFromFile("/home/ail/optile/projects/com.ail/xp-gainer/src/test/resources/pairs.csv");
		Assert.assertNotNull(map);
		System.out.println(map);
	}

	@Test
	public void testReadFromFileResource() {
		final Map<String, List<String>> map = readFromFileResource("/pairs.csv");
		Assert.assertNotNull(map);
		System.out.println(map);
	}
}
