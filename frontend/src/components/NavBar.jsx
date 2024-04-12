import Logo from "./Logo";

const NavBar = () => {
  return (
    <div>
      <Logo text={true} />
      <a href="/">Home</a>
      <a href="/about">About</a>
      <button>Log in</button>
    </div>
  );
}
 
export default NavBar;