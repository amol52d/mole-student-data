/**
 * @author Amol Dhekane
 * @since 10/10/20 11:45 AM
 * @version 1.1
 */
var RequestHandler = function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    RequestHandler.prototype.makePost = function (url, payload, callback) {
        $.ajax({
            type: 'POST',
            url: url,
            contentType:"application/json; charset:utf-8",
            data : payload,
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
            error: function(data){
                console.log("failed: " + data);
            },
            success: function (data) {
                console.log("done: " + data);
                callback(data.message);
            }
        });
    };

    /** This is universal Get request handler, callback is just function sent in parameters to be called after
     * ajax is completes. As AJAX is async we will require this callback
     * @param url
     * @param callback
     * @param template
     */

    RequestHandler.prototype.makeGet = function (url, callback, template) {
        console.log("Making get request: " + url)
        $.get(url, function(data) {
            callback(data, template)
        });
    }

};