$(document).ready(function() {
	$(".seo-header").on("click", function() {
		$(this).next(".seo-content").toggle();

	});
});

$(document).ready(function() {
	size_myContainer = $("#myContainer .span3").size();
	$(".showLess").hide();
	x = 3;
	step = 2;
	$("#myContainer .span3 .article").each(function(index, obj) {
		if (index < x)
			$(obj).show();
	});

	$(".loadMore").click(function loadMore() {
		x = (x + step <= size_myContainer) ? x + step : size_myContainer;
		$("#myContainer .span3 .article").each(function(index, obj) {
			if (index >= x - step && index < x){
				$(obj).removeClass("fadeOutDown");
				$(obj).show();
			}
		});
		$(".showLess").show();
		if (x == size_myContainer) {
			$(".loadMore").hide();
		}
	})
	$(".showLess").click(function showLess() {
		x = (x - step < 0) ? 3 : x - step;
		$("#myContainer .span3 .article").each(function(index, obj) {
			if (index >= x) {
				$(obj).addClass("fadeOutDown");
			}
		});
		$(".loadMore").show();
		$(".showLess").show();
		if (x == 3) {
			$(".showLess").hide();
		}
	});
});