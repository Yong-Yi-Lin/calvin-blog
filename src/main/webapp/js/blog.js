
    // 获取父元素
    var blogsBase = document.querySelector(".blogs_base");

    // 获取所有分享图标元素
    var shareIcons = document.querySelectorAll(".fa-paper-plane");

    // 为每个分享图标添加点击事件处理程序
    shareIcons.forEach(function(shareIcon) {
    shareIcon.addEventListener("click", function() {
        // 获取当前页面的链接
        var currentUrl = window.location.href;

        // 创建一个虚拟的文本输入框
        var input = document.createElement("input");
        // 设置输入框的值为当前页面的链接
        input.value = currentUrl;
        // 将输入框添加到页面中
        document.body.appendChild(input);
        // 选中输入框的内容
        input.select();
        // 执行复制命令
        document.execCommand("copy");
        // 移除输入框
        document.body.removeChild(input);

        // 提示复制成功
        shareIcon.style.color = "blue";
        alert("链接已复制！");
    });
});
    // 获取点赞图标元素
    var likeIcons = document.querySelectorAll('.fa-thumbs-up');

    // 添加点击事件处理程序
    likeIcons.forEach(function(likeIcon) {
        likeIcon.addEventListener('click', function() {
            // 弹出一个简单的弹窗
            alert('点赞无效，请看详情文章');
        });
    });

    <!-- 换页 -->

        var pager = function(){
        //公共函数
        function T$(id){
            return document.getElementById(id);
        }
        function T$$(root,tag){
        return (root || document).getElementsByTagName(tag);
    }
        function $extend(object1,object2){
        for(var p in object2){
        object1[p] = object2[p];
    }
        return object1;
    }
        function $each(arr, callback, thisp) {
        if (arr.forEach){
        arr.forEach(callback, thisp);
    }else{
        for(var i = 0, len = arr.length; i < len; i++){
        callback.call(thisp, arr[i], i, arr);
    }
    }
    }

        //默认参数配置
        var defaultOptions = {
        elemShowCount:5,     //每页显示条数，默认为5条
        pageShowCount:4,     //显示的页码数目，默认显示4个页码
        showFirstPageBtnAndLastPageBtn:true,     //是否显示首页，尾页，默认显示
        showPrevBtnAndNextBtn:true,    //是否显示上一页，下一页，默认显示
        showPageNumTips:true,      //是否显示【1/7页】页面提示，默认显示
        showPageNum:true      //是否显示分页的数字，默认显示
    };

        //主类构造函数 参数说明：bid为元素容器div的ID,pid为分页容器div的ID,options为重写的默认配置参数
        var showPage = function(bid,pid,options){
        var self = this;
        if(!(self instanceof showPage)){
        return new showPage(bid,pid,options);
    }
        self.container = T$(bid);    //元素容器div
        self.pagerBox = T$(pid);    //翻页容器div
        if(!self.container){
        return;
    }
        self.options = $extend(defaultOptions,options||{});
        self.elem = T$$(self.container,'figure');     //需要分页的元素
        self.elemTotalCount = self.elem.length || 0;    //分页元素的总个数
        self.pageTotalCount = Math.ceil(self.elemTotalCount/self.options.elemShowCount) || 0;   //总页数
    };

        showPage.prototype = {
        constructor:showPage,
        //显示当页的元素内容，参数currPageNum为当前页码，从0开始
        showChangeElemCont: function(currPageNum){
        var self = this;     //this为showPage对象
        var nextPageCount = (currPageNum+1)*self.options.elemShowCount < self.elemTotalCount ? (currPageNum+1)*self.options.elemShowCount : self.elemTotalCount;     //判断为最后一页时，最后一页应该显示的数据条数
        for(var i=0;i<self.elemTotalCount;i++){
        self.elem[i].style.display = 'none';
    }
        for(var i=currPageNum*self.options.elemShowCount,l=nextPageCount;i<l;i++){
        self.elem[i].style.display = 'block';
    }
    },
        //显示当页的页码内容，参数currPageNum为当前页码，从0开始
        showChangePageCont: function(currPageNum){
        var self = this;      //this为showPage对象
        var firstPageHtml = prevPageHtml = pageLinkHtml = nextPageHtml = lastPageHtml = pageTips = '';     //firstPageHtml:首页   prevPageHtml:上一页  pageLinkHtml:页码表   nextPageHtml:下一页  lastPageHtml:尾页   pageTips:页码提示
        var startPage,endPage;        //startPage:页码列表中的第一页   endPage:页码列表中的最后一页
        var pageShowMidCount = Math.ceil(self.options.pageShowCount/2);      //页码中间值，当超过这个值时，页码列表发生变化
        if(self.pageTotalCount <= self.options.pageShowCount){           //总页码数小于等于默认要显示的页码数时，直接在当前页面显示全部的页码
        startPage = 0;
        endPage = self.pageTotalCount-1;
    }else{
        if(self.options.pageShowCount%2 == 0){
        if((currPageNum + 1 - pageShowMidCount) <= 0){       //首页
        startPage = 0;
        endPage = self.options.pageShowCount-1;
    }else if((currPageNum + 1 + pageShowMidCount) >= self.pageTotalCount){            //尾页
        startPage = self.pageTotalCount-1 - self.options.pageShowCount + 1;
        endPage = self.pageTotalCount-1;
    }else{
        startPage = currPageNum - pageShowMidCount + 1;
        endPage = currPageNum + pageShowMidCount;
    }
    }else{
        if((currPageNum + 1 - pageShowMidCount) <= 0){       //首页
        startPage = 0;
        endPage = self.options.pageShowCount-1;
    }else if((currPageNum + 1 + pageShowMidCount - 1) >= self.pageTotalCount){            //尾页
        startPage = self.pageTotalCount-1 - self.options.pageShowCount + 1;
        endPage = self.pageTotalCount-1;
    }else{
        startPage = currPageNum - pageShowMidCount + 1;
        endPage = currPageNum + pageShowMidCount - 1;
    }
    }
    }

        //显示首页尾页
        if(self.options.showFirstPageBtnAndLastPageBtn == true){
        firstPageHtml = '<li>首页</li>';
        lastPageHtml =     '<li>尾页</li>';
    }
        //显示上一页下一页
        if(self.options.showPrevBtnAndNextBtn == true){
        if(currPageNum != 0) prevPageHtml = '<li>上一页</li>';       //首页不显示上一页
        if(currPageNum != self.pageTotalCount-1) nextPageHtml = '<li>下一页</li>';      //尾页不显示最后一页
    }
        //显示页码数字链接
        for(var i=startPage,l=endPage;i<=l;i++){
        if(currPageNum==i){
        pageLinkHtml += '<li class="j-curr">' + (i+1) + '</li>';
    }else{
        pageLinkHtml += '<li>' + (i+1) + '</li>';
    }
    }
        //显示页码提示信息
        if(self.options.showPageNumTips == true){
        pageTips = '<span>' +(currPageNum+1) + '/' + self.pageTotalCount + '</span>';
    }
        //拼出页码元素的整体内容
        self.pagerBox.innerHTML = firstPageHtml + prevPageHtml + pageLinkHtml + nextPageHtml + lastPageHtml + pageTips;

        var elems = T$$(self.pagerBox,'li');
        $each(elems, function(o, i) {
        o.onclick = function() {
        if(o.innerText == '首页'){
        self.showChangeElemCont(0);
        self.showChangePageCont(0);
    }else if(o.innerText == '尾页'){
        self.showChangeElemCont(self.pageTotalCount-1);
        self.showChangePageCont(self.pageTotalCount-1);
    }else if(o.innerText == '上一页'){
        self.showChangeElemCont(currPageNum-1);
        self.showChangePageCont(currPageNum-1);
    }else if(o.innerText == '下一页'){
        self.showChangeElemCont(currPageNum+1);
        self.showChangePageCont(currPageNum+1);
    }else{
        index = parseInt(o.innerText) - 1;
        self.showChangeElemCont(index);
        self.showChangePageCont(index);
    }
    }
    });
    }
    };

        return{
        onShowPage:function(bid,pid,options){
        //调用主类
        var st = new showPage(bid,pid,options);
        st.showChangeElemCont(0);
        st.showChangePageCont(0);
    }
    }
    }();

        pager.onShowPage('list','pager',{elemShowCount:4,pageShowCount:5});
