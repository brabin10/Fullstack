const url = "http://localhost:9898";
async function login() {
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    
    let user = {
        "username": username,
        "password": password
    }
        let response = await fetch(url +"/login",{
            method: "POST",
            body: JSON.stringify(user),

        })
    
    
            
        if(response.status === 202){
            let data = await response.json();
            if(data === 1){
                window.location= './employee-dash.html'; 
            }
            else{
                window.location = './finance-manager-dash.html';
            }
        }
        else {
            alert('invalid credentials');
        }
    }
    


