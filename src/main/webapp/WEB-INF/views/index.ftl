<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>炼人运营系统</title>
    <link rel="stylesheet" type="text/css" href="/static/css/common/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <link rel="stylesheet" type="text/css" href="/static/css/louis.css">
    <script Language="JavaScript" src="/static/js/common/jquery-2.1.4.js"></script>
    <script Language="JavaScript" src="/static/js/common/bootstrap.js"></script>
    <script Language="JavaScript" src="/static/js/common/jquery.cookie.js"></script>
    <script Language="JavaScript" src="/static/js/common/md5.js"></script>
    <script Language="JavaScript" src="/static/js/common.js"></script>
    <script Language="JavaScript" src="/static/js/index.js"></script>
</head>
<body>
<div class="col-md-12 nav_head">
    <div>
        <div class="exit_system float_r">
            你好，<span id="username">${(username)!'未知用户'}</span>
            <a href="javascript:void(0)" id="logout">退出</a>
            <a href="javascript:void(0)" id="update_password">修改密码</a>
            <a href="javascript:void(0)" id="reset_password">重置密码</a>
        </div>
        <#--<img src="/static/images/logo1.png" width="230" /><!--<small>运营管理系统</small>&ndash;&gt;-->
    </div>
</div>
<div class="col-md-2 nav_left">
    <ul class="nav_ul">
        <li><a href="welcome" target="content">课程类目列表</a></li>
        <li><a href="welcome" target="content">课程类目列表</a></li>
        <!--<ul class="nav_ul">
          <li><a href="html/categories_list.html" target="content">课程类目列表</a></li>
          <li><a href="html/class_list.html" target="content">科目列表</a></li>
          <ul class="nav_ul">
            <li><a href="html/baidu.html" target="content">百度</a></li>
            <li><a href="html/qq.html" target="content">腾讯</a></li>
            <li><a href="html/baidu.html" target="content">阿里巴巴</a></li>
            <li><a href="html/qq.html" target="content">腾讯</a></li>
          </ul>
          <li><a href="html/baidu.html" target="content">阿里巴巴</a></li>
          <li><a href="html/qq.html" target="content">腾讯</a></li>
        </ul>-->
    </ul>
</div>
<div class="col-md-10 nav_right">
    <iframe name="content" class="content" id="content" src="welcome" frameborder="no" marginwidth="0" marginheight="0" scrolling="yes"></iframe>
</div>
<div id="update_password_div" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <div class="row">
                    <div class="col-sm-12">修改密码</div>
                </div>
            </div>
            <div class="modal-body">
                <div class="row" style="margin-top: 8px;">
                    <div class="col-md-3 span_title">
                        <span>原有密码</span>
                    </div>
                    <div class="col-md-8">
                        <input type="password" class="form-control date-picker" name="old_password" value=""
                               placeholder="请输入原有密码" style="width: 50%;display: inline-block"/>
                    </div>
                </div>
                <div class="row" style="margin-top: 8px;">
                    <div class="col-md-3 span_title">
                        <span>新密码</span>
                    </div>
                    <div class="col-md-8">
                        <input type="password" class="form-control date-picker" name="new_password" value=""
                               placeholder="请输入新密码" style="width: 50%;display: inline-block"/>
                    </div>
                </div>
                <div class="row" style="margin-top: 8px;">
                    <div class="col-md-3 span_title">
                        <span>重复新密码</span>
                    </div>
                    <div class="col-md-8">
                        <input type="password" class="form-control date-picker" name="new_password2" value=""
                               placeholder="请重复输入新密码" style="width: 50%;display: inline-block"/>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" name="btn_update_password" isAdd="true">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div><!-- /.modal -->
<div class="col-md-12 nav_footer">
    <div>
        <strong>炼 人 </strong><small>运营管理系统</small>
    </div>
</div>
<!--<div class="modal-backdrop fade in"></div>-->
</body>
</html>
