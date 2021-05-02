function validateForm(){
  var x = document.forms["form"]["userName"].value;
  var y = document.forms["form"]["password"].value;
  if (x == "" || y== "") {
    document.getElementById('ename').innerHTML = "All fields are required";
    return false;
  }
}