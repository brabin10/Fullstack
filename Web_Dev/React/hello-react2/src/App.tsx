import React from 'react'; // we will always nee to do this in most logic files
import { FirstClassComponent } from './Components/FirstClassComponent/FirstClassComponent';
import { ParentComponent } from './Components/ParentComponent/ParentComponent';
import { UserComponent } from './Components/UserComponent/UserComponent';
//The App.tsx is our main page 
//The App.tsx file is where we put what we want displayed on the webpage
//You can add standard TSX, or entire components (which will have their ow TSX)
// the return() function is where we put what we want to render
function App() {
  //the return() function takes TSX (Typescript XML) and asks like HTML.  creates our view!
  return (
    <div className="App">
      <h1>Hello React</h1>
      <p>We are writing in TSX, which is like HTML for React</p>

      <FirstClassComponent/>
      <ParentComponent/>
      <UserComponent/>
    </div>
  );
}
//This lets us export this App.tsx to potentially be used in other applications. Which we wont't
export default App;
