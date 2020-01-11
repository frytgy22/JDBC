package servlet;

public interface PageManipulation {

    static String showInfo(String id) {
        return "<script>window.addEventListener('load', () => {\n" +
                "    document.getElementById(\"" + id + "\").style.display = 'block';\n" +
                "    $(\"#" + id + "\").animate({opacity: 1,}, 1000);\n" +
                "});</script>";
    }
}
