import "./Logo.css";

const Logo = ({ text }) => {
  return (
    <div className="logo">
      <img src="/RIDE.svg" alt="logo" />
      {text && <p>RIDEmory</p>}
    </div>
  );
}
 
export default Logo;