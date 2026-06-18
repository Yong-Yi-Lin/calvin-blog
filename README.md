# calvin-blog
大二上实训项目（作者：林永一，李海娃，李雅玫）
前端实训报告
                                                  -------------------软件222李海娃组



目录
前端实训报告	1
1.设计效果（10分）	1
2. css样式效果的使用（10分）	10
15.效果图：	26
16.效果图：	27
17. 效果图：	27
18、效果图：	28
20、效果图：	46
21、效果图：	51
22、 效果图：	53
3.js对DOM元素的增删改查\事件绑定等（30分）	55
3.1.1selectQuery系列方法	55
1. 板块截图	55
2. 板块截图	55
3、板块截图	56
2.板块截图	61
1.板块截图：	63
2.板块截图	64
1. 板块截图	65
2. 板块截图	67
9. 板块截图；	76
10. 板块截图；	77
11. 板块截图：	78
4. 表单验证 （10分）	85
3. 板块截图：	87
5. AJAX通信和数据解析（30分）	88

1.设计效果（10分）
主页：



(音乐播放页面效果)

首页：






文章正文内容：







（其他部分和首页布局差不多）
个人-部分
编辑页面：

“我的”页面：

个人中心页面：




作者页面：

登录注册页面：
登录：

注册：














找回密码：







其他部分页面
About.html:

Q&A.html:













Contact.html:

Article.html:

2.css样式效果的使用（10分）
效果图1：

功能描述：动画animation实现加载效果
对应代码：


效果图2：

功能描述：使用伪元素选择器和类选择器实现评分效果
对应代码：

效果图3：

功能描述：导航栏透明度切换效果
对应代码：/* 导航栏透明度切换效果 */
.s-header {
    transition: background-color 0.3s ease;
}

.s-header--opaque {
    background-color: black;
}




效果图4：

功能描述：logo样式
对应代码：
.s-header__logo {
    z-index: 101;
    margin: 0;
    -webkit-transform: translateY(-50%);
    transform: translateY(-50%);
    position: absolute;
    top: calc(50% - 6px);
    left: 4rem;
}

.s-header__logo a {
    display: block;
    margin: 0;
    padding: 0;
    outline: 0;
    border: none;
    -webkit-transition: all .3s;
    transition: all .3s;
}

.s-header__logo img {
    width: var(--logo-width);
    height: var(--logo-height);
    margin: 0;
    vertical-align: bottom;
}


效果图5：

功能描述：过渡效果
对应代码：
.s-header__search-inner {
    /* ... (其他样式) ... */
    -webkit-transition: -webkit-transform 0.5s 0.3s cubic-bezier(0, 0.55, 0.45, 1);
    transition: -webkit-transform 0.5s 0.3s cubic-bezier(0, 0.55, 0.45, 1);
    transition: transform 0.5s 0.3s cubic-bezier(0, 0.55, 0.45, 1);
    transition: transform 0.5s 0.3s cubic-bezier(0, 0.55, 0.45, 1), -webkit-transform 0.5s 0.3s cubic-bezier(0, 0.55, 0.45, 1);
}

效果图6：


功能描述：字体样式
对应代码：
@font-face {
	font-family: "font1";
	src: url("HeFengShuDaoZhaoHeFeiLongTi-Shan(GEETYPE-FeilongGBT-Flash)-2.ttf");
	font-weight: normal;
	font-style: normal;
}

@font-face {
	font-family: "font2";
	src: url("ZiWanGeTeHeiBaiWuChang-MianFei-ChaoHei(Joyfont-GhostsGB-free-Heavy)-2.ttf");
}

@font-face {
	font-family: "font3";
	src: url("AaYouLongXingShu-2.ttf");
}

@font-face {
	font-family: "font4";
	src: url("DuanNingMaoBiXingYiTi-2.ttf");
}

@font-face {
	font-family: "font5";
	src: url("AaJiuZhongXiao-2.ttf");
}
<h1 class="s-hero__slide-text" style="font-family: font1;">
    <a href="#0" >
		帮助您开始自由职业的提示和想法
    </a>
 </h1>


效果图7：

功能描述：社交链接样式
对应代码：
.s-hero__social {
    font-size: var(--text-xs);
    font-weight: 400;
    color: white;
    text-align: right;
    position: absolute;
    right: 4rem;
    bottom: 15vh;
}

.s-hero__social p {
    line-height: 1;
    margin: 0;
    position: relative;
    -webkit-transform: rotate(90deg);
    transform: rotate(90deg);
}

.s-hero__social span {
    display: block;
    width: 1px;
    height: 3.6rem;
    background-color: white;
    margin: 3.6rem auto 4.8rem;
}

.s-hero__social-icons {
    list-style: none;
    margin-left: 0;
    font-size: 2.4rem;
}

.s-hero__social-icons li {
    padding-left: 0;
    margin-bottom: var(--vspace-0_75);
    text-align: center;
}

.s-hero__social-icons a {
    color: white;
}

.s-hero__social-icons a svg {
    -webkit-transform: scale(0.85);
    transform: scale(0.85);
    -webkit-transition: all 0.3s ease-in-out;
    transition: all 0.3s ease-in-out;
}

.s-hero__social-icons a:hover svg,
.s-hero__social-icons a:focus svg {
    -webkit-transform: scale(1);
    transform: scale(1);
}


效果图8：


功能描述：导航箭头样式
对应代码：
.s-hero__nav-arrows {
    z-index: 2;
    display: -ms-flexbox;
    display: -webkit-box;
    display: flex;
    position: absolute;
    right: 0;
    bottom: 0;
}

.s-hero__nav-arrows button {
    height: var(--vspace-1_75);
    width: var(--vspace-2);
    background-color: white;
    border-color: white;
    padding: 0;
    margin: 0;
    display: -ms-flexbox;
    display: -webkit-box;
    display: flex;
    -ms-flex-align: center;
    -webkit-box-align: center;
    align-items: center;
    -ms-flex-pack: center;
    -webkit-box-pack: center;
    justify-content: center;
}

.s-hero__nav-arrows button svg {
    height: 1.5rem;
    width: 1.5rem;
}

.s-hero__nav-arrows button svg path {
    fill: black;
}

.s-hero__nav-arrows button:hover,
.s-hero__nav-arrows button:focus {
    background-color: black;
    border-color: black;
}

.s-hero__nav-arrows button:hover svg path,
.s-hero__nav-arrows button:focus svg path {
    fill: white;
}




效果图9：

功能描述：回到顶部按钮样式
对应代码：
.ss-go-top {
    z-index: 2;
    opacity: 0;
    visibility: hidden;
    -webkit-transform: translate3d(0, 200%, 0);
    transform: translate3d(0, 200%, 0);
    -webkit-transition: all 0.5s cubic-bezier(0.215, 0.61, 0.355, 1);
    transition: all 0.5s cubic-bezier(0.215, 0.61, 0.355, 1);
    position: fixed;
    bottom: 7.2rem;
    right: 4rem;
}

.ss-go-top a {
    display: -ms-flexbox;
    display: -webkit-box;
    display: flex;
    -ms-flex-align: center;
    -webkit-box-align: center;
    align-items: center;
    -ms-flex-pack: center;
    -webkit-box-pack: center;
    justify-content: center;
    text-decoration: none;
    border: none;
    height: 6.4rem;
    width: 6.4rem;
    border-radius: 50%;
    background-color: var(--color-gray-2);
    -webkit-transition: all .3s;
    transition: all .3s;
    position: relative;
}

.ss-go-top a:hover, .ss-go-top a:focus {
    background-color: black;
}

.ss-go-top a:hover svg path, .ss-go-top a:focus svg path {
    fill: white;
}

.ss-go-top svg {
    height: 1.2rem;
    width: 1.2rem;
}

.ss-go-top svg path {
    fill: black;
}

.ss-go-top.link-is-visible {
    opacity: 1;
    visibility: visible;
    -webkit-transform: translate3d(0, 0, 0);
    transform: translate3d(0, 0, 0);
}



效果图10：


功能描述：翻转效果样式
对应代码：
.container .cover {
  position: absolute;
  top: 0;
  left: 50%;
  height: 100%;
  width: 50%;
  z-index: 98;
  transition: all 1s ease;
  transform-origin: left;
  transform-style: preserve-3d;
}

.container #flip:checked ~ .cover {
  transform: rotateY(-180deg);
}


效果图11：

功能描述：背景图及文字翻转效果样式
对应代码：
.container .cover img {
  position: absolute;
  height: 100%;
  width: 100%;
  object-fit: cover;
  z-index: 10;
}

.container .cover .text {
  position: absolute;
  z-index: 130;
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.cover .text .text-1,
.cover .text .text-2 {
  font-size: 26px;
  font-weight: 600;
  color: #fff;
  text-align: center;
}
















效果图12：


功能描述：表单部分样式
对应代码：
.forms .form-content .title {
  position: relative;
  font-size: 24px;
  font-weight: 500;
  color: black;
}

.forms .form-content .title:before {
  content: '';
  position: absolute;
  left: 0;
  bottom: 0;
  height: 3px;
  width: 25px;
  background: #258125;
}










效果图13：

功能描述：输入框及按钮样式
对应代码：
.form-content .input-box input {
  height: 100%;
  width: 100%;
  outline: none;
  border: none;
  padding: 0 30px;
  font-size: 16px;
  font-weight: 500;
  border-bottom: 2px solid rgba(0,0,0,0.2);
  transition: all 0.3s ease;
}

.form-content .input-box input:focus,
.form-content .input-box input:valid {
  background: #fff;
}

.form-content .button input {
  color: #fff;
  background: #4EB54E;
  border-radius: 6px;
  padding: 0;
  cursor: pointer;
  transition: all 0.4s ease;
}

.form-content .button input:hover {
  background: #4EB54E;
}

效果图14：


描述功能：电子邮箱订阅框

代码：


15.效果图：

功能描述：类选择器定义了 按钮的背景图和背景位置。实现分享功能
代码：















16.效果图：

实现功能：人气榜单

代码：


17.效果图：


实现功能：实现文章创作者布局

代码：


18、效果图：

实现功能：
使用markdown插件实现文章编辑功能
代码：
/@font-face{
   font-family:FontAwesome;
   src:url(../fonts/fontawesome-webfont.eot?v=4.3.0);
   src:url(../fonts/fontawesome-webfont.eot?#iefix&v=4.3.0)
   format("embedded-opentype"),
   url(../fonts/fontawesome-webfont.woff2?v=4.3.0)
   format("woff2"),
   url(../fonts/fontawesome-webfont.woff?v=4.3.0)
   format("woff"),
   url(../fonts/fontawesome-webfont.ttf?v=4.3.0)
   format("truetype"),
   url(../fonts/fontawesome-webfont.svg?v=4.3.0#fontawesomeregular)
   format("svg");
   font-weight:400;font-style:normal
}
.fa{
   font:normal normal normal 14px/1 FontAwesome;
   font-size:inherit;text-rendering:auto;
   -webkit-font-smoothing:antialiased;
   -moz-osx-font-smoothing:grayscale;
   transform:translate(0,0)
}
.fa-lg{
   font-size:1.33333333em;
   line-height:.75em;
   vertical-align:-15%
}
.fa-2x{
   font-size:2em
}
.fa-3x{
   font-size:3em
}
.fa-4x{
   font-size:4em
}
.fa-5x{
   font-size:5em
}
.fa-fw{
   width:1.28571429em
}
.fa-ul{
   padding-left:0;
   margin-left:2.14285714em
}
.fa-ul>li{
   position:relative
}
.fa-li{
   position:absolute;
   left:-2.14285714em;
   width:2.14285714em;
   top:.14285714em
}
.fa-li.fa-lg{
   left:-1.85714286em
}
.fa-border{
   padding:.2em .25em .15em;
   border:.08em solid #eee;
   border-radius:.1em
}
.pull-right{
   float:right
}
.pull-left{
   float:left
}
.fa.pull-left{
   margin-right:.3em
}
.fa.pull-right{
   margin-left:.3em
}
.fa-spin{
   -webkit-animation:fa-spin 2s infinite linear;
   animation:fa-spin 2s infinite linear
}
.fa-pulse{
   -webkit-animation:fa-spin 1s infinite steps(8);
   animation:fa-spin 1s infinite steps(8)
}@-webkit-keyframes fa-spin{
    0%{
        -webkit-transform:rotate(0);
        transform:rotate(0)
    }100%{
              -webkit-transform:rotate(359deg);
              transform:rotate(359deg)}
}
@keyframes fa-spin{
   0%{
       -webkit-transform:rotate(0);
       transform:rotate(0)
   }100%{-webkit-transform:rotate(359deg);
            transform:rotate(359deg)}
}
.fa-rotate-90{
   filter:progid:DXImageTransform.Microsoft.BasicImage(rotation=1);
   -webkit-transform:rotate(90deg);-ms-transform:rotate(90deg);
   transform:rotate(90deg)
}
.fa-rotate-180{
   filter:progid:DXImageTransform.Microsoft.BasicImage(rotation=2);
   -webkit-transform:rotate(180deg);
   -ms-transform:rotate(180deg);
   transform:rotate(180deg)
}
.fa-rotate-270{
   filter:progid:DXImageTransform.Microsoft.BasicImage(rotation=3);
   -webkit-transform:rotate(270deg);
   -ms-transform:rotate(270deg);
   transform:rotate(270deg)
}
.fa-flip-horizontal{
   filter:progid:DXImageTransform.Microsoft.BasicImage(rotation=0, mirror=1);
   -webkit-transform:scale(-1,1);-ms-transform:scale(-1,1);
   transform:scale(-1,1)
}
.fa-flip-vertical{
   filter:progid:DXImageTransform.Microsoft.BasicImage(rotation=2, mirror=1);
   -webkit-transform:scale(1,-1);
   -ms-transform:scale(1,-1);
   transform:scale(1,-1)
}
:root .fa-flip-horizontal,:root .fa-flip-vertical,:root .fa-rotate-180,:root .fa-rotate-270,:root .fa-rotate-90{
   filter:none
}
.fa-stack{
   position:relative;
   width:2em;
   height:2em;
   line-height:2em;
   vertical-align:middle
}
.fa-stack-1x,.fa-stack-2x{
   position:absolute;
   left:0;
   width:100%;
   text-align:center
}
.fa-stack-1x{
   line-height:inherit
}
.fa-stack-2x{
   font-size:2em
}
.fa-inverse{
   color:#fff
}
.fa-glass:before{
   content:"\f000"
}
.fa-music:before{
   content:"\f001"
}
.fa-search:before{
   content:"\f002"
}
.fa-envelope-o:before{
   content:"\f003"
}
.fa-heart:before{
   content:"\f004"
}
.fa-star:before{
   content:"\f005"
}
.fa-star-o:before{
   content:"\f006"
}
.fa-user:before{
   content:"\f007"
}
.fa-film:before{
   content:"\f008"
}
.fa-th-large:before{
   content:"\f009"
}
.fa-th:before{
   content:"\f00a"
}
.fa-th-list:before{
   content:"\f00b"
}
.fa-check:before{
   content:"\f00c"
}
.fa-close:before,.fa-remove:before,.fa-times:before{
   content:"\f00d"
}
.fa-search-plus:before{
   content:"\f00e"
}
.fa-search-minus:before{
   content:"\f010"
}
.fa-power-off:before{
   content:"\f011"
}
.fa-signal:before{
   content:"\f012"
}
.fa-cog:before,.fa-gear:before{
   content:"\f013"
}
.fa-trash-o:before{
   content:"\f014"
}
.fa-home:before{
   content:"\f015"
}
.fa-file-o:before{
   content:"\f016"
}
.fa-clock-o:before{
   content:"\f017"
}
.fa-road:before{
   content:"\f018"
}
.fa-download:before{
   content:"\f019"
}
.fa-arrow-circle-o-down:before{
   content:"\f01a"
}
.fa-arrow-circle-o-up:before{
   content:"\f01b"
}
.fa-inbox:before{
   content:"\f01c"
}
.fa-play-circle-o:before{
   content:"\f01d"
}
.fa-repeat:before,.fa-rotate-right:before{
   content:"\f01e"
}
.fa-refresh:before{
   content:"\f021"
}
.fa-list-alt:before{
   content:"\f022"
}
.fa-lock:before{
   content:"\f023"
}
.fa-flag:before{
   content:"\f024"
}
.fa-headphones:before{
   content:"\f025"
}
.fa-volume-off:before{
   content:"\f026"
}
.fa-volume-down:before{
   content:"\f027"
}
.fa-volume-up:before{
   content:"\f028"
}
.fa-qrcode:before{
    content:"\f029"
}
.fa-barcode:before{
   content:"\f02a"
}
.fa-tag:before{
   content:"\f02b"
}
.fa-tags:before{
   content:"\f02c"
}
.fa-book:before{
   content:"\f02d"
}
.fa-bookmark:before{
   content:"\f02e"
}
.fa-print:before{
   content:"\f02f"
}
.fa-camera:before{
   content:"\f030"
}
.fa-font:before{
   content:"\f031"
}
.fa-bold:before{
   content:"\f032"
}
.fa-italic:before{
   content:"\f033"
}
.fa-text-height:before{
   content:"\f034"
}
.fa-text-width:before{
   content:"\f035"
}
.fa-align-left:before{
   content:"\f036"
}
.fa-align-center:before{
   content:"\f037"
}
.fa-align-right:before{
   content:"\f038"
}
.fa-align-justify:before{
   content:"\f039"
}
.fa-list:before{
   content:"\f03a"
}
.fa-dedent:before,.fa-outdent:before{
   content:"\f03b"
}
.fa-indent:before{
   content:"\f03c"
}
.fa-video-camera:before{
   content:"\f03d"
}
.fa-image:before,.fa-photo:before,.fa-picture-o:before{
   content:"\f03e"
}
.fa-pencil:before{
   content:"\f040"
}
.fa-map-marker:before{
   content:"\f041"
}
.fa-adjust:before{
   content:"\f042"
}
.fa-tint:before{
   content:"\f043"
}
.fa-edit:before,.fa-pencil-square-o:before{
   content:"\f044"
}
.fa-share-square-o:before{
   content:"\f045"
}
.fa-check-square-o:before{
   content:"\f046"
}
.fa-arrows:before{
   content:"\f047"
}
.fa-step-backward:before{
   content:"\f048"
}
.fa-fast-backward:before{
   content:"\f049"
}
.fa-backward:before{
   content:"\f04a"
}
.fa-play:before{
   content:"\f04b"
}
.fa-pause:before{
   content:"\f04c"
}
.fa-stop:before{
   content:"\f04d"
}
.fa-forward:before{
   content:"\f04e"
}
.fa-fast-forward:before{
   content:"\f050"
}
.fa-step-forward:before{
   content:"\f051"
}
.fa-eject:before{
   content:"\f052"
}
.fa-chevron-left:before{
   content:"\f053"
}
.fa-chevron-right:before{
   content:"\f054"
}

20、效果图：

实现功能：评论区
代码：
<div class="comment-section" style="display: none">
<div class="leave-comment">
 <img src="./apple-touch-icon.png" class="avatar2">
 <input type="text" class="comment-box" placeholder="发表一条评论吧">
 <button class="publish">发布</button>
</div>
<div class="public-comment">
   <div>
      <div style="border-bottom: 1px solid #ebeced; padding-bottom: 10px">
         <h6><span>1</span>条评论 </h6><br>
      </div>
      <div style="margin-right: 500px">
         <img src="./apple-touch-icon.png" class="avatar2" style="">
         <span style="margin-left: 10px;font-weight: bold " class="nickname">昵称</span>
      </div>

      <div style="margin-left: 60px">
         <span id="pub-com" style="font-size: 15px">什么时候才能完成？</span><br>
         <span class="comment-date">2024-01-05</span>
         <button class="reply">&#x1F4AC;回复</button>
      </div>

   </div>
</div>
</div>
.publish {
   position: absolute;
   width: 80px;
   height: 45px;
   background-color: #e7f1fe;
   border: none;
   border-radius: 5px;
   color: #1772f6;
   text-align: center;
   line-height: 45px;
   top: 9%;
   right: 2%;
   margin: 0;
   padding: 0;
}
.public-comment {
   border: 1px solid #ebeced;
   border-radius: 5px;
   position: relative;
}
.public-comment h6 {
   float: left;
   margin: 10px 550px 10px 10px;
   font-weight: bold;
}
.public-comment img {
   margin-left: 10px;
   width: 36px;
   height: 36px;
   margin-top: 10px;
}
.nickname {
   position: absolute;
   top: 35%;
}
#pub-com {
   position: absolute;
   top: 55%;
}
.comment-date {
   font-size: 15px;
   color: #8491a5;
}
.reply {
   padding: 0;
   /*margin: 0;*/
   float: right;
   margin-right: 10px;
   background-color: transparent;
   color: #8491a5;
   border: none;
   position: absolute;
   top: 71%;
   right: 15%;
}
.reply:hover {
   background-color: transparent;
   color: #8491a5;
}
.reply:not(:hover) {
   background-color: transparent;
   color: #8491a5;
}

21、效果图：

实现功能：头像更换
代码：
.avatar {
   width: 250px;
   height: 250px;
   border: 2px solid white;
   border-radius: 5px;
   background-color: #eff0f0;
    /*margin-left: 200px;*/
   float: right;
   margin-right: 300px;
   margin-top: 80px;
   border-radius: 50%;
   border: 1px #e5e9ef solid;
   background-color: transparent;
   position: relative;
}
#avatarImg {
   width: 160px;
   height: 160px;
   border: 2px solid white;
   border-radius: 5px;
   background-color: #eff0f0;
   /*margin: 10px;*/
   /*margin-left: 200px;*/
   /*float: right;*/
   /*margin-right: 300px;*/
   /*margin-top: 80px;*/
   border-radius: 50%;
   position: absolute; /* 设置绝对定位 */
   top: 50%; /* 将上边缘定位到父元素的50%高度处 */
   left: 50%; /* 将左边缘定位到父元素的50%宽度处 */
   transform: translate(-50%, -50%);
}

22、效果图：


实现功能：文章评论区
代码：





3.js对DOM元素的增删改查\事件绑定等（30分）
3.1使用selectQuery系列和getElement系列方法进行查找
3.1.1selectQuery系列方法

1.板块截图


实现功能：文章点赞功能。
代码截图：




2.板块截图

实现功能
代码截图：

3、板块截图



实现功能：个人资料的修改与保存
代码截图



4.板块截图：

实现：文章布局显示效果
代码截图：

5.板块截图

实现功能：搜索查询所有文章
代码截图

3.1.2 getElement系列方法
使用板块截图1：


功能描述：导航跳转问题以及隐藏其他问题
对应代码：

2.板块截图

实现功能：验证码输入验证
代码截图：

3.板块截图：

功能实现：获取板块布局
代码截图：

3.2使用属性的设置和读取方法，getAttribute和setAttribute方法
板块截图1：


实现功能：实现自动完成功能，即不会显示以前键入过的搜索建议。
代码截图：

板块截图2：


实现功能：点击搜索栏显示搜索提示。
代码截图：


3.3 使用节点的添加和删除方法，createElement和removeChild方法
3.3.1createElement方法：
1.板块截图：

实现功能：能够实现复制当前网页链接
代码截图：


2.板块截图


实现功能：生成的留言进行样式处理，li

代码截图：

3.3.2removeChild
1.板块截图


实现功能：复制成功后input消失
代码截图：


2.板块截图

实现功能：切换回复的显示。它会移除父元素中的最新回复。
代码截图：


3.4 使用节点的克隆方法cloneNode方法
暂无实现

3.5事件绑定

板块截图1：


功能实现：点击图标显示二维码，离开之后二维码消失
代码截图：

板块2截图：

实现功能：获取用户输入的名字，并将用户名设置到相应的DOM元素中，以此表示登录成功
代码截图：

板块截图3：

实现功能：初始化评论区的显示。
代码截图：





















板块截图4：




实现功能：
1.获取评论文本内容和评论者的信息；
2.判断评论文本内容和评论者是否为空，如果为空则弹出提示；
3.判断评论者是否为匿名用户，如果是则弹出提示

代码截图：


板块5截图：


实现功能：当取消回复按钮被点击时，隐藏回复按钮本身，清空评论输入框的内容。
代码截图：

板块6截图：

实现功能：计算评论输入框内容的长度，并将长度显示在页面上。
代码截图：

板块7截图：


实现功能：当评论输入框触发按键事件时，根据输入框内容的长度计算剩余字符数，并根据输入框内容是否为空来处理取消回复按钮的显示状态。
代码截图：

板块8截图：


实现功能：根据传入的状态值来设置取消回复按钮的显示状态。
代码截图：

板块8截图：


实现功能：点赞，取消点赞
代码截图：


9.板块截图；


功能实现：实现回复功能
代码截图：


10.板块截图；


功能实现：查看回复信息，收起回复
代码截图：

4.表单验证 （10分）
板块截图1：


功能描述：实行联系页面
代码截图：

板块截图2：


功能描述：实行登录，注册验证
代码截图：

5.AJAX通信和数据解析（30分）
使用板块截图1：


功能描述：发布文章

对应代码：



使用板块截图2：


功能描述：返回响应执行回调时，解析响应的文章列表数据
对应代码：

板块截图3：

实现功能：实现点赞数量显示与增加
代码截图：




4.板块截图；



功能实现：登录成功回显名字
代码截图：


5板块截图：


功能实现：作者页面显示
代码截图：
  let id = window.location.search.substring(4);
  function onloadMyHome(){
    let authorName = document.querySelector(".authorName");
    let avatar = document.getElementById("avatarImg");
    let essay = document.querySelector(".essay");
    let bio = document.querySelector(".a1");
    ajax({
      method: "Get",
      url: "blog_myList?id="+id,
      callback: function(status,responseText){
        if(status == 200){
          let json = JSON.parse(responseText);
          if(json.ok){
            let data = json.data;
            let articles = data.articles;
            let user = data.user;

            authorName.innerText = user.username;
            if(user.avatar!=null){
              avatar.src = user.avatar;
            }
            //str不赋值就是undefined，再去拼接字符串就会出错
            let str = "";
            for(let a of articles){
              //``里面可以包括单引号和双引号
              str += `<div class="title">`;
              str += a.title;
              str += `<span class="date">`;
              str += a.dateString;
              str += `</span></div>`;
              //str += `<img src="./apple-touch-icon.png" class="avatar2">`;
              str += `<div class="desc">`;
              str += `<span>`;
              str += a.content;
              str += `</span>`
              str += `</p>`;
              // str += `<a href="essay.html"><button class="read-all">&#9660;阅读全文</button></a><br>`;
              str += `<a href="essay.html?id=` +a.id;
              str += `"><button class="read-all">&#9660;阅读全文</button></a><br>`;
              str += `</div>`
              str += `<div class="btn-all"><button class="approve">&#x1F60D;喜欢<span>`;
              str += a.likeCount;
              str += `</span></button>`;
              str += `<button class="add-comment" onclick="appearComments()">&#x1F4AC;添加评论<span>0</span></button><button class="cancle-comment" onclick="collapseComments()"
								    style=display: none">&#x1F4AC;收起评论</button>`;
              // str += `<a href="blog_edit.html?id=`+a.id;
              // str += `"><button class="shares">&#x270E;编辑</button></a>`
              // str += `<button class="favorite" onclick=DeleteArticle(`;
              // str += a.id
              // str += `)>&#x1F6AE;删除</button>`;
              str += `</div>`;
            }
            essay.innerHTML = str;
            bio.innerText = user.biography;
          }else {
            alert("ok==false");
          }
        }else {
          alert("响应状态码："+status+"/nbody："+responseText)
        }
      }
    });
  }
6.板块截图：

功能实现：删除文章
代码截图：

7.板块截图：


功能实现：显示所有文章
代码截图：

8.板块截图：


功能实现：搜索跳出需要的页面
代码截图：

9.板块截图：

实现功能：发布文章
代码截图：

10.板块截图

实现功能：头像和名字回显
代码截图：

11.板块截图：


实现功能：文章具体内容显示
代码截图：

12.板块截图：

实现功能：提交登录验证
代码截图：

13.板块截图

实现功能：注册验证
代码截图


14.板块截图

实现功能：注册验证防止重复内容
代码截图：
 
15.板块截图


实现功能：个人基本内容显示
代码截图：


16.板块截图


实现功能：保存更改
代码截图：

17.板块截图

实现功能：修改密码
代码截图：

18.板块截图

  实现功能：更换头像
  代码截图：


19.板块截图

  实现功能：注销用户
  代码截图：


