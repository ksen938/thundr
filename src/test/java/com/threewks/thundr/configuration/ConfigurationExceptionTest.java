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
package com.threewks.thundr.configuration;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ConfigurationExceptionTest {

	@Test
	public void shouldRetainMessage() {
		ConfigurationException configurationException = new ConfigurationException("Format %s", "message");
		assertThat(configurationException.getCause(), is(nullValue()));
		assertThat(configurationException.getMessage(), is("Format message"));
	}

	@Test
	public void shouldRetainCauseAndMessage() {
		RuntimeException cause = new RuntimeException();
		ConfigurationException configurationException = new ConfigurationException(cause, "Format %s", "message");
		assertThat(configurationException.getCause(), is((Throwable) cause));
		assertThat(configurationException.getMessage(), is("Format message"));
	}
}
