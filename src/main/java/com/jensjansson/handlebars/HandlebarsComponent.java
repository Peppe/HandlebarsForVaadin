package com.jensjansson.handlebars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

@JavaScript({ "handlebars-component.js", "handlebars-v1.3.0.js" })
public class HandlebarsComponent extends AbstractJavaScriptComponent {

	public HandlebarsComponent(String templateName, String context) {
		getState().templateName = templateName;
		getState().template = readFile(templateName);;
		getState().context = context;

	}

	@Override
	protected HandlebarsComponentState getState() {
		return (HandlebarsComponentState) super.getState();
	}
	
	private String readFile(String templateName) {
		String template = "ERROR";
		try {
			InputStream file = HandlebarsComponent.class
					.getResourceAsStream(templateName + ".template");
			InputStreamReader is = new InputStreamReader(file);
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(is);
			String read;
			read = br.readLine();

			while (read != null) {
				sb.append(read);
				read = br.readLine();
			}
			template = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return template;
	}
}
