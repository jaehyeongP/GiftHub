

function openFile(imageFile){

    console.log(imageFile.files[0]);

    const formData = new FormData();
    formData.append("imageFile", imageFile.files[0])

    $.ajax({
        url: "/api/gifticon/add",
        type: "post",
        data : formData,
        dataType : 'json',
        contentType : false,
        processData : false,
        enctype: "multipart/form-data",

        success : function (jsonData){
            alert("등록 성공");
            location.reload();

        },


        error : function (error){
            console.log(error)
        }

    })

}