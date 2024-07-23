import "./RideInfo.css";

const RideInfo = ({ setIsShowingDropdown, isShowingDropdown }) => {
    function toggle(bool) {
        setIsShowingDropdown(!bool);
    }

    const dummyRide = {
        time: "5:30 PM",
        departLocation: "Lorem ipsum",
        arriveLocation: "ATL",
        riders: 4,
        capacity: 6,
        walkingDistance: 0.2,
    };
    return (
        <div>
            <div className="info">
                <p>
                    <strong>{dummyRide.time}</strong>
                </p>
                <p>
                    {dummyRide.departLocation}{" "}
                    <span style={{ fontSize: "12px", margin: "0 20px 0 20px" }}>
                        &#9654;
                    </span>{" "}
                    {dummyRide.arriveLocation}
                </p>
                {isShowingDropdown && (
                    <button onClick={() => toggle(isShowingDropdown)}>
                        &#9660;
                    </button>
                )}
                {!isShowingDropdown && (
                    <button onClick={() => toggle(isShowingDropdown)}>
                        &#9650;
                    </button>
                )}
            </div>
        </div>
    );
};

export default RideInfo;
