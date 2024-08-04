import CreateOrFindRides from "../components/account page/create-or-find-rides/CreateOrFindRides.jsx";
import NavBar from "../components/NavBar.jsx";
import Rides from "../components/recent rides/Rides.jsx";
import Landing from "./Landing.jsx";
import "./Home.css";

const Home = () => {
    const isSignedIn = false;
    const isLandingPage = true;
    return (
        <>
            {!isSignedIn && (
                <div className="gradient-background">
                    <NavBar
                        isSignedIn={isSignedIn}
                        isLandingPage={isLandingPage}
                    />
                    <div className="center-vertical">
                        <Landing />
                    </div>
                </div>
            )}

            {isSignedIn && (
                <div className="gradient-background">
                    <NavBar
                        isSignedIn={isSignedIn}
                        isLandingPage={isLandingPage}
                    />
                    <CreateOrFindRides />
                    <Rides />
                </div>
            )}
        </>
    );
};

export default Home;
