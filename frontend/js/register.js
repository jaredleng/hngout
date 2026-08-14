console.log("HNGOUT register JavaScript loaded");

let form = document.getElementById("registerForm");

form.addEventListener("submit", async function(event) {

    event.preventDefault();

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;
    let contactNumber = document.getElementById("contactNumber").value;
    let age = document.getElementById("age").value;
    let gender = document.getElementById("gender").value;

    let user = {
        name: name,
        email: email,
        password: password,
        contactNumber: contactNumber,
        age: Number(age),
        gender: gender
    };

    const response = await fetch("http://localhost:8080/auth/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    });

    if (response.ok) {

        let data = await response.json();

        document.getElementById("message").textContent =
            "Registration successful!";

        console.log(data);

    } else {

        let errorMessage = await response.text();

        document.getElementById("message").textContent =
            errorMessage;
    }

});