document.getElementById("delete").addEventListener("click", function () {
    let form = document.getElementById("deleteF");
    let info = form.firstElementChild.nextElementSibling.value;
    let del = confirm("Delete the post: " + info + "?");

    if (del) {
        form.submit();
    }
});

document.getElementById("edit").addEventListener("click", function () {

    animate("post", 0, 'none');
    animate("editF", 1, 'block');
});

function animate(id, opacity, display) {
    let el = document.getElementById(id);
    $(el).animate({opacity: opacity,}, 1000);
    el.style.display = display;
}