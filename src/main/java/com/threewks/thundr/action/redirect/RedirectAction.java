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
package com.threewks.thundr.action.redirect;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.threewks.thundr.action.Action;
import com.threewks.thundr.route.Route;

public class RedirectAction implements Action {
	private String redirectTo;

	public RedirectAction(String redirectTo) {
		this.redirectTo = redirectTo;
	}

	public String getRedirectTo(Map<String, String> pathVars) {
		String finalRedirect = redirectTo;

		Matcher matcher = Route.PathParameterPattern.matcher(redirectTo);
		while (matcher.find()) {
			String token = matcher.group(1);
			finalRedirect = finalRedirect.replaceAll(Pattern.quote("{" + token + "}"), Matcher.quoteReplacement(StringUtils.trimToEmpty(pathVars.get(token))));
		}
		return finalRedirect;
	}

	@Override
	public String toString() {
		return "Redirect:" + redirectTo;
	}

}
