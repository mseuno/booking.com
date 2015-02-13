(function($) {
	searchPage = function() {

		var lastPage = false;
		var requestFinished = true;
		
		var dialogBox;
		var map;
		
		var hotelMarkerInfo;
		var markers = {};
		var bounds;
		var lastShownHotel;
		
		var initializeDatePicker = function() {

			var dateFrom = $(".date-selectors #date-from");
			var dateTo = $(".date-selectors #date-to");

			dateFrom.datepicker({
				showOn : "button",
				buttonImage : "resources/images/calendar.png",
				buttonImageOnly : true,
				minDate : "+1d",
				onSelect : function(dateText) {
					var date = dateFrom.datepicker("getDate");
					date.setDate(date.getDate() + 1);
					dateTo.datepicker("option", "minDate", date);
				}
			});

			dateTo.datepicker({
				showOn : "button",
				buttonImage : "resources/images/calendar.png",
				buttonImageOnly : true,
				minDate : "+2d"
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
				source : "autocomplete",
				minLength : 2,
				response : function(event, ui) {
					clearSearchData();
				},
				select : onAutocompleteValueSelected
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

		var submitBtn = function() {
			$("#submit-search-btn").on("click",function() {
					var submit = true;
					var unknownDate = $("#unknown-date-checkbox")
							.is(":checked");
					var searchValue = $(
							"#autocomplete-search-field").val();
					var dateFrom = $(".date-selectors #date-from")
							.val();
					var dateTo = $(".date-selectors #date-to")
							.val();

					if (searchValue == '') {
						$("#autocomplete-search-field").css({
							'border' : '2px solid #FF0000'
						});
						submit = false;
					}

					if (!unknownDate && dateFrom == ''
							&& dateTo == '') {
						$(
								".date-selectors #date-from, .date-selectors #date-to")
								.css({
									'border' : '2px solid #FF0000'
								});
						submit = false;
					}

					if (submit) {
						return true;
					}

					return false;
				});

		};
		
		var initPaginator = function () {
			$(window).scroll(function(){
                if ($(window).scrollTop() + 50 >= $(document).height() - $(window).height()){
                	getNextResultPage();
                }
	        });
		};
		
		var getNextResultPage = function () {
			if (!lastPage && requestFinished) {
				requestFinished = false;
				searchPageAjax.getNextResults(
						{}, function (data) {
							if (data != undefined && $(data).length != 0) {
								$("#search-results").append(data);
								onHotelAddressClick();
							} else {
								lastPage = true;
							}
							requestFinished = true;
						}
				);
			}			
		};
		
		var getAllHotelPositions = function () {
			
			searchPageAjax.getHotelsForMap(
					{}, 
					function (data) {
						hotelMarkerInfo = data;
						
						for (var i in hotelMarkerInfo) {

							var latLng = new google.maps.LatLng(
							hotelMarkerInfo[i].info.latitude,
							hotelMarkerInfo[i].info.longitude);
							
							var marker = new google.maps.Marker({
								position : latLng,
								icon: 'resources/images/hotel-pin.png', 
								map : map
							});
							
							lastShownHotel = hotelMarkerInfo[i].id;
							bounds.extend(marker.position);
							
							markers[hotelMarkerInfo[i].id] = marker;
						}
					}
			);
		};
		
		var initializeMapDialog = function() {
			
			var mapOptions = {
					zoom : 12
				};
			map = new google.maps.Map(
					document.getElementById("map-canvas"), mapOptions);
			
			bounds = new google.maps.LatLngBounds();
			
			dialogBox = $("#map-dialog");

			$("#show-map-btn").on("click", function() {
				showMap();
			});

			$("#map-dialog #close-map-btn").on("click", function() {
				if (markers[lastShownHotel] != undefined) {
					markers[lastShownHotel].setIcon("resources/images/hotel-pin.png");
				}
				dialogBox.hide();
			});
			
			getAllHotelPositions();
			
			onHotelAddressClick();
		};
		
		var showMap = function () {
			dialogBox.show();
			google.maps.event.trigger(map, 'resize');
			map.fitBounds(bounds);
		};
		
		var onHotelAddressClick = function () {
			$(".hotel-info .hotel-location").on('click', function () {
				if (markers[lastShownHotel] != undefined) {
					markers[lastShownHotel].setIcon("resources/images/hotel-pin.png");
				}
				var id = $(this).attr("data-info");
				markers[id].setIcon("resources/images/selected-hotel-pin.png");
				lastShownHotel = id;
				showMap();
			});
		};
		
		var initSort = function () {
			$('.dropdown-toggle').dropdown();
			
			$(".dropdown-menu .sort-element").on('click', function () {
				var type = $(this).attr('data-value');
				searchPageAjax.sort( 
						{
							'type': type
						}, function (data) {
							$("#search-results").html(data);
							lastPage = false;
						}
				);
				$("#sort-result-btn").html( $(this).text() + '<span class="caret"></span>');
			});
		};

		this.initialize = function() {
			initializeDatePicker();
			initializeAutocomplet();
			submitBtn();
			initPaginator();
			initializeMapDialog();
			initSort();
		};

		this.initialize();

	};

	$(document).ready(function() {
		searchPage();
	});
})(jQuery);