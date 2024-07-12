import Logo from "./Logo";
import "./NavBar.css";

const NavBar = () => {
    return (
        <div className="nav" style={{ backgroundColor: "white" }}>
            <Logo text={true} />
            <div className="right">
                <a href="/">Home</a>
                <a href="/about">About</a>
                <a href="/account">Welcome, Ethan!</a>
            </div>
        </div>
    );
};

export default NavBar;
