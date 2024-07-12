import RecentRide from "./RecentRide"

const RecentRides = ( {recentRides }) => {
    const testRides = [
        {
            time: "6:10 pm",
            location: "Hmart Duluth",
            riders: 4
        },
        {
            time: "6:10 pm",
            location: "New Turman Hall",
            riders: 3
        },
        {
            time: "6:10 pm",
            location: "Lenox Mall",
            riders: 6
        },
        {
            time: "6:10 pm",
            location: "Woodruff Circle",
            riders: 3
        },
        {
            time: "6:10 pm",
            location: "Emory Decatur",
            riders: 4
        },
        {
            time: "6:10 pm",
            location: "Public",
            riders: 4
        },
        {
            time: "6:10 pm",
            location: "15 Eagle Row",
            riders: 4
        },
        
    ]

    return (
        <div style={{ marginTop: '0' }}>
            <h2>Recent Rides</h2>
            <h4>Today</h4>
                <ul>
                    {testRides.map((ride, index) => (
                        <RecentRide key={index} ride={ride} />
                    ))}
                </ul>
            <h4>3 Days Ago</h4>
            <h4>3/17 Sun</h4>   

            <h5>See full history</h5>      
        </div>
    )
}

export default RecentRides;