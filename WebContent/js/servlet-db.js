/**
 * 
 */
$(document).ready(function(){
	$("#save-btn").click(function(){
		var url="ServletDbController";	
		var id=$("#id-input").val();
		var issue = $("#issue-input").val();
		var assignee = $("#assignee-input").val();
		var priority = $("#priority-input").val();

		var param = {
				idInput : id,
				issueInput : issue,
				assigneeInput : assignee,
				priorityInput : priority
		};

		$.post(url,param,function(response){
			$("#ajaxResponse").append("<b>Issue ID:</b> " + response['issueId']+"");
		});


	});

//	$("#view-btn").click(function(){
//	var i;
//	var xmlDoc = xml.responseXML;
//	var table="<tr><th>ID</th><th>Title</th><th>Assignee</th><th>Priority</th></tr>";
//	var x = xmlDoc.getElementsByTagName("CD");
//	for (i = 0; i <x.length; i++) { 
//	table += "<tr><td>" +
//	x[i].getElementsByTagName("ARTIST")[0].childNodes[0].nodeValue +
//	"</td><td>" +
//	x[i].getElementsByTagName("TITLE")[0].childNodes[0].nodeValue +
//	"</td></tr>";
//	}
//	document.getElementById("demo").innerHTML = table;

//	$("#back-btn").click(function(){
//	alert("Back button is clicked");
//	});
//	});

	$("#view-btn").click(function(){

//		$.ajax({type: "GET",
//		url: "ServletDbController",
//		dataType: "json",
//		success: function(response){
//		var resdata = response;
//		$("#ajaxResponse").html("");
//		$("#ajaxResponse").append("<b>Issue ID:</b> " + resdata['issueId']+"");
//		$("#ajaxResponse").append("<b>Issue Title:</b> " + resdata['issueTitle']+"");
//		$("#ajaxResponse").append("<b>Assignee:</b> " + resdata['assignee']+"");
//		$("#ajaxResponse").append("<b>Priority:</b> " + resdata['priority']+"");                                
//		}
//		});
		
		var idOne=$("#id-input").val();
		
		var paramOne = {
				idInput : idOne
		};

		$.get('ServletDbController',paramOne,function(responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        });
		

	});


});