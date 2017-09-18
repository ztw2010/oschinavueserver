# vue oschina服务端



----------
**项目意义：**<br>前端项目([https://github.com/ztw2010/weex-oschina](https://github.com/ztw2010/weex-oschina))利用oschina开源API([http://www.oschina.net/openapi](http://www.oschina.net/openapi))通过OAuth2协议去获取AccessToken时牵涉到跨域的问题，因此需要自己搭建后台出处理跨域相关的问题。<br>

**将项目部署到Heroku免费空间：**<br>
Java免费的虚拟空间真心不多，自己接触了OpenShift([https://www.openshift.com/](https://www.openshift.com/))和Heroku([https://www.heroku.com/](https://www.heroku.com/))，最终选择了Heroku作为后台环境：<br>
1. OpenShift注册后审核时间比较长，Heroku注册完成即可使用。<br>
2. OpenShift部署Javaweb工程比价麻烦(个人觉得)而Heroku只需要关联到GitHub地址即可以在你提交代码到GitHub时由Heroku自动进行构建。<br>

**Heroku部署Javaweb教程**：<br>
  
1. 注册Heroku账户，地址https://www.heroku.com/ <br>
2. 创建一个Javaweb APP <br> ![image](https://github.com/ztw2010/oschinavueserver/raw/master/pic/create_app.png)
3. 将GitHub仓库地址与Heroku进行关联<br> ![image](https://github.com/ztw2010/oschinavueserver/raw/master/pic/create_app_2.png)
4. 对Heroku进行配置<br>![image](https://github.com/ztw2010/oschinavueserver/raw/master/pic/create_app_3.png)<br>

**Heroku相关API如下：**