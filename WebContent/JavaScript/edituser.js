function buttonFunction() {
	redirectpage(document.getElementById("editButton").closest('tr'));
}

function redirectpage(tr) {
	window.location="../editUser.jsp";
	document.getElementById("addusertable").appendChild(tr);
}