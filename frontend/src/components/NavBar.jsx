import Logo from "./Logo";
import "./NavBar.css";

const NavBar = () => {
  return (
    <div className = "nav">
      <Logo text={true} />
      <a href="/">Home</a>
      <a href="/about">About</a>
      <button>Log in</button>
      
    </div>
  );
}
 
export default NavBar;