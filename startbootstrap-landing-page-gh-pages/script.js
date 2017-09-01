

let firstName;
let lastName;
let subjectChoice;
let text;


function getAboutDetails(){

   firstName = document.getElementById("fname").value;

   lastName = document.getElementById("lname").value;

   subjectChoice = document.getElementById("subject").value;

   text = document.getElementById("textArea").value;
   console.log(firstName, lastName, subjectChoice, text);
}