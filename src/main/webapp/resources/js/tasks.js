function onAddTask(data) {
	if (data.status == 'success') {
	    var taskTitleInput = document.getElementById('form:taskTitle');
	    taskTitleInput.value = '';
	    taskTitleInput.focus();
	}
}