function MatchSearch() {
    var input, filter, ul, li, a, i, txtValue, b, txtValue2;
    input = document.getElementById("search");
    filter = input.value.toUpperCase();
    ul = document.getElementById("game-matchs");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].getElementsByTagName("h4")[0];
        b = li[i].getElementsByTagName("h4")[1];
        txtValue = a.textContent || a.innerText;
        txtValue2 = b.textContent || b.innerText;

        if (txtValue.toUpperCase().indexOf(filter) > -1 || txtValue2.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";
        }
    }
}