import ConnectedAccounts from "../components/account page/ConnectedAccounts.jsx";
import NavBar from "../components/NavBar";
import RecentRides from "../components/recent rides/RecentRides.jsx";
import UserProfile from "../components/account page/UserProfile.jsx";
import "./Account.css";

const Account = () => {
    return (
        <>
            <NavBar isSignedIn={true} />
            <br />

            <div className="content-container">
                <div className="top-section">
                    <div>
                        <UserProfile />
                        <ConnectedAccounts />
                    </div>
                </div>

                <div className="bottom-section">
                    <div className="recent-rides">
                        <RecentRides />
                    </div>
                </div>
            </div>
        </>
    );
};

export default Account;
