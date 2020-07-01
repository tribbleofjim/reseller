let operator = null;
layui.use('form', function(){
    let form = layui.form;
});

layui.use('table', function(){
    let table = layui.table;
    table.on('tool(iteminfo)', function (obj) {
        let data = obj.data;
        let layEvent = obj.event;
        if (layEvent === 'choose') {
            console.log(data);
            layer.open({
                content: '确认选择该分销商业务员？',
                btn: ['确认', '取消'],
                yes: function (index, layero) {
                    console.log('ph=' + data.phonenumber);
                    operator = data.phonenumber;
                    layer.close(index);
                }
            });
        }
    });
});

//监听提交
function buyProduct() {
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'createorder', true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    let userID = document.getElementById("userID").innerText.split(",")[1];
    let proID = document.getElementById("proID").innerText.split(':')[1];
    let num = document.getElementById("num").value;
    let str = 'userID=' + userID + '&proID=' + proID + '&num=' + num + '&operatorID=' + operator;
    xhr.send(str);
    xhr.onreadystatechange = function () {
        alert("购买成功!");
        // if (xhr.readyState === 4 && xhr.status === 200) {
        //     var msg = xhr.responseText;
        //     if (msg === "true") {
        //
        //         window.location.reload();
        //     } else {
        //         alert("购买失败，请稍后再试");
        //     }
        // }
    }
}