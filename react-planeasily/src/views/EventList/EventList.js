import React, { useState, useEffect } from "react";
// @material-ui/core components
import { makeStyles } from "@material-ui/core/styles";
// core components
import GridItem from "components/Grid/GridItem.js";
import GridContainer from "components/Grid/GridContainer.js";
import Card from "components/Card/Card.js";
import CardHeader from "components/Card/CardHeader.js";
import CardBody from "components/Card/CardBody.js";
import Button from "components/CustomButtons/Button.js";



const styles = {
  cardCategoryWhite: {
    "&,& a,& a:hover,& a:focus": {
      color: "rgba(255,255,255,.62)",
      margin: "0",
      fontSize: "14px",
      marginTop: "0",
      marginBottom: "0"
    },
    "& a,& a:hover,& a:focus": {
      color: "#FFFFFF"
    }
  },
  cardTitleWhite: {
    color: "#FFFFFF",
    marginTop: "0px",
    minHeight: "auto",
    fontWeight: "300",
    fontFamily: "'Roboto', 'Helvetica', 'Arial', sans-serif",
    marginBottom: "3px",
    textDecoration: "none",
    "& small": {
      color: "#777",
      fontSize: "65%",
      fontWeight: "400",
      lineHeight: "1"
    }
  }
};

const useStyles = makeStyles(styles);

export default function EventList() {
  const classes = useStyles();
  const [hasError, setErrors] = useState(false);
  const [events, setEvents] = useState([]);
  const abortController = new AbortController();
  const signal1 = abortController.signal;



  useEffect(() => {
    async function fetchData() {
      const res = await fetch("/events/", { signal: signal1 });
      res
        .json()
        .then(res => setEvents(res))
        .catch(err => setErrors(err));
        
    };
    fetchData();

    //cancel subscription by abort
    return function cleanup(){
      abortController.abort()
    }
  }, []);

  const objs = JSON.parse(JSON.stringify(events));
  var eventList = objs.map(function (e) {
    return (
      <GridItem xs={12} sm={12} md={6} key={e.eventId}>
        <Card>
          <CardHeader color="success">
            <h4 className={classes.cardTitle}>{e.name}</h4>
            <p>{e.location}</p>
          </CardHeader>
          <CardBody>
            <p>Start: {e.startDate}: {e.startTime}
              <br />
              End: {e.endDate}: {e.endTime}
            </p>
            <Button color="success">Add Event</Button>
          </CardBody>
        </Card>
      </GridItem>
    );
  })

  return (
    <div>
      <div>
        <GridContainer>
          {eventList}
        </GridContainer>
      </div>
    </div>
  );
}
