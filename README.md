# oschinavueserver
OSChina服务端
为了把自己学习vue.js的成果show出来，需要将server端的代码部署到公网，Java免费的虚拟空间真心不多，自己接触了OpenShift(https://www.openshift.com/)和Heroku(https://www.heroku.com/)，最终选择了Heroku作为后台环境：1、OpenShift注册后审核时间比较长，Heroku注册完成即可使用。2、OpenShift部署Javaweb工程比价麻烦(个人觉得)而Heroku只需要关联到GitHub地址即可以在你提交代码到GitHub时由Heroku自动进行构建。
Heroku部署Javaweb教程：
  1、注册Heroku账户，地址https://www.heroku.com/
  2、创建一个Javaweb APP ![image](https://github.com/ztw2010/oschinavueserver/raw/master/pic/create_app.png)