(function($) {
	commonBooking = function() {
	
		var hotelId;
		var dateFrom;
		var dateTo;
		
		var dateFromPicker;
		var dateToPicker;
		
		var totalCost = 0;
		
		var _MS_PER_DAY = 1000 * 60 * 60 * 24;

		var dateDiffInDays = function (a, b) {
		  var utc1 = Date.UTC(a.getFullYear(), a.getMonth(), a.getDate());
		  var utc2 = Date.UTC(b.getFullYear(), b.getMonth(), b.getDate());
		  return Math.floor((utc2 - utc1) / _MS_PER_DAY);
		};

		var initializeData = function() {
			hotelId = $("#hidden-hotel-id").val();
			dateFrom = dateFromPicker.val();
			dateTo = dateToPicker.val();
		};
		
		var validateEmail = function (elementValue) {
            var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            return emailPattern.test(elementValue);
        };
        
        var validateMobile = function (elementValue) {
            var mobilePattern = /^\d{9}$/;
            return mobilePattern.test(elementValue);
        };
				
		var initializeDatePicker = function() {

			dateFromPicker = $(".date-selectors #date-from");
			dateToPicker = $(".date-selectors #date-to");

			dateFromPicker.datepicker({
				showOn : "button",
				buttonImage : "resources/images/calendar.png",
				buttonImageOnly : true,
				minDate : "+1d",
				onSelect : function(dateText) {
					var date = dateFromPicker.datepicker("getDate");
					date.setDate(date.getDate() + 1);
					dateToPicker.datepicker("option", "minDate", date);
					dateFrom = dateText;
				}
			});

			dateToPicker.datepicker({
				showOn : "button",
				buttonImage : "resources/images/calendar.png",
				buttonImageOnly : true,
				minDate : "+2d",
				onSelect : function(dateText) {
					dateTo = dateText;
				}
			});
		};
		
		var initializeBookingData = function() {
			bindChangeSelectedCount();
			bindBookBtnEvent();
			
			$("#search-free-rooms-btn").on('click', function () {
				if (dateFromPicker.datepicker("getDate") != null && dateToPicker.datepicker("getDate") != null) {
					commonBookingAjax.getRooms( 
						{
							'hotel_id': hotelId,
							'date_from': dateFrom,
							'date_to': dateTo
						},
						getRoomsCallback						
					);
				}
			});
		};
		
		var getRoomsCallback = function(data) {
			$(".booking-search-results").html(data);
			bindChangeSelectedCount();
			bindBookBtnEvent();
		};

		var bindChangeSelectedCount = function() {
			$(".room-count-selector").on('change', function () {
				var dayCount = dateDiffInDays(dateFromPicker.datepicker("getDate"), dateToPicker.datepicker("getDate"));
				totalCost = 0;
				$(".room-count-selector").each(function () {
					var roomId = $(this).attr("data-param");
					var roomCost = parseInt($("#room-cost-" + roomId).text(), 10);
					var currentSelectedCost = parseInt($(this).val(), 10) * roomCost * dayCount;
					totalCost = totalCost + currentSelectedCost;
				});
				$("#booking-form-total-price").text("$" + totalCost);
			});
		};
		
		var bindBookBtnEvent = function() {
			
			$("#booking-form-book-btn").on('click', function () {
				
				$("#user-info-form .input-error").hide();
				var validateFiled = true;
				var name = "";
				var surname = "";
				var mail = "";
				var phone = "";
				
				if ($("#user-info-form").length) {
					name = $("#user-name-field").val();
					surname = $("#user-surname-field").val();
					mail = $("#user-mail-field").val();
					phone = $("#user-phone-field").val();
					validateFiled = validateFields(name, surname, mail, phone); 
				}
				
				if (!validateFiled) {
					$("#user-info-form .input-error").show();
					return false;
				}
				
				var selectedRooms = getSelectedRoomJsonList();
				if (selectedRooms.length > 0) {
					commonBookingAjax.book(
						{
							'hotel_id': hotelId,
							'date_from': dateFrom,
							'date_to': dateTo,
							'totalCost': totalCost,
							'rooms': JSON.stringify(selectedRooms),
							'name': name,
							'surename': surname,
							'mail': mail,
							'phone': phone
						}, 
						function (data) {
							$(".booking-search-results").html(data);
						}
					);
				}
			});
		};
		
		var validateFields = function (name, surname, mail, phone) {
			if (validateEmail(mail) && name != "" && surname != "" && validateMobile(phone)) {
				return true;
			}
			return false;
		};
		
		var getSelectedRoomJsonList = function() {
			var selectedRooms = new Array();
			$(".room-table-row").each(function () {
				var roomId = $(this).attr("data-param");
				var numberOfRooms = parseInt($(this).find(".room-count-selector").val(), 10);
				var roomCost = parseInt($(this).find(".room-cost").text(), 10);
				var roomObj;
				
				if (numberOfRooms > 0) {
					roomObj = {
							'id': roomId,
							'count': numberOfRooms,
							'cost': roomCost
					}
					selectedRooms.push(roomObj);
				}
			});			
			return selectedRooms;
		};

		this.initialize = function() {
			initializeDatePicker();
			initializeData();
			initializeBookingData();
		};

		this.initialize();

	};

	$(document).ready(function() {
		commonBooking();
	});
})(jQuery);