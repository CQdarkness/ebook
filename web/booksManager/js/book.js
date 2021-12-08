$(document).ready(function () {
    $("p[class='intro']").css("color", "red");
    $("#jdPrice > span").css({ "color": "red", "font-size": "24px", "font-weight": "bold" });
    $("#jdPrice>p").css({ "color": "#cccccc", "text-decoration": "line-through" });
    $(".price>dl").css({ "color": "red" });
    $("#ticket span").css({ "background-color": "red", "color": "white", "padding": "1px 5px", "margin-right": "5px" });
    $(".price>dl>dt").click(function () {
        $(".price dl dd").css({ "display": "block" });
        $(".price dl dd span").css({ "background-color": "red", "color": "white", "padding": "1px 5px", "margin-right": "5px" });

    });
})