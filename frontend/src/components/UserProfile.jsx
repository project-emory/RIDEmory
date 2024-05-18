import "./UserProfile.css";

const UserProfile = () => {
    return (
        <div className="profile">
            <div className="left">
                <img src="/MiniAvatar.svg"></img>
                <div className="left-text">
                    <div className="name">
                        <div className="fullName">Ronald Richards</div>
                        <img src="./userId.svg" className="userId"></img>
                    </div>
                    <div className="insta">@tcurren34</div>
                </div>
            </div>
            <div className="right">
                <div className="rides">
                    <div className="num">23</div>
                    <div className="str">rides</div>
                </div>
                <div className="saved">
                    <div className="num">$103</div>
                    <div className="str">saved</div>
                </div>
            </div>
        </div>
    );
}

export default UserProfile;
