package org.nucleus8583.core.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.URL;

import org.junit.Test;

public class ResourcesUtilsTest {

	@Test
	public void testGetURLsClasspath() throws Exception {
		URL[] urls = ResourceUtils.getURLs("classpath:META-INF/test.zz");

		assertNotNull(urls);
		assertEquals(1, urls.length);

		assertEquals('a', urls[0].openStream().read());
	}

	@Test
	public void testGetURLsClasspathNotFound() throws Exception {
		URL[] urls = ResourceUtils.getURLs("classpath:META-INF/test.zz2");

		assertNotNull(urls);
		assertEquals(0, urls.length);
	}

	@Test
	public void testGetURLsFile() throws Exception {
		URL[] urls = ResourceUtils
				.getURLs("file:src/test/resources/META-INF/test.zz");

		assertNotNull(urls);
		assertEquals(1, urls.length);

		assertEquals('a', urls[0].openStream().read());
	}

	@Test
	public void testGetURLsFileNoScheme() throws Exception {
		URL[] urls = ResourceUtils
				.getURLs("src/test/resources/META-INF/test.zz");

		assertNotNull(urls);
		assertEquals(1, urls.length);

		assertEquals('a', urls[0].openStream().read());
	}

	@Test
	public void testGetURLClasspath() throws Exception {
		URL url = ResourceUtils.getURL("classpath:META-INF/test.zz");

		assertNotNull(url);
		assertEquals('a', url.openStream().read());
	}

	@Test
	public void testGetURLClasspathNotFound() throws Exception {
		URL url = ResourceUtils.getURL("classpath:META-INF/test.zz2");

		assertNull(url);
	}

	@Test
	public void testGetURLFile() throws Exception {
		URL url = ResourceUtils
				.getURL("file:src/test/resources/META-INF/test.zz");

		assertNotNull(url);
		assertEquals('a', url.openStream().read());
	}

	@Test
	public void testGetURLFileNoScheme() throws Exception {
		URL url = ResourceUtils.getURL("src/test/resources/META-INF/test.zz");

		assertNotNull(url);
		assertEquals('a', url.openStream().read());
	}
}
