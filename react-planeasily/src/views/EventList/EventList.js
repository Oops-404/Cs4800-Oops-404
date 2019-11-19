import React from "react";
import GridItem from "components/Grid/GridItem.js";
import GridContainer from "components/Grid/GridContainer.js";
import Event from "./Event";

export default class EventList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            time: 'all',
            school: 'calpolypomona',
            category: 'asi',
            isLoaded: false,
            events1: [],
            url: "/events/"
        };

        this.handleTimeChange = this.handleTimeChange.bind(this);
        this.handleSchoolChange = this.handleSchoolChange.bind(this);
        this.handleCategoryChange = this.handleCategoryChange.bind(this);


    }

    handleTimeChange(event) {
        this.setState({isLoaded:false})
        let url = "/events/";
        switch(event.target.value){
            case "morning":
                    this.setState({ time: event.target.value});
                    url= "/events/startTime/morning";
                    break;
            case "afternoon":
                    this.setState({ time: event.target.value});
                    url= "/events/startTime/afternoon";

                    break;
            case "evening":
                    this.setState({ time: event.target.value});
                    url= "/events/startTime/evening";

                    break;
            case "night":
                    this.setState({ time: event.target.value,});
                    url= "/events/startTime/night";

                    break;
            default:
                    this.setState({ time: event.target.value});
                    break;
        }
        this.getEvent(url)

    }
    handleSchoolChange(event) {
        this.setState({school: event.target.value });


    }
    handleCategoryChange(event) {
        this.setState({ category: event.target.value });


    }


    componentDidMount() {
        this.getEvent("/events/");

    };

    getEvent(url){
        fetch(url)
            .then((response) => {
                return response.json();
            })
            .then(data => {
                this.setState({ events1: data, isLoaded: true })
            }).catch(error => {
                console.log(error);
            });
    }

    render() {
        const { time, school, category, events1, isLoaded, url } = this.state;
        if (!isLoaded) {
            return (
                <div>Loading...</div>
            )
        } else {
            return (
                <>
                    <GridContainer>
                        <GridItem xs={12} sm={12} md={4}>
                            <form>
                                <label>
                                    School:
                            </label>
                                <select value={school} onChange={this.handleSchoolChange}>
                                    <option value="calpolypomona">Cal Poly Pomona</option>
                                </select>
                            </form>
                        </GridItem>
                        <GridItem xs={12} sm={12} md={4}>
                            <form>
                                <label>
                                    Category:
                            </label>
                                <select value={category} onChange={this.handleCategoryChange}>
                                    <option value="asi">ASI</option>
                                </select>
                            </form>
                        </GridItem>
                        <GridItem xs={12} sm={12} md={4}>
                            <form>
                                <label>
                                    Time:
                            </label>
                                <select value={time} onChange={this.handleTimeChange}>
                                    <option value="all">All</option>
                                    <option value="morning">Morning</option>
                                    <option value="afternoon">Afternoon</option>
                                    <option value="evening">Evening</option>
                                    <option value="night">Night</option>
                                </select>
                            </form>
                        </GridItem>
                        <Event events={events1}></Event>
                    </GridContainer>
                </>

            )
        }
    }
}