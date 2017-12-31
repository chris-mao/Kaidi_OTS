$(document).ready(function() {
	//初始化左侧部门树
	$("#departmentTree").tree({
        method:"get",
        url:"/departments/api/tree",
        animate:true,
        lines:true,
        onLoadSuccess: function(node, data) {
        	
        },
        onClick : function(node) {
            if (node) {
                console.log(node.id);
                $("#employeeDataGrid").datagrid({
                    method : "get",
                    url : "/departments/api/" + node.id + "/employees"
                });
            }
        }
	});
	
	//初始化员工数据表格
	$("#employeeDataGrid").datagrid({
		method : "get",
		url : "/employees/api/list",
		idField : "employeeId",
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
			editEmployee();
		}
	});

	// 绑定快速查询
	$("#employeeSearch").searchbox({
		searcher : function(value, name) {
			if ($.trim(value).length > 0) {
				$("#employeeDataGrid").datagrid("load", {
					searchValue : value
				});
			} else {
				$("#employeeDataGrid").datagrid("load", {});
			}
			// 清空选中的行
			$('#employeeDataGrid').datagrid('clearSelections');
		}
	});
});

var post_url;

// 打开创建新员工对话框
function newEmployee() {
	post_url = "/employees/api/new";
	$("#parentId").combotree("reload");
	$("#employeeEditDlg").dialog("open").dialog("center").dialog("setTitle",
			"创建新员工");
	$("#employeeEditForm").form("clear");
	var departmentNode = $("#departmentTree").tree("getSelected");
	if (departmentNode) {
		$("#employeeEditForm").form("load", {"departmentId":departmentNode.id});
	}
	var switchbuttonObj = $(".easyui-switchbutton[switchbuttonName='available']");
	switchbuttonObj.switchbutton("check");
}

// 打开编加员工对话框
function editEmployee() {
	var row = $("#employeeDataGrid").datagrid("getSelected");
	if (row) {
		console.log(row);
		post_url = "/employees/api/" + row.employeeId;
		$("#employeeEditDlg").dialog("open").dialog("center").dialog("setTitle",
				"编辑员工");
		$("#employeeEditForm").form("load", row);
		if (row.available) {
			var switchbuttonObj = $(".easyui-switchbutton[switchbuttonName='available']");
		    switchbuttonObj.switchbutton("check");
		}
	} else {
		$.messager.alert("提示", "没有选中的数据行");
	}
}

//保存员工
function saveEmployee() {
	console.log(post_url);
	$("#employeeEditForm").form("submit", {
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
				$("#employeeEditDlg").dialog("close"); // close the dialog
				$("#employeeDataGrid").datagrid("reload"); // reload the employee data
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

// 删除员工
function deleteEmployee() {
	var row = $("#employeeDataGrid").treegrid("getSelected");
	if (row) {
		$.messager.confirm("确认", "删除员工【" + row.employeeNum + " - " + row.employeeName + "】？", function(r) {
			if (r) {
				$.ajax({
					url : "/employees/api/" + row.employeeId,
					type : "DELETE",
					success : function(data, textStatus) {
						console.log(data);
						console.log(textStatus);
						if (data.state == 0) {
							$("#employeeDataGrid").datagrid("reload");
							// 清空选中的行
							$('#employeeDataGrid').datagrid('clearSelections');
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