(function($){
	var formVerify = {
		init : function(){
			return (function(){

			})();
		},
		/*友情提示*/
		showPass : function(){
			$("#"+id+"Msg").html('<i class="ico ico_s14 ico3"></i>'+msg);
			$("#"+id+"Msg").css("display","block");
		},
		/*错误提示*/
		showErr : function(){
			$("#"+id+"Msg").html('<i class="ico ico_s14 ico3"></i>'+msg);
			$("#"+id+"Msg").css("display","block");
		},
		/*通过提示*/
		showPass : function(){
			$("#"+id+"Msg").html('<i class="ico ico_s14 ico3"></i>'+msg);
			$("#"+id+"Msg").css("display","block");
		},
		/*手机号码验证*/
		phone : function(){
			return (function(){
				//取得输入用户名的值
				var mobileVal = $("#mobile").val();
				if(mobileVal == ''){//手机号为空
					mobileFlag = false;
					showErr("mobile","手机号码不能为空");
				}else if(mobileVal.length != 11){//密码长度为6~20位字符
					repwdFlag = false;
					showErr("mobile","请输入11位手机号码");
				}else if(!mobileVal.match("^((13[0-9])|(14[5|7])|(15[0|1|2|3|5|6|7|8|9])|(17[6|7|8])|18[0-9])\\d{8}|(170[0|5|9]\\d{7})$")){//手机号码格式错误
					mobileFlag = false;
					showErr("mobile","手机号码格式错误");
				}else{//以上验证通过
					mobileFlag = true;
					validatePass("mobile");
				}
			})();
		},
		chianName : function(){
			return (function(){

			})();
		}
	}
})();