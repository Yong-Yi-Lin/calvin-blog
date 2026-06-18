//封装ajax函数,args为一个js对象
//args对象属性如下：
//method：请求方法，url：请求资源路径，contenType：请求正文格式
//body：请求正文，callback：回调函数，客户端接收到响应数据后调用
function ajax(args) {
    let xhr = new XMLHttpRequest();
    //设置回调函数
    xhr.onreadystatechange = function () {
        //4：客户端接收到服务端响应
        if (xhr.readyState == 4) {
            //回调函数可能会使用响应的内容,作为传入参数
            args.callback(xhr.status, xhr.responseText);
        }
    }
    xhr.open(args.method, args.url);
    //如果args中contentType有内容，就设置Content-Type请求头
    if (args.contentType) {//js中if可以判断是否有值
        xhr.setRequestHeader("Content-Type", args.contentType);
    }
    //如果args中body有内容，设置body请求正文
    if (args.body) {
        xhr.send(args.body);
    } else {
        xhr.send();
    }
}