(function($) {
	hotelPageAjax = (function() {
		// function define the length of the object
		Object.size = function(obj) {
			var size = 0, key;
			for ( var key in obj) {
				if (obj.hasOwnProperty(key))
					size++;
			}
			return size;
		};
		// function that collect, check, extend and send data via ajax to server
		var request = function(arguments, data, handler, additional) {
			var errors = false;
			if (arguments.args.length != Object.size(data)) {// check for
																// length an
																// array and
																// object
				errors = true;
				console.error("lengs of data and args are different");
			} else {
				for ( var item in arguments.args) {// check for equality an
													// array and object
					var key = arguments.args[item];
					var value = data[key];
					if (value == null || value == 'undefined') {
						errors = true;
						console.error("error in key names "
								+ arguments.args.toString());
					}
				}
			}
			if (!errors) {
				var url = ''
				var settings = $.extend({
					data : data || {}, // data - object with keys and values
					url : url + arguments.name,
					async : true,
					cache : false,
					success : handler || $.noop, // handler - success
													// function
					error : function(xhr, opts, options) {
					}
				}, additional);// extend with additional params
				/*
				 * additional is - additional ajax params. By default it is
				 * emty. add aditional key and object into var args;
				 */
				return $.ajax(settings); // send data to server
			}
		};
		// below in return section are function that help plugin work correctly
		return {
			/**
			 * name - name of server function args - required arguments in data
			 */

			remove : function(data, handler) {
				var args = {
					name : 'hotel-page-favorites?action=remove',
					args : ['id']
				};
				var additional = {
					dataType: 'json'
				};
				request(args, data, handler, additional);
			},
			add : function(data, handler) {
				var args = {
					name : 'hotel-page-favorites?action=add',
					args : ['id']
				};
				var additional = {
					dataType: 'json'
				};
				request(args, data, handler, additional);
			}
		};
	})()
})(jQuery)