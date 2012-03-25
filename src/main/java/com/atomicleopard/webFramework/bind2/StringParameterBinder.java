package com.atomicleopard.webFramework.bind2;

import static com.atomicleopard.expressive.Expressive.list;

import com.atomicleopard.webFramework.bind.Binders;
import com.atomicleopard.webFramework.introspection.ParameterDescription;

public class StringParameterBinder implements ParameterBinder<String> {
	public String bind(Binders binder, ParameterDescription parameterDescription, PathMap pathMap) {
		String[] values = pathMap.get(list(parameterDescription.name()));
		return values != null && values.length > 0 ? values[0] : null;
	}

	@Override
	public boolean willBind(ParameterDescription parameterDescription) {
		return parameterDescription.isA(String.class);
	}
}
