		// handle theme buttons
	   		document.getElementById("theme1").addEventListener("click", function () {
	   		    document.getElementById("s-content").style.backgroundImage = "none";
	   		    document.getElementById("s-content").style.backgroundColor = "#84AF9B ";
	   		});
	   
	   		document.getElementById("theme2").addEventListener("click", function () {
	   		    document.getElementById("s-content").style.backgroundImage = "none";
	   		    document.getElementById("s-content").style.backgroundColor = "#D0D0D0";
	   		});
	   
	   		document.getElementById("theme3").addEventListener("click", function () {
	   		    document.getElementById("s-content").style.backgroundImage = "none";
	   		    document.getElementById("s-content").style.backgroundColor = "#D24D57 ";
	   		});
	   document.getElementById("theme4").addEventListener("click", function () {
	       document.getElementById("s-content").style.backgroundImage = "none";
	       document.getElementById("s-content").style.backgroundColor = "#ffffff";
	   });
	   		// handle photo upload
	   		document.getElementById("uploadButton").addEventListener("click", function () {
	   		    var photoInput = document.getElementById("photoInput");
	   		    var file = photoInput.files[0];
	   
	   		    var reader = new FileReader();
	   		    reader.onload = function (e) {
	   		        document.getElementById("s-content").style.backgroundImage = "url(" + e.target.result + ")";
	   		        document.getElementById("s-content").style.backgroundColor = "";
	   		    };
	   		    reader.readAsDataURL(file);
	   		});
