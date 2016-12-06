<<<<<<< HEAD
﻿# OrderApp
=======
# OrderApp
>>>>>>> ef178b27ab9837bec2aab6ff8c883edc3b02fb5c
项目部署
</br>团队仓库目录结构
</br>WeAreElder
</br>OrderApp
</br>configs
</br>dbscripts
</br>docs
</br>src
</br>下面一一说一下这些目录的作用：

</br>WeAreElder
</br>团队/组织名，可以自定义，最好用英文。

</br>OrderApp
</br>团队要做的项目名称，可以自定义，最好用英文。

</br>configs
</br>在开发的时候，项目是部署在开发环境中的，所以项目中的一些配置文件，比如：数据库连接配置文件，都是用的开发环境的数据库连接配置，项目要部署上线的时候，我们需要把开发环境的数据库连接配置替换成生产环境的数据库连接配置，所以这个目录可以用来存生产环境的相关配置文件。

之所以将测试环境/开发环境/生产环境分开是因为开发过程中，需要对数据库中的一些数据进行测试或者修改，如果不和生产环境分开，会“污染”生产环境的数据。

</br>dbscripts
</br>在开发过程中，每次开发过程中涉及到要执行一些脚本，比如：开发过程中，要新建一个表，建表语句就要保存在这个目录里面，待开发完毕上线的时候，就需要在生产环境中执行这个建表语句。

</br>docs
</br>这里存放项目的相关文档，比如：需求说明书，会议纪要，上线手册等。

</br>src
</br>这里存放项目源码。



一、项目需求确定

当前餐厅存在的问题：  当前餐厅中的大多数环节都是有服务员跑动来完成的，这样会造成餐厅使用的劳动力过 多，比较费时、费力，而运营效率低下。  
导致效率低下的原因主要有：
1. 服务员跑动太多浪费时间。例如，服务员将订单送到厨房部的过程中消耗过多时间，从而不能及时接待新进入的顾客，从而影响顾客就餐，影响顾客的回头率。  
2. 菜谱是之前打印好的，不能及时的更新菜谱，顾客看到的不是最新的菜谱。 
3. 信息的传递都是人工，费时、费力，效率低下。

开发app点餐系统

1. 将传统的人工转为使用餐厅点餐系统，系统可以为顾客提供以下服务：座位的选择、 浏览最新菜谱、自助点菜(下单)、进行催单、查询订单的排队情况以及结账申请  
2. 将信息的传递由传统的人工方式改为由信号传递，菜谱用电子设备显示可以及时的 更新最新的菜谱显示给顾客。将顾客与餐厅之间的信息传递智能化，顾客的要求可以直接传达到餐厅的各部，使服务员由足够多的时间去处理别的事情。
 二、项目功能确定

本系统的主要功能分为：餐厅前台端系统（客户端）、服务器后台端系统（服务端）。 
以下分别对各个端的系统功能做一个功能概述。  
餐厅前台端系统：  
1. 从服务端获取最新的菜谱；  
2. 在本地系统中进行点单，并将订单传送到服务器后台系统； 
3. 催单，向服务器后台端系统发送信息，要求系统尽快处理本订单； 
4. 结账，向服务器后台端系统发送结账请求。   

服务器后台端系统：  
1. 更新本地系统中的菜谱信息； 
2. 接收订单，并保存订单信息； 
3. 将订单传送到厨房端系统； 
4. 对催单请求进行处理；  
5. 对订单进行结账处理，并将信息反馈到餐厅前台端系统； 
6. 管理当前系统中等待厨房处理的订单队列； 
7. 处理订单信息队列；  
8. 将已处理的订单进行处理（写入数据库），以便日后做账；



