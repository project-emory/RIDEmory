import React from "react";
import {
    Nav,
    NavLink,
    Bars,
    NavMenu,
    NavBtn,
    NavBtnLink,
} from "./navbarElements"

const Navbar = () => {
    return (
        <> 
        <Nav>
            <Bars /> {/* hidden hamburger */}

            <NavMenu>
                <NavLink to="/home">
                    Home
                </NavLink>
                <NavLink to="/about">
                    About
                </NavLink>
                <NavLink to="/contact">
                    Contact
                </NavLink>
                <NavLink to="/sign-up">
                    Sign Up
                </NavLink>
            </NavMenu>
            <NavBtn to="/signin">
                <NavBtnLink to="/signin">
                    Sign In
                </NavBtnLink>
            </NavBtn>
        </Nav>
        </>
    );
};

export default Navbar;