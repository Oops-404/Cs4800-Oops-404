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
  const [events, setEvents] = useState({});
  let headers = new Headers();

  // headers.append('Content-Type', 'application/json');
  // headers.append('Accept', 'application/json');
  // headers.append('Authorization', 'Basic ' + base64.encode(username + ":" +  password));
  // headers.append('Origin','http://localhost:8080');

  async function fetchData() {
    const res = await fetch("/events/",);
    res
      .json()
      .then(res => setEvents(res))
      .catch(err => setErrors(err));
  }

  useEffect(() => {
    fetchData();
  });
  
  return (
    <div>
    <GridContainer>
    <GridItem xs={12} sm={12} md={6}>
      <Card>
        <CardHeader color="primary">
          <h4 className={classes.cardTitle}>Full header coloured</h4>
          <p>Category subtitle</p>
        </CardHeader>
        <CardBody>
          <p>The place is close to Barceloneta Beach and bus stop just 2 min by
          walk and near to "Naviglio" where you can enjoy the main night
          life in Barcelona...
          </p>
          <Button color="primary">More Detail</Button>
        </CardBody>
      </Card>
    </GridItem>
    </GridContainer>
    <div>
    <span>{JSON.stringify(events)}</span>
    <hr />
    <span>Has error: {JSON.stringify(hasError)}</span>
  </div>
  </div>
  );
}
