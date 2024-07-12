import ConnectedAccounts from "../components/ConnectedAccounts.jsx";
import NavBar from "../components/NavBar";
import RecentRides from "../components/RecentRides.jsx";
import UserProfile from "../components/UserProfile.jsx";
import './Account.css';

const Account = () => {
    return (
        <>
            <NavBar />
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
