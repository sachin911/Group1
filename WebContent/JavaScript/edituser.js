function buttonFunction() {
	redirectpage(.closest(tr));
}

function redirectpage(tr) {
	window.location="../adminedituser";
	document.getElementById("addusertable").appendChild(tr);
}