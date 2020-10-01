/**
 * @author Amol Dhekane
 * @since 01/10/20 10:34 AM
 * @version 1.1
 */
var StudentHandler = function () {
    var self = this;
    StudentHandler.prototype.init = function () {
        self.getData();
    };
    StudentHandler.prototype.getData = function () {
        $.get("/student/list", function(data) {
            self.showData(data);
        });
    };
    StudentHandler.prototype.showData = function (data) {
        $("#student_list_head").tmpl().appendTo("#result");
        $("#student_list_data").tmpl(data).appendTo("#table_data");
    };
};