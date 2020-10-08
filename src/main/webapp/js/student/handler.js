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

var StudentAddHandler = function () {
    var self = this;
    StudentAddHandler.prototype.init = function () {
        self.showData();
    };
    StudentAddHandler.prototype.showData = function () {
        $("#student_add").tmpl().appendTo("#add");
    };
};

var StudentIdHandler = function () {
    var self = this;
    StudentIdHandler.prototype.init = function () {
        self.getData();
    };
    StudentIdHandler.prototype.getData = function () {
        $.get("/student/list", function(data) {
            self.showData(data);
        });
    };
    StudentIdHandler.prototype.showData = function (data) {
        $("#student_id_list_head").tmpl().appendTo("#id_result");
        $("#student_id_list_data").tmpl(data).appendTo("#table_id_data");
    };
};

function retrieveId() {
    var retrievedId = $("#student_id").val();
    $.get("/student/search/id", { retrievedId }, function(data) {
        console.log(data);
        $("#id_result").empty();
        $("#student_id_list_data").tmpl(data).appendTo("#id_result");
    });
}
function formToJson() {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
    $("#addStudent").submit(function(e) {
        e.preventDefault();
        var formData = new FormData(this);
        var object = {};
        formData.forEach(function(value,key) {
            object[key] = value;
        });
        var jsonData = JSON.stringify(object);
        console.log(jsonData+"hvhnv");
        $.ajax({
            type: 'POST',
            url: '/student/save',
            contentType:"application/json; charset:utf-8",
            data : jsonData,
            beforeSend: function(xhr){
                xhr.setRequestHeader(header, token);
            },
            error: function(data){
                console.log("failed");
            },
            success: function (data) {
                console.log("done"+data);
            }
        });

    })
}
