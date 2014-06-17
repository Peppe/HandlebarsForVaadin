var templates ={};

window.com_jensjansson_handlebars_HandlebarsComponent = function() {
	var e = this.getElement();

	this.onStateChange = function() {
		var templateName = this.getState().templateName;
		var template = this.getState().template;
		var contextString = this.getState().context;
		var context = eval("(" + contextString + ')');
		templates[templateName] = Handlebars.compile(template);
		var html    = templates[templateName](context);
		e.innerHTML = html;
	};
};