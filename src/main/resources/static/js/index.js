$(function() {
	page.init();
	$('#searchBtn').click(function() {
		var url = $("#h_url").text();
		var searchVal = $('#searchVal').val();
		// alert('searchVal:' + searchVal);
		location.href = "/" + url + "?searchMsg=" + searchVal;
	});

});

