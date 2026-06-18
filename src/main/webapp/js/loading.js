  // 当页面开始加载时显示加载页面
  window.addEventListener('load', function() {
    var overlay = document.getElementById('modal-overlay');
    overlay.style.display = 'flex'; // 或者使用 'block'，取决于您的 CSS 设置
  });
  
  // 当页面加载完成后隐藏加载页面
  window.addEventListener('DOMContentLoaded', function() {
    var overlay = document.getElementById('modal-overlay');
    overlay.style.display = 'none';
  });