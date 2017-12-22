/*!
 *
 *产品详情
 */

$(function(){
	function renderTmpl (tmplID, tmplDatas) {
		var _openTag = 'tmpl_',
			tmplName = _openTag + tmplID,
			tar = $('#' + tmplID);

		var tmplDatas = {
			datas: tmplDatas
		};
		tar.html(template(tmplName, tmplDatas));
	}
	var Manage = {
		//产品名称
		productName : function(){
			$.ajax({
				url:'http://139.196.90.109:8080/shijihui/cas/detail?id=421943',
				type:'get',
				data:{},
				dataType:'json',
				async : false, //默认为true 异步 
				success:function(data){
					
				},
				error:function(data){
					console.log(data)
				}					
			})
		}
	}
	Manage.productName();
})
