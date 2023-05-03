

//初始化商品信息
function getTGoodsList(id){
	$.post("/TGoods/findList" ,{},function(data) {
		$('#'+id).empty();
		var html="";
		html +="<option value=''>--请选择--</option>";
		$.each(data,function(i,val){
			html+="<option value='"+val.id+"'>"+val.goodsName+"</option>";
		});
		$('#'+id).append(html);
	});

}


//初始化用户信息
function getSysUserList(id){
	$.post("/SysUser/findList" ,{},function(data) {
		$('#'+id).empty();
		var html="";
		html +="<option value=''>--请选择--</option>";
		$.each(data,function(i,val){
			html+="<option value='"+val.id+"'>"+val.name+"</option>";
		});
		$('#'+id).append(html);
	});

}

//初始化仓库
function getTWarehouseList(id){
	$.post("/TWarehouse/findList" ,{},function(data) {
		$('#'+id).empty();
		var html="";
		html +="<option value=''>--请选择--</option>";
		$.each(data,function(i,val){
			html+="<option value='"+val.id+"'>"+val.warehouseName+"</option>";
		});
		$('#'+id).append(html);
	});

}

//根据数据类型初始化数据信息
function getDictDataList(id,dataType){
	$.post("/SysDictData/findList" ,{dataType:dataType,nopid:'nopid'},function(data) {
		$('#'+id).empty();
		var html="";
		html +="<option value=''>--请选择--</option>";
		$.each(data,function(i,val){
			html+="<option value='"+val.id+"'>"+val.dataName+"</option>";
		});
		$('#'+id).append(html);
	});

}


//初始部门
function getDepartmentList(id){
	$.post("/SysDepartment/findList" ,{},function(data) {
		$('#'+id).empty();
		var html="";
		html +="<option value=''>--请选择--</option>";
		$.each(data,function(i,val){
			html+="<option value='"+val.id+"'>"+val.departmentName+"</option>";
		});
		$('#'+id).append(html);
	});

}


//初始客户
function getCustomerList(id){
	$.post("/TCustomer/findList" ,{},function(data) {
		$('#'+id).empty();
		var html="";
		html +="<option value=''>--请选择--</option>";
		$.each(data,function(i,val){
			html+="<option value='"+val.id+"'>"+val.customerCompany+"</option>";
		});
		$('#'+id).append(html);
	});

}


//初始化供应商
function getTSupplierList(id){
	$.post("/TSupplier/findList" ,{},function(data) {
		$('#'+id).empty();
		var html="";
		html +="<option value=''>--请选择--</option>";
		$.each(data,function(i,val){
			html+="<option value='"+val.id+"'>"+val.suppilerCompany+"</option>";
		});
		$('#'+id).append(html);
	});

}
		
		//初始角色
		function getRoleList(id){
			$.post("/SysRole/findList" ,{},function(data) {
				$('#'+id).empty();
				var html="";
				html +="<option value=''>--请选择--</option>";
				$.each(data,function(i,val){ 
					html+="<option value='"+val.id+"'>"+val.roleName+"</option>";
				});
				$('#'+id).append(html);  
			});
			
		}


		function getTree(url,param){

			$.ajaxSettings.async = false;
			$.post(url, param ,function(data) {

				$('#treeview').treeview({
					//  color: "#428bca",
					//backColor: "black",背景色
					//borderColor:'green',
					// collapseIcon: "glyphicon glyphicon-minus",//可收缩的节点图标
					// nodeIcon: "glyphicon glyphicon-user",
					//   emptyIcon: "glyphicon glyphicon-ban-circle",//设置列表树中没有子节点的节点的图标
					//  expandIcon: "glyphicon glyphicon-plus",  //设置列表上中有子节点的图标
					highlightSearchResults:true,//是否高亮搜索结果 默认true
					highlightSelected:true,     //是否选中高亮显示
					onhoverColor: "#f5f5f5",    //鼠标滑过的颜色
					levels: 2 ,                 //设置初始化展开几级菜单 默认为2
					//    selectedIcon: 'glyphicon glyphicon-tint',
					// selectedBackColor: 'black',  //设置被选中的节点背景颜色
					//selectedColor : 'red',      //设置被选择节点的字体、图标颜色
					showBorder:true,                //是否显示边框
					showCheckbox:true,              //是否显示多选框
					//uncheckedIcon:'',             //设置未选择节点的图标
					data:data.data,
					showTags:true,//显示徽章

					onNodeChecked: function (event,node) {
						setParentNodeCheck(node)
					},
					onNodeUnchecked: function (event, node) {
						var selectNodes = getChildNodeIdArr(node); //获取所有子节点
						if (selectNodes) { //子节点不为空，则选中所有子节点
							$("#treeview").treeview('uncheckNode', [selectNodes, { silent: true }]);
						}

					}

				})
				//初始化表格数据

			});

			$.ajaxSettings.async = true;

		}


		// 选中父节点时，选中所有子节点
		function getChildNodeIdArr(node) {
			var ts = [];
			if (node.nodes) {
				for (var x in node.nodes) {
					ts.push(node.nodes[x].nodeId);
					if (node.nodes[x].nodes) {
						var getNodeDieDai = getChildNodeIdArr(node.nodes[x]);
						for (var j in getNodeDieDai) {
							ts.push(getNodeDieDai[j]);
						}
					}
				}
			} else {
				ts.push(node.nodeId);
			}
			return ts;
		}

		// 选中所有子节点时，选中父节点 取消子节点时取消父节点
		function setParentNodeCheck(node) {

			var parentNode = $( '#treeview' ).treeview( 'getParent' , node);
			if (parentNode.nodes) {
				var checkedCount = 0;
				for (var x in parentNode.nodes) {
					if (parentNode.nodes[x].state.checked) {
						checkedCount ++;
					}
				}
				if (checkedCount > 0) {  //如果子节点全部被选 父全选
					/*$("#treeview").treeview("checkNode", parentNode.nodeId);*/
					$( '#treeview' ).treeview( 'checkNode' , [ parentNode.nodeId, { silent:  true  } ]);
					setParentNodeCheck(parentNode);
				}
			/*	else {   //如果子节点未全部被选 父未全选
					$('#treeview').treeview('uncheckNode', parentNode.nodeId);
					setParentNodeCheck(parentNode);
				}*/
			}
		}

		// 取消父节点时 取消所有子节点
		function setChildNodeUncheck(node) {
			if (node.nodes) {
				var ts = [];    //当前节点子集中未被选中的集合
				for (var x in node.nodes) {
					if (!node.nodes[x].state.checked) {
						ts.push(node.nodes[x].nodeId);
					}
					if (node.nodes[x].nodes) {
						var getNodeDieDai = node.nodes[x];
						for (var j in getNodeDieDai) {
							/**
							 　　　　　　　　　　　　　* 原转载文章中写的是!getNodeDieDai.nodes[x].state.checked
							 　　　　　　　　　　　　　* 但是测试不可用、去掉.nodes[x]可用
							 　　　　　　　　　　　　　*/
							if (!getNodeDieDai.state.checked) {
								ts.push(getNodeDieDai[j]);
							}
						}
					}
				}
			}
			return ts;
		}