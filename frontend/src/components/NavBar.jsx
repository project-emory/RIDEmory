import Logo from "./Logo";
import "./NavBar.css";

const NavBar = ({ isSignedIn, isLandingPage }) => {
    {
        /* isLandingPage allows the page to render the navbar as blue  */
    }

    console.log(isSignedIn);
    console.log(isLandingPage);
    return (
        <div
            className={`nav ${!isSignedIn && isLandingPage ? "signed-out" : ""}`}
            style={{ backgroundColor: "white" }}
        >
            <Logo text={true} />
            <div className="right">
                <a href="/">Home</a>
                <a href="/about">About</a>
                {isSignedIn && <a href="/account">Welcome, Ethan!</a>}
                {!isSignedIn && (
                    <a className="login-button" href="/login">
                        Log in
                    </a>
                )}
            </div>
        </div>
    );
};

export default NavBar;
