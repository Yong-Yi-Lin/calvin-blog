// <script>
//      // 用于处理评论和交互的JavaScript代码

//     /* 添加新评论的函数*/
//     function addComment(author, date, text) {
//         // 创建新的评论HTML并将其附加到评论列表
//         const commentList = document.getElementById("commentList");
//         const newComment = document.createElement("li");
//         newComment.innerHTML = `
//             <div class="comment__avatar">
//                 <img class="avatar" src="images/avatars/user-default.jpg" alt="" width="50" height="50">
//             </div>
//             <div class="comment__content">
//                 <div class="comment__info">
//                     <div class="comment__author">${author}</div>
//                     <div class="comment__meta">
//                         <div class="comment__time">${date}</div>
//                         <div class="comment__reply">
//                             <a class="comment-reply-link" href="#0" onclick="replyToComment('${author}')">回复</a>
//                         </div>
//                     </div>
//                 </div>
//                 <div class="comment__text">
//                     <p>${text}</p>
//                 </div>
//             </div>
//         `;
//         commentList.appendChild(newComment);
//     }

//     // 处理提交新评论的函数
//     function submitComment() {
//         const author = document.getElementById("cName").value;
//         const text = document.getElementById("cMessage").value;
//         const date = getCurrentDate(); // 您可以使用Moment.js等库进行更好的日期格式化

//         // 将新评论添加到评论列表
//         addComment(author, date, text);

//         // 清除表单字段
//         document.getElementById("cName").value = "";
//         document.getElementById("cMessage").value = "";
//     }

//     // 处理回复的函数
//     function replyToComment(parentAuthor) {
//         // 在这里实现回复功能
//         // 您可以打开一个模态框或动态显示/隐藏用于回复特定评论的表单
//     }

//     // 提交按钮的事件监听器
//     document.getElementById("submitComment").addEventListener("click", submitComment);

//     // 初始评论的示例数据
//     addComment("Habdichgerne", "2023-12-23", "视频发布开启了一种更直观、更生动的沟通方式。");
//     addComment("大不大舟", "2023-12-18", "视频发布将信息传递的范围拓展到全球。");

//     // 根据您的需求，可以添加其他函数，用于点赞、不赞同等功能

//     // 获取当前日期的函数，格式为"YYYY-MM-DD"
//     function getCurrentDate() {
//         const now = new Date();
//         const year = now.getFullYear();
//         const month = (now.getMonth() + 1).toString().padStart(2, '0');
//         const day = now.getDate().toString().padStart(2, '0');
//         return `${year}-${month}-${day}`;
//     }
// </script>