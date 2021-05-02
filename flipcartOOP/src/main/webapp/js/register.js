
function validateForm() {

	var passw = document.getElementById("pass").value;
	var cpassw = document.getElementById("cpass").value;

	if (passw != cpassw) {
		document.getElementById("ename").innerHTML = "Password mismatch please enter the password again";
		return false;
	} else {
		return true;
	}
}

function enablesub() {

	var checker = document.getElementById('check').checked;

	if (checker == "") {
		alert("tik the box to show that ou agree with terms");
	}
	return true;

}
