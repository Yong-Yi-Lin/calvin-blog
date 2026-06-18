<?php
// 启动会话
session_start();

// 设置图像大小
$width = 120;
$height = 40;

// 创建图像资源
$image = imagecreatetruecolor($width, $height);

// 设置背景色
$bgColor = imagecolorallocate($image, 255, 255, 255);
imagefill($image, 0, 0, $bgColor);

// 生成随机验证码
$characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
$length = 6;
$randomString = '';
for ($i = 0; $i < $length; $i++) {
    $randomString .= $characters[rand(0, strlen($characters) - 1)];
}

// 将验证码存储在会话中，以供验证
$_SESSION['captcha'] = $randomString;

// 将验证码绘制到图像上
$textColor = imagecolorallocate($image, 0, 0, 0);
imagettftext($image, 20, 0, 10, 30, $textColor, 'path/to/your/font.ttf', $randomString);

// 设置内容类型为图像
header('Content-type: image/png');

// 输出图像
imagepng($image);

// 销毁图像资源
imagedestroy($image);
?>
