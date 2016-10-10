
var GlobalInfo = {};	
var SelectedObjectInfo = undefined;
var LoginUserInfo = undefined;

var DATE_FORMAT = 'YYYY-MM-DD';

var DataTableLanguage = {
    "sSearch": "",
	"sLengthMenu": "_MENU_ 条记录/页",
	"sInfo": "显示第 _START_ ~ _END_ 条 / 共 _TOTAL_ 条",
    "sInfoEmpty": "显示 0 条 / 共 0 条",
    "sInfoFiltered": "（从 _MAX_ 条记录中过滤）",
	"oPaginate": {
		"sFirst": "第一页",
		"sPrevious": "上一页",
		"sNext": "下一页",
		"sLast": "最后一页"
	},
	"sEmptyTable": "没有数据",
	"sZeroRecords": "没有数据",
	"sLoadingRecords": "加载中...",
	"sProcessing": "处理中..."
}

/*
jQuery.fn.DataTable.defaults.sDom = "Tflt<'row DTTTFooter'<'col-sm-6'i><'col-sm-6'p>>";
jQuery.fn.DataTable.defaults.oLanguage = DataTableLanguage;
jQuery.fn.DataTable.defaults.bFilter = true;
jQuery.fn.DataTable.defaults.iDisplayLength = 10;
jQuery.fn.DataTable.defaults.bInfo = true;
jQuery.fn.DataTable.defaults.bPaginate = true;
jQuery.fn.DataTable.defaults.bProcessing = true;
jQuery.fn.DataTable.defaults.bServerSide = true;
*/

function getDataFromServerSideForDataTable(sSource, aoData, fnCallback){
	//alert(JSON.stringify(aoData));
	var jsonData = makeParametersForDataTable(aoData);
	//alert(JSON.stringify(jsonData));
	$.ajax({
		url: sSource, 
		type: "get",
		data: jsonData,
		success: function(data){
			if(data.code == 0){
				fnCallback(data.data);
			}else{
				loginExpiry(data.code,data.description);
			}
		}
	});
}

function makeParametersForDataTable(aoData){
	var jsonData = {
		echo: '',
		//filter: '',
		from: 0,
		max: 0,
		sort: '',
		order: ''
	};
	for(var i = 0; i < aoData.length; i ++){
		if(aoData[i].name == "sEcho"){
			jsonData.echo = aoData[i].value;
		}else if(aoData[i].name == "sSearch"){
			jsonData.filter = aoData[i].value;
		}else if(aoData[i].name == "iDisplayStart"){
			jsonData.from = aoData[i].value;
		}else if(aoData[i].name == "iDisplayLength"){
			jsonData.max = aoData[i].value;
		}else if(aoData[i].name == "iSortCol_0"){
			var colIndex = aoData[i].value;
			for(var j = 0; j < aoData.length; j ++){
				if(aoData[j].name == "mDataProp_" + colIndex){
					jsonData.sort = aoData[j].value;
					break;
				}
			}
		}else if(aoData[i].name == "sSortDir_0"){
			jsonData.order = aoData[i].value;
		}
	}
	return jsonData;
}

