/**
 * 加载头
 */
    $.ajax({
        type: "get",
        url: "headerLogo.html",
        success: function (html) {
            $("#allHeader").html(html);
        }
    });


/**
 * 加载脚
 */
    $.ajax({
        type: "get",
        url: "footer.html",
        success: function (html) {
            $("#allFooter").html(html);
        }
    });
