import Logo from "../../Pictures/AA.png";
import Logo2 from "../../Pictures/UBER.png";

function Support() {
    return (
        <div>
            <br />
            <h1 class="d-flex justify-content-center">"We want to support you!”</h1>
            <br />
            <br />
            <br />
            <h2>Alcoholics Anonymous</h2>
            <a href="https://www.alcoholics-anonymous.org.uk/" target="_blank">
                <img src={Logo} alt="Clickable Alcoholics Anonymous Logo"
                    aria-labelledby="Clickable Alcoholics Anonymous Logo to be taken to Alcoholics Anonymous page"
                    width="10%" height="10%" />
            </a>
            <div>
                Alcoholics Anonymous (AA) is a fellowship of men and women who share their experience,
                strength, and hope with each other. Their common goal is to solve the problem of alcoholism and
                help others recover from it. The only requirement for membership is a desire to stop drinking.
                AA operates on a self-supporting model, relying on contributions from its members rather than
                charging dues or fees.
            </div>
            <br />
            <br />
            <br />
            <h2>Uber</h2>
            <a href="https://www.uber.com/gb/en/ride/" target="_blank">
                <img src={Logo2} alt="Clickable Uber Logo"
                    aria-labelledby="Clickable Uber Logo to be taken to Uber page"
                    width="10%" height="10%" />
            </a>
            <div>
                When it comes to making the choice between driving under the influence and using a rideshare service
                like Uber, the evidence overwhelmingly supports the latter. Uber’s presence in cities has been
                associated with a decrease in alcohol-related crashes, and DUI arrests have declined significantly.
                Opting for an Uber ride when you’re intoxicated significantly reduces the chances of getting pulled
                over and arrested for driving under the influence. According to rider polling, 80% of Uber users say
                that the service has helped them personally avoid drinking and driving.
            </div>
        </div>
    );
}

export default Support;