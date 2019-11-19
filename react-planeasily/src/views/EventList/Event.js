import React from "react";
// @material-ui/core components
import { makeStyles } from "@material-ui/core/styles";
// core components
import GridItem from "components/Grid/GridItem.js";
import Card from "components/Card/Card.js";
import CardHeader from "components/Card/CardHeader.js";
import CardBody from "components/Card/CardBody.js";
import Button from "components/CustomButtons/Button.js";


const styles = {};

const useStyles = makeStyles(styles);

export default function Event(props) {
  const classes = useStyles();
  const events = props.events;




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
              <br />
              {e.description}
              <br />
              Categories: {e.category}
            </p>
            <Button color="success">Add Event</Button>
          </CardBody>
        </Card>
      </GridItem>
    );
  });

  return (
      <>{eventList}</>    
    );
}
