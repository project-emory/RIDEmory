import React from "react";

const SignUp = () => {
    return (
        <div
            style={{
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                height: "100vh"
            }}
        >
            <h1>Sign up!</h1>
            <input placeholder="Email" type="email"/>
            <input placeholder="Password"/>
        </div>
    );
};

export default SignUp