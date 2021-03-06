import React from "react";

//notice props is of type any because we're excepted a state object from the parent component
//state we'll aslo make any so that we can create our main state based on the parent state

//the parent sends a state of any type, this child accepts props of any type. see the connection?
export class ChildComponent extends React.Component<any, any>{

    //this is constructor, which is one way to initialize a class  component and it's state
    //remember, "props" is the  variable coming in the left  parameter of this class declaration
    //this constructor takes in our props object, which has the data we'll use
    constructor(props:any) {
        super(props); // super calls the parent constructor
        //lets's initialize this component's state
        this.state = {
            favColor: props.color,
            favAnimal: props.animal
        }
    }
    //child component gets these values from its props, which is data coming from the parent
    render() {
        return(
            <div>
                <h3 style={{color:this.state.favColor}}>My parent's favorite color is : {this.state.favColor}</h3>
                <h3>My parent's favorite animal is: {this.state.favAnimal}</h3>

            </div>
            
        )
    }

}