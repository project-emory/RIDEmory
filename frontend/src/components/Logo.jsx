const Logo = ({ text }) => {
  return (
    <div>
      <img src="/RIDE.svg" alt="logo" />
      {text && <p>RIDEmory</p>}
    </div>
  );
}
 
export default Logo;