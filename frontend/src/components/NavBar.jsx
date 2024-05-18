import Logo from "./Logo";
import "./NavBar.css";

const NavBar = () => {
  return (
    <div className = "nav" style={{backgroundColor: 'white'}}>
      <Logo text={true} />
      <div className = "right">
        <a href="/">Home</a>
        <a href="/about">About</a>
        <button>Welcome, Ethan!</button>
      </div>
    </div>
  );
}
 
export default NavBar;