$(document).ready(function() {
	//初始化客户数据表格
	$("#customerDataGrid").datagrid({
		method : "get",
		url : "/customers/api/list",
		idField : "customerId",
		checkOnSelect : false,
		selectOnCheck : false,
		singleSelect : true,
		rownumbers : true,
		striped : true,
		fit : true,
		pagination : true,
		pagePosition : "bottom",
		pageSize : 20,
		pageList : [ 10, 20, 30, 50, 80 ],
		onClickRow: function(index, row) {
			//find all sites
			console.log(row);
			loadCustomerSites(row.customerId);
		},
		onDblClickRow : function(index, row) {
			editCustomer();
		}
	});

	// 绑定快速查询
	$("#customerSearch").searchbox({
		searcher : function(value, name) {
			if ($.trim(value).length > 0) {
				$("#customerDataGrid").datagrid("load", {
					searchValue : value
				});
			} else {
				$("#customerDataGrid").datagrid("load", {});
			}
			// 清空选中的行
			$('#customerDataGrid').datagrid('clearSelections');
		}
	});
});

var post_url;

// 打开创建新客户对话框
function newCustomer() {
	post_url = "/customers/api/new";
	$("#salesPerson").combotree("reload");
	$("#customerEditDlg").dialog("open").dialog("center").dialog("setTitle",
			"创建新客户");
	$("#customerEditForm").form("clear");
	var switchbuttonObj = $(".easyui-switchbutton[switchbuttonName='available']");
	switchbuttonObj.switchbutton("check");
}

// 打开编加客户对话框
function editCustomer() {
	var row = $("#customerDataGrid").datagrid("getSelected");
	if (row) {
		console.log(row);
		post_url = "/customers/api/" + row.customerId;
		$("#customerEditDlg").dialog("open").dialog("center").dialog("setTitle",
				"编辑客户");
		$("#customerEditForm").form("load", row);
		if (row.available) {
			var switchbuttonObj = $(".easyui-switchbutton[switchbuttonName='available']");
		    switchbuttonObj.switchbutton("check");
		}
	} else {
		$.messager.alert("提示", "没有选中的数据行");
	}
}

//保存客户
function saveCustomer() {
	console.log(post_url);
	$("#customerEditForm").form("submit", {
		url : post_url,
		onSubmit : function() {
			return $(this).form("validate");
		},
		success : function(data, textStatus) {
//			console.log(data);
//			console.log(textStatus);
			var data = eval('(' + data + ')'); //将字符串转为JSON对象
			if (data.state == 0) {
//				$.messager.alert("消息", "数据保存成功！", "info");
				$("#customerEditDlg").dialog("close"); // close the dialog
				$("#customerDataGrid").datagrid("reload"); // reload the customer data
			} else {
				$.messager.alert("错误", data.message, "error");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("status: " + textStatus);
			console.log("error: " + errorThrown);
		}
	});
}

// 删除客户
function deleteCustomer() {
	var row = $("#customerDataGrid").treegrid("getSelected");
	if (row) {
		$.messager.confirm("确认", "删除客户【" + row.customerName + "】？", function(r) {
			if (r) {
				$.ajax({
					url : "/customers/api/" + row.customerId,
					type : "DELETE",
					success : function(data, textStatus) {
						console.log(data);
						console.log(textStatus);
						if (data.state == 0) {
							$("#customerDataGrid").datagrid("reload");
							// 清空选中的行
							$('#customerDataGrid').datagrid('clearSelections');
						} else {
							$.messager.alert("错误", data.message, "error");
						}
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						console.log("status: " + textStatus);
						console.log("error: " + errorThrown);
					}
				});
			}
		});
	} else {
		$.messager.alert("提示", "没有选中的数据行");
	}
}



function loadCustomerSites(customerId) {
	//初始化客户数据表格
	$("#customerSiteDataGrid").datagrid({
		method : "get",
		url : "/customers/api/sites",
		idField : "siteId",
		checkOnSelect : false,
		selectOnCheck : false,
		singleSelect : true,
		rownumbers : true,
		striped : true,
		fit : true,
		pagination : true,
		pagePosition : "bottom",
		pageSize : 20,
		pageList : [ 10, 20, 30, 50, 80 ],
		onDblClickRow : function(index, row) {
			editCustomerSite();
		}
	});
}

function editCustomerSite() {
	//
}