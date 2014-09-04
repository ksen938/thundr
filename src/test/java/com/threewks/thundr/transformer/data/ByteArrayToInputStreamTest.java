/*
 * This file is a component of thundr, a software library from 3wks.
 * Read more: http://www.3wks.com.au/thundr
 * Copyright (C) 2013 3wks, <thundr@3wks.com.au>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.threewks.thundr.transformer.data;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.io.InputStream;

import org.junit.Test;

import com.threewks.thundr.util.Streams;

public class ByteArrayToInputStreamTest {
	private ByteArrayToInputStream transformer = new ByteArrayToInputStream();

	@Test
	public void shouldTransformByteArrayToInputStream() {
		assertThat(transformer.from(null), is(nullValue()));
		validateInputStreamContents(transformer.from(new byte[0]), new byte[0]);
		validateInputStreamContents(transformer.from(new byte[] { 1, 2, 3 }), new byte[] { 1, 2, 3 });
	}

	private void validateInputStreamContents(InputStream is, byte[] expected) {
		byte[] readBytes = Streams.readBytes(is);
		assertThat(readBytes, is(expected));
	}
}
