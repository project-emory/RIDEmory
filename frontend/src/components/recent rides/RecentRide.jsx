import "./RecentRide.css";

const RecentRide = ({ ride }) => {
    return (
        <div className="ride-container">
            <p className="ride-info">
                {ride.time} {ride.location}
            </p>
            <div className="ride-details">
                <img src="/../../public/user.png" alt="Silhouette Image" />
                <p>{ride.riders}</p>
            </div>
        </div>
    );
};

export default RecentRide;
