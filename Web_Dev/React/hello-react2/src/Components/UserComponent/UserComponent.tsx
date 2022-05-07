import React from "react";

import { IUser } from "../../interfaces/IUser";

export class UserComponent extends React.Component<any,IUser> {

    constructor(props:any){
        super(props);
        this.state = {
            firstName: "",
            lasetName: "",
            userName: "",
            email: ""
        }
    }

    componentDidMount(){
        this.setState(
            {
                firstName: "Bon",
                lasetName: "Jovi",
                userName: "bigbon",
                email: "email@fakemail.com"
            }
        )
    }

    render() {
        return(
            <div>
            <h2>{this.state.firstName} {this.state.lasetName}</h2>
            <h3>{this.state.userName}</h3>
            <h3>{this.state.email}</h3>
            </div>
        )
    }
}