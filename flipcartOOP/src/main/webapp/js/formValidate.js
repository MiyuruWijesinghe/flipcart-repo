function validateInputs(inputName, inputId) {

	var placeHolderName = document.getElementById(inputId).placeholder;

	var msg = '';

	switch (inputName) {

	case 'firstName':
		msg = 'Must be Capital or Simple letters without any spaces.';
		break;
	case 'lastName':
		msg = 'Must be Capital or Simple letters without any spaces.';
		break;	
	case 'mobileNumber':
		msg = 'Invalid Contact Number.';
		break;
	case 'itemPrice':
		msg = 'Invalid Price.';
		break;
	case 'nic':
		msg = 'Invalid NIC Number.';
		break;
	case 'email':
		msg = 'Invalid Email Address.';
		break;	
	default:
		msg = 'Invalid Pattern.';
	}

	document.addEventListener("DOMContentLoaded", function() {

		var invalid = function(e) {
			if (e.target.validity.patternMismatch) {
				e.target.setCustomValidity(msg);
				return;
			}
			if (e.target.validity.rangeOverflow) {
				e.target.setCustomValidity(placeHolderName + ' length exceeded.');
				return;
			}
			if (e.target.validity.valueMissing) {
				e.target.setCustomValidity(placeHolderName + ' is required.');
				return;
			}
		};

		var user_inputs = document.getElementsByName(inputName);
		user_inputs[0].oninvalid = invalid;
		user_inputs[0].oninput = function(e) {
			e.target.setCustomValidity("");
		};
	});
}

function validateSave() {

	var userClick = confirm("Do you want to save changes?");

	if (userClick == true) {
		alert("Record saved successfully!");
		return true;
	} else {
		if (alert("Save canceled!") == true) {
			return false;
		}
		return false;
	}
}

function validateUpdate() {

	var userClick = confirm("Do you want to save changes?");

	if (userClick == true) {
		alert("Record updated successfully!");
		return true;
	} else {
		if (alert("Update canceled!") == true) {
			return false;
		}
		return false;
	}
}

function validateDelete() {

	var userClick = confirm("Do you want to delete this record?");

	if (userClick == true) {
		alert("Record deleted successfully!");
		return true;
	} else {
		if (alert("Delete canceled!") == true) {
			return false;
		}
		return false;
	}
}