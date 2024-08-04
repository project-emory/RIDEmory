import "./DropdownRide.css";
import RideInfo from "./RideInfo";
import { useState } from "react";

const DropdownRide = () => {
    let [isShowingDropdown, setIsShowingDropdown] = useState(false);

    const dummyRide = {
        time: "5:30 PM",
        departLocation: "Lorem ipsum",
        arriveLocation: "ATL",
        riders: 4,
        capacity: 6,
        walkingDistance: 0.2,
    };
    return (
        <div className="container">
            <div className="top-container">
                <div className="heading">
                    <h2 style={{ fontWeight: "800" }}>Rides</h2>
                    <button>
                        Sort by{" "}
                        <span style={{ marginLeft: "5px", fontSize: "10px" }}>
                            &#9660;
                        </span>
                    </button>
                </div>
                <div className="content-holder">
                    <div>
                        <RideInfo
                            setIsShowingDropdown={setIsShowingDropdown}
                            isShowingDropdown={isShowingDropdown}
                        />

                        {isShowingDropdown && (
                            <div>
                                <div className="space">
                                    <p style={{ color: "lightgray" }}>
                                        Available Space
                                    </p>
                                    <p>
                                        {dummyRide.riders}/{dummyRide.capacity}
                                    </p>
                                    <button>Join</button>
                                </div>

                                <div className="walking">
                                    <p style={{ color: "lightgray" }}>
                                        Walking Distance
                                    </p>
                                    <p>{dummyRide.walkingDistance} mi</p>
                                    <button>Save</button>
                                </div>
                            </div>
                        )}
                    </div>
                </div>
            </div>
        </div>
    );
};

export default DropdownRide;
