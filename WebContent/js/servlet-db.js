/**
 * 
 */
$(document).ready(function(){
	$("#save-btn").click(function(){
		var url="ServletDbController";	
		var issue = $("#issue-input").val();
		var assignee = $("#assignee-input").val();
		var priority = $("#priority-input").val();
		var id=1

		$.post(url,{
			issueInput : issue,
			assigneeInput : assignee,
			priorityInput : priority,
			idInput : id
		},alert("save button is clicked"));
	});

	$("#view-btn").click(function(){
		var url="view";
		$.post(url);
	});

	$("#back-btn").click(function(){
		alert("Back button is clicked");
	});
});