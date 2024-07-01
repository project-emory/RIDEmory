import "./Logo.css";

const Logo = ({ text }) => {
    return (
        <div className="logo">
            <div className="logo-img">
                <img className="air" src="/air.svg" alt="logo" />
                <img className="ride" src="/RIDE.svg" alt="logo" />
            </div>
            {text && <p className="logo-text">RIDEmory</p>}
        </div>
    );
};

export default Logo;
