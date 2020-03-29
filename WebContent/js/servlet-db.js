/**
 * 
 */
$(document).ready(function(){

	$("#book-input-form").submit(function(e){
		e.preventDefault();
	});

	$("#save-btn").click(function(e){
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

		$.post(url,param,function(){
			$("#id-input").val('');
			$("#issue-input").val('');
			$("#assignee-input").val('');
			$("#priority-input").val('Low');
		});

	});

	$("#view-btn").click(function(e){
		$.get('ServletDbController',function(response) {
			//console.log(response);
			var table="<tr><th>Issue ID</th><th>Issue Title</th><th>Assignee</th><th>Priority</th></tr>";
			var a = document.getElementById("issue_tracker")
			var obj = JSON.parse(response);
			for(var i=0;i<obj.length;i++){				
				table += "<tr>" +
				"<td>" +obj[i].issueId +"</td>"+
				"<td>" +obj[i].issueTitle +"</td>"+
				"<td>" +obj[i].assignee +"</td>"+
				"<td>" +obj[i].priority +"</td>"+
				"</tr>";
				document.getElementById("issue_tracker").innerHTML = table;
			}
			$("#view-btn").attr("disabled",true);			  	  
		});
	});
});