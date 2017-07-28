$(function() {
	page.init();
	$('#searchBtn').click(function() {
		var searchVal = $('#searchVal').val();
		// alert('searchVal:' + searchVal);
		location.href = "/item/" + searchVal + "?searchMsg=" + searchVal;
	});

});

/*******************************************************************************
 * 分页
 */
var page = {
	// 初始化
	init : function() {
		var url = $("#h_url").text();
		var element = $('#bp-3-element-test');// 获得数据装配的位置
		var pageInitValue = $('#pageInitValue').text();
		var pageAttr = pageInitValue.split(',');

		var searchVal = $('#searchVal').val();
		// 初始化所需数据
		var options = {
			bootstrapMajorVersion : 3,// 版本号。3代表的是第三版本
			currentPage : pageAttr[1], // 当前页数
			numberOfPages : 20, // 显示页码数标个数
			// totalPages : pageAttr[0], //总共的数据所需要的总页数
			totalPages : pageAttr[0], // 总共的数据所需要的总页数

			tooltipTitles : function(type, page, current) {
				// 如果想要去掉页码数字上面的预览功能，则在此操作。例如：可以直接return。
				switch (type) {
				case "first":
					return "Go to first page";
				case "prev":
					return "Go to previous page";
				case "next":
					return "Go to next page";
				case "last":
					return "Go to last page";
				case "page":
					return (page === current) ? "Current page is " + page
							: "Go to page " + page;
				}
			},
			onPageClicked : function(e, originalEvent, type, page) {
				// 单击当前页码触发的事件。若需要与后台发生交互事件可在此通过ajax操作。page为目标页数。
				// console.log(e);
				// console.log(originalEvent);
				// console.log(type);				
				location.href = "/" + url + "?pageNum=" + page + "&searchVal=" + searchVal;
			}
		};
		element.bootstrapPaginator(options); // 进行初始化
	}
}
