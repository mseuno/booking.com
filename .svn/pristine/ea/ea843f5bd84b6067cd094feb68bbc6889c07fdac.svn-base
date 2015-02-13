(function ($) {
    commonUserPage = function () {
		
		var initializeMenu = function() {
			$("#expandeble-user-name-menu").on('click', function () {
				$(".btn-group .dropdown-menu").toggle();
			});
			
			$("#body").on('click', function () {
				if (!$(this).hasClass(".dropdown-menu")) {
					$(".btn-group .dropdown-menu").hide();
				}
			});
		};
		
        this.initialize = function () {
        	initializeMenu();
        };


        this.initialize();

    };

    $(document).ready(function () {
    	commonUserPage();   
    });
})(jQuery);