(function($) {
	managerEditHotelPage = function() {

		var map;
		var marker;
		
		var initMap = function() {
			var lat = $("#latitude").val();
			var long = $("#longitude").val();
			var center;
			var setMarker = false;
			
			if (lat != '' && long != '') {
				center = new google.maps.LatLng(lat, long);
				setMarker = true;
			} else {
				center = new google.maps.LatLng(49.841792, 24.028196);
			}

			var mapOptions = {
				zoom : 12,
				center : center
			};
			map = new google.maps.Map(document.getElementById('map-canvas'),
					mapOptions);

			google.maps.event.addListener(map, 'click', function(event) {
				setLocation(event.latLng);
			});
			if (setMarker) {
				marker = new google.maps.Marker({
					position : center,
					map : map
				});
			}
		
		};

		var setLocation = function(latLng) {
			if (marker != undefined && marker != null) {
				marker.setPosition(latLng);
			} else {
				marker = new google.maps.Marker({
					position : latLng,
					map : map
				});
			}
			$("#latitude").val(latLng.lat());
			$("#longitude").val(latLng.lng());
		};
		
		var initSelectors = function() {
			$("#country-selector").on('change', function() {
				if (this.value == 'search_all') {
					$("#region-selector").html("");
					$("#city-selector").html("");
					$("#street-selector").html("");
					return false;
				}
				
				managerEditHotelAjax.getRegion({
					'country_id' : this.value
				}, function(data) {
					$("#region-selector").html(data);
					$("#city-selector").html("");
					$("#street-selector").html("");
				});
			});

			$("#region-selector").on('change', function() {
				if (this.value == 'search_all') {
					$("#city-selector").html("");
					$("#street-selector").html("");
					return false;
				}
				managerEditHotelAjax.getCity({
					'region_id' : this.value
				}, function(data) {
					$("#city-selector").html(data);
					$("#street-selector").html("");
				});
			});

			$("#city-selector").on('change', function() {
				if (this.value == 'search_all') {
					$("#street-selector").html("");
					return false;
				}
				managerEditHotelAjax.getStreet({
					'city_id' : this.value
				}, function(data) {
					$("#street-selector").html(data);
				});
			});

			$("#invoke-submit-selector").on('change', function() {
				$("#form-to-submit").submit();
			});
		};

		this.initialize = function() {
			initSelectors();
			initMap();
		};

		this.initialize();

	};

	$(document).ready(function() {
		managerEditHotelPage();
	});
})(jQuery);