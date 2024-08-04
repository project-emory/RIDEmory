import NavBar from "../components/NavBar";

const About = ({ isSignedIn }) => {
    return (
        <>
            <NavBar isSignedIn={isSignedIn} />
            <h1>About</h1>
        </>
    );
};

export default About;
