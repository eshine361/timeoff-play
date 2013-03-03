var App = App || {};
App.UI = {
		resetHelpBlock: function() {			
			$('span.help-block').html("*");			
		}
}

$(document).ready(function() {
	App.UI.resetHelpBlock();
});