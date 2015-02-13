(function($) {
	hotelPage = function() {

		var dialogBox;
		var hotelLocation;
		
		var hotelId;

		var initializeData = function() {
			hotelId = $("#hidden-hotel-id").val();
		};

		var initializeMapDialog = function() {

			dialogBox = $("#map-dialog");
			hotelLocation = $(".hotel-base-info .hotel-location");

			var latLng = new google.maps.LatLng(hotelLocation.attr("data-lat"),
					hotelLocation.attr("data-long"));

			var mapOptions = {
				zoom : 15
			};
			var map = new google.maps.Map(
					document.getElementById("map-canvas"), mapOptions);

			var marker = new google.maps.Marker({
				position : latLng,
				map : map,
				icon: 'resources/images/hotel-pin.png'
			});

			hotelLocation.on("click", function() {
				dialogBox.show();
				google.maps.event.trigger(map, 'resize');
				map.setCenter(latLng);
			});

			$("#map-dialog #close-map-btn").on("click", function() {
				dialogBox.hide();
			});
		};
		
		var initializeFavoriteButtons = function() {
			var removeBtn = $("#remove-from-favorite-btn");
			var addBtn = $("#add-favorite-btn");
			
			removeBtn.on('click', function () {
				hotelPageAjax.remove(
						{
							id: hotelId
						}, 
						function (data) {
							if (data.state) {
								removeBtn.hide();
								addBtn.show();
							}
						}
				);
			});
			
			addBtn.on('click', function () {
				hotelPageAjax.add(
						{
							id: hotelId
						}, 
						function (data) {
							if (data.state) {
								removeBtn.show();
								addBtn.hide();
							}
						}
				);
			});
		};

		this.initialize = function() {
			initializeMapDialog();
			initializeData();
			initializeFavoriteButtons();
		};

		this.initialize();

	};

	$(document).ready(function() {
		hotelPage();
	});
})(jQuery);