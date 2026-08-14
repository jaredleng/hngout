console.log("HNGOUT login JavaScript loaded");

let form = document.getElementById("loginForm");

form.addEventListener("submit", async function(event) {

    event.preventDefault();

    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    let user = {
        email: email,
        password: password
    };

    const response = await fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    });

    if (response.ok) {

        let data = await response.json();

        document.getElementById("message").textContent = "Login successful!";

        console.log(data);

    } else {

        let errorMessage = await response.text();

        document.getElementById("message").textContent = errorMessage;
    }

});