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
            <div
                style={{
                    display: "flex",
                    flexDirection: "column",
                }}
            >
                <h1>Sign up!</h1>
                <input placeholder="Email" type="email"/>
                <input placeholder="Password"/>
                <button>Sign Up</button>
            </div>
        </div>
    );
};

export default SignUp