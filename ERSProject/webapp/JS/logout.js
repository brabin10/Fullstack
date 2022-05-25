// const url = "http://localhost:9898";
//   function logout() {
//     let response = await fetch(url+"/login",{
//         method:"GET", 
//         body: JSON.stringify(user),
        
//     });
    
    
//     //let data = await response.json();


//          if(response.status ===200) {

//             window.location.href = './login.html';
//        } 
//         // else{
//         //     alert('failed to logout');
//          }
   async function logout() {
    fetch("http://localhost:9898/login", {
        method: "GET",
        mode: "no-cors",
        credentials: "include",
      }).then((response) => {
        if (response.status === 200) {
          // return response.status;
          window.location.href = "../login.html";
        } else if (response.status === 401) {
          return "Please try again!";
        }
      });
    }
   