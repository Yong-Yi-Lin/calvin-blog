function showContent(id) {
      var sections = document.getElementsByTagName("section");
      for (var i = 0; i < sections.length; i++) {
        sections[i].classList.add("hidden");
      }
      var targetSection = document.getElementById(id);
      targetSection.classList.remove("hidden");
    }
	function goToHomePage() {
	    window.location.href = 'index.html';
	}