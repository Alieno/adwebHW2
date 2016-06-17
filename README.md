# adwebHW2

作者：李恒昱 13302010025

#1. 项目概述
作者在没有图形学基础上完成本作业，旨在试探3D图形特性：即新的API类 Shape3D、SubScene、Material、PickResult、LightBase和SceneAntialiasing等。
项目为一个3D的方块矩阵，显示作者的名字。用户可以通过操作相机从全角度观察3D图形，并且有互动按键出发矩阵的变换。

#2. 环境搭建
使用了eclipse开发Java程序。
打开eclipse，选择Help->Install New Software...。Name填e(fx)clipse,Location为http://download.eclipse.org/efxclipse/updates-released/2.3.0/site 然后完成安装并重启eclipse(下载过程需翻墙)。

#3. 功能介绍
运行程序
界面显示由3D方块组成的矩阵，白色方块构成ALIENO字样。
鼠标操作：用户可通过鼠标拖动界面绕中心旋转图形。
键盘操作：W/S/A/D分别控制相机上、下、左、右移动，E键放大，Q键缩小，R键重置图形，T键可转换图形组成文字，触发后由ALIENO变为JANINE。

