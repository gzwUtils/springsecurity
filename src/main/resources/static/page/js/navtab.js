var datalist = [{"id":"21","parentId":"0","name":"系统管理","enName":null,"url":"/static/authorization/welcome.html","requestMethod":"GET","icon":null,"access":1,"useable":1,"type":1,"remark":"权限管理","serialIndex":1,"createTime":"2017-08-10T01:10:42.000+0000","modifyTime":"2017-08-10T01:10:52.000+0000","children":[{"id":"2110","parentId":"21","name":"用户管理","enName":"1","url":"/static/authorization/user.html","requestMethod":"GET","icon":null,"access":1,"useable":1,"type":1,"remark":"权限管理","serialIndex":1,"createTime":"2017-08-10T01:10:44.000+0000","modifyTime":"2017-08-10T01:10:55.000+0000","children":null},{"id":"2120","parentId":"21","name":"角色管理","enName":"1","url":"/static/authorization/role.html","requestMethod":"GET","icon":null,"access":1,"useable":1,"type":1,"remark":"权限管理","serialIndex":2,"createTime":"2017-08-10T01:10:47.000+0000","modifyTime":"2017-08-10T01:10:57.000+0000","children":null},{"id":"2130","parentId":"21","name":"菜单管理","enName":null,"url":"/static/authorization/resource.html","requestMethod":"GET","icon":null,"access":1,"useable":1,"type":1,"remark":"权限管理","serialIndex":3,"createTime":"2017-08-10T01:10:50.000+0000","modifyTime":"2017-08-10T01:10:59.000+0000","children":null}]},{"id":"80","parentId":"0","name":"权限管理","enName":null,"url":null,"requestMethod":null,"icon":null,"access":null,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":[{"id":"8001","parentId":"80","name":"用户管理","enName":null,"url":"","requestMethod":null,"icon":null,"access":null,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":[{"id":"800101","parentId":"8001","name":"新增用户","enName":null,"url":"/security/user*","requestMethod":"POST","icon":null,"access":1,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":null},{"id":"800102","parentId":"8001","name":"修改用户","enName":null,"url":"/security/user*","requestMethod":"PUT","icon":null,"access":0,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":null},{"id":"800103","parentId":"8001","name":"删除用户","enName":null,"url":"/security/user*","requestMethod":"DELETE","icon":null,"access":0,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":null},{"id":"800104","parentId":"8001","name":"获取用户列表-分页","enName":null,"url":"/security/user/listByPage*","requestMethod":"POST","icon":null,"access":0,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":null},{"id":"800105","parentId":"8001","name":"批量删除用户信息","enName":null,"url":"/security/user/removeForBatch","requestMethod":"DELETE","icon":null,"access":0,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":null},{"id":"800106","parentId":"8001","name":"获取单个用户信息","enName":null,"url":"/security/user/*","requestMethod":"GET","icon":null,"access":0,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":null},{"id":"800107","parentId":"8001","name":"获取用户列表","enName":null,"url":"/security/user*","requestMethod":"GET","icon":null,"access":0,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":null},{"id":"800209","parentId":"8001","name":"资源授权信息更新","enName":null,"url":"/security/resource/updateResourceRole","requestMethod":"GET","icon":null,"access":0,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":null}]}]},{"id":"60","parentId":"0","name":"ETL管理","enName":null,"url":null,"requestMethod":null,"icon":null,"access":null,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":[{"id":"6002","parentId":"60","name":"作业管理","enName":null,"url":null,"requestMethod":null,"icon":null,"access":null,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":null},{"id":"6001","parentId":"60","name":"转换管理","enName":null,"url":null,"requestMethod":null,"icon":null,"access":null,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":null}]},{"id":"8002","parentId":"0","name":"菜单管理","enName":null,"url":null,"requestMethod":null,"icon":null,"access":null,"useable":1,"type":null,"remark":null,"serialIndex":null,"createTime":null,"modifyTime":null,"children":null}];
/*$(function() {
	$.ajax({
		url: 'http://192.168.100.245:10001/security/resource/tree',
		type: "get",
		success: function(data) {

			datalist = data.data;
			console.log(datalist);
			var navtab = new Vue({
				el: '#navtab',
				data: {
					treearr: datalist,
					
				},
				methods: {

				}
			})
		},

	})
});*/
	var navtab = new Vue({
				el: '#navtab',
				data: {
					treearr: datalist,
					
				},
				methods: {

				}
			})