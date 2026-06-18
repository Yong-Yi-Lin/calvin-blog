document.addEventListener('DOMContentLoaded', function() {
	var one = document.getElementById("one");
	var two = document.getElementById("two");
	var three = document.getElementById("three");
	var four = document.getElementById("four");
	var five = document.getElementById("five");

	function clearClasses() {
		one.className = "heart-off";
		two.className = "heart-off";
		three.className = "heart-off";
		four.className = "heart-off";
		five.className = "heart-off";
	}

	one.addEventListener("mouseover", function() {
		clearClasses();
		one.className = "heart-hover";
	});

	two.addEventListener("mouseover", function() {
		clearClasses();
		one.className = "heart-on";
		two.className = "heart-hover";
	});

	three.addEventListener("mouseover", function() {
		clearClasses();
		one.className = "heart-on";
		two.className = "heart-on";
		three.className = "heart-hover";
	});

	four.addEventListener("mouseover", function() {
		clearClasses();
		one.className = "heart-on";
		two.className = "heart-on";
		three.className = "heart-on";
		four.className = "heart-hover";
	});

	five.addEventListener("mouseover", function() {
		clearClasses();
		one.className = "heart-on";
		two.className = "heart-on";
		three.className = "heart-on";
		four.className = "heart-on";
		five.className = "heart-hover";
	});
});