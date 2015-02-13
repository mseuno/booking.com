(function ($) {
    customerWorkAreaPage = function () {
		
		var initializeDatePicker = function() {
			
			var dateFrom = $(".date-selectors #date-from");
			var dateTo = $(".date-selectors #date-to");
			
			dateFrom.datepicker({
				showOn: "button",
				buttonImage: "resources/images/calendar.png",
				buttonImageOnly: true,
				minDate: "+1d",
				onSelect: function(dateText) {
					var date = dateFrom.datepicker("getDate");
					date.setDate(date.getDate() + 1);
					dateTo.datepicker("option", "minDate", date);
				}
			});
			
			dateTo.datepicker({
				showOn: "button",
				buttonImage: "resources/images/calendar.png",
				buttonImageOnly: true,
				minDate: "+2d"
			});
			
			if ($('#unknown-date-checkbox').is(":checked")) {
				$('#date-from').val('');
				$('#date-to').val('');
				$('.home-in').hide();
				$('.home-out').hide();
			}
			
			$('#unknown-date-checkbox').on('click', function() {
			    $('#date-from').val('');
			    $('#date-to').val('');
			    $('.home-in').toggle();
			    $('.home-out').toggle();
			});
		};
		
		var initializeAutocomplet = function() {
			$("#autocomplete-search-field").autocomplete({
				source: "autocomplete",
				minLength: 2,
				response: function(event, ui) {
					clearSearchData();
				},
				select: onAutocompleteValueSelected
		    });
		};
		
		var clearSearchData = function() {
			$("#id_city, #id_region, #id_hotel").val('');
		};
		
		var onAutocompleteValueSelected = function(event, ui) {
			clearSearchData();
			if (ui.item.type == 'city') {
				$("#id_city").val(ui.item.id);
			} else if (ui.item.type == 'region') {
				$("#id_region").val(ui.item.id);
			} else {
				window.location.href = "hotel?id=" + ui.item.id;
			}
		};
		
		var submitBtn = function () {
			$("#submit-search-btn").on("click", function () {
				var submit = true;
				var unknownDate = $("#unknown-date-checkbox").is(":checked");
				var searchValue = $("#autocomplete-search-field").val();
				var dateFrom = $(".date-selectors #date-from").val();
				var dateTo = $(".date-selectors #date-to").val();
				
				if (searchValue == '') {
					$("#autocomplete-search-field").css({
						'border': '2px solid #FF0000'
					});
					submit = false;
				}
				
				if (!unknownDate && dateFrom == '' && dateTo == '') {
					$(".date-selectors #date-from, .date-selectors #date-to").css({
						'border': '2px solid #FF0000'
					});
					submit = false;
				}
				
				if (submit) {
					return true;
				}
				
				return false;
			});
			
		};
		
        this.initialize = function () {
			initializeDatePicker();
			initializeAutocomplet();
			submitBtn();
        };


        this.initialize();

    };

    $(document).ready(function () {
        customerWorkAreaPage();   
    });
})(jQuery);