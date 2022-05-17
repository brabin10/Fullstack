import React from "react";
import { ChildComponent } from "../ChildComponent/ChildComponent";

//again, every Class component has two parameters, props and state
//by leaving the state parameter as "any", we can define whatever object we want to store state
//and we're leaving the props parameter empty, since we aren't sending any data to this componet
export class ParentComponent extends React.Component<{}, any>{

    //state object to store data
    //these are two pieces of data we intend to send to our child component
    state = {
        color: 'blue',
        animal: 'dog'
    }

    //if you don't create a constructor there will be default one
    //we usually don't need constructor in components 

    //this component has the ChildComponent nested, and sends it some state data  
     render () {
        return(
            <div>
                <h1>Hello from the parent component! My favorite color is: {this.state.color}</h1>
                <ChildComponent color={this.state.color} animal={this.state.animal}/>
                {/* This is how we comment in Tsx*/}

            </div>
        )
        //notice that we sent the state data as ATTRIBUTES in the ChildComponent
    }

}