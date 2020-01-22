window.addEventListener('load', () => {

    document.getElementById("ul").addEventListener("click", function (event) {
        let target = event.target;

        if (target.tagName === 'SPAN') {

            let nameCookie = target.parentElement.firstChild.textContent;

            if ("delete" === target.className) {
                document.getElementById("key").value = nameCookie;
                document.getElementById("deleteForm").submit();

            } else if ("edit" === target.className) {

                let h3 = document.getElementById("info");
                let info = document.createTextNode("Edit cookie: " + nameCookie);

                if (h3.firstChild !== null) {
                    h3.replaceChild(info, h3.firstChild)
                } else {
                    h3.appendChild(info);
                }

                animate("addForm");
                animate("ul");

                document.getElementById("name").value = nameCookie;

                $("#editForm").animate({opacity: 1,}, 1000);
            }
        }
    });

    function animate(id) {
        let el = document.getElementById(id);
        $(el).animate({opacity: 0,}, 1000);
        el.style.display = 'none';
    }
});