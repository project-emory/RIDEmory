import React from "react";
import { Calendar, Navbar } from "../components";

const Rides = () => {
    return(
        <div className="rides">
            <Navbar activeLink="rides" />
            <Calendar />
        </div>
    )
}

export default Rides;