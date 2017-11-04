function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"DeleteBatchServlet.action");
	$("#mainForm").submit();
}



function deleteOne(href){
	alert(href);
	$("#mainForm").attr('action',href).submit();
}