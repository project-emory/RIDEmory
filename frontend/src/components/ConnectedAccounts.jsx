import SocialListItem from "./SocialListItem";

const ConnectedAccounts = ( { socials } ) => {
    const socialsTest = ['email', 'phone', 'GroupMe'];
    return (
        <div>
            <h1 style={{ marginTop: '75px' }}>Connected Accounts</h1>
            <div>
                <ul>
                    {socialsTest.map((social, index) => (
                        <SocialListItem key={index} social={social} />
                    ))}
                </ul>
            </div>
        </div>
       
    )
}

export default ConnectedAccounts;